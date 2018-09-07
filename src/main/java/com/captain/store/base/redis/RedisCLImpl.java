package com.captain.store.base.redis;

import com.captain.store.util.JsonUtils;
import org.apache.ibatis.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@Qualifier("redisCLImpl")
public class RedisCLImpl implements RedisCL {

	@Autowired(required = false)
	@Qualifier("redisTemplate")
	// 如果Spring容器中有，就注入，没有就忽略
	protected RedisTemplate<Serializable, Serializable> redisTemplate;
	private String region;// redis区域

	/****************************************************************
	 * 生成缓存key<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 *****************************************************************/
	@SuppressWarnings({ "rawtypes" })
	private String getKeyName(final Object key) {
		if (key instanceof Number)
			return region + ":I:" + key;
		else {
			Class keyClass = key.getClass();
			if (String.class.equals(keyClass) || StringBuffer.class.equals(keyClass) || StringBuilder.class.equals(keyClass))
				return region + ":S:" + key;
		}
		return region + ":O:" + key;
	}

	private String getKeyPtName(final Object key) {
		return "PT_" + key;
	}

	@Override
	public boolean setObjStr(final String region, final Object key, final String value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;
						try {
							connection.set(getKeyName(key).getBytes(), redisTemplate.getStringSerializer().serialize(value));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public boolean setObj(final String region, final Object key, final Object value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;
						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.set(getKeyName(key).getBytes(), redisTemplate.getStringSerializer().serialize(objectJson));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public boolean zaddObj(String region, final Object key, final Object value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.zAdd(getKeyName(key).getBytes(), 0, redisTemplate.getStringSerializer().serialize(objectJson));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public boolean zaddObj(final String region, final Object key, final long i, final Object value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.zAdd(getKeyName(key).getBytes(), i, redisTemplate.getStringSerializer().serialize(objectJson));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public boolean zaddStr(final String region, final Object key, final long i, final String value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;
						try {
							connection.zAdd(getKeyName(key).getBytes(), i, redisTemplate.getStringSerializer().serialize(value));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public void evict(Object key) throws CacheException {
		try {
			redisTemplate.delete(getKeyName(key));
		} catch (Exception e) {
			throw new CacheException(e);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void evict(List keys) throws CacheException {
		if (keys == null || keys.size() == 0)
			return;
		try {
			String[] okeys = new String[keys.size()];
			for (int i = 0; i < okeys.length; i++) {
				okeys[i] = getKeyName(keys.get(i));
			}
			redisTemplate.delete(okeys);

		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public void updateSet(String region, Object key, Object value) throws CacheException {
		setObj(region, key, value);
	}

	@Override
	public void updateZadd(String region, Object key, Object value) throws CacheException {
		zaddObj(region, key, value);

	}

	@Override
	public void updateZadd(String region, Object key, long i, Object value) throws CacheException {
		zaddObj(region, key, i, value);
	}

	@Override
	public Object get(final String region, final Object key) throws CacheException {
		this.region = region;
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Object obj = null;
				try {
					if (null == key)
						return null;
					byte[] b = connection.get(getKeyName(key).getBytes());
					if (b != null)
						obj = redisTemplate.getStringSerializer().deserialize(b);// 反序列化
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return obj;
			}
		});
	}

	@Override
	public Object getZadd(final String region, final Object key) throws CacheException {
		this.region = region;
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Object obj = null;
				try {
					if (null == key)
						return null;
					Set<byte[]> l = connection.zRange(getKeyName(key).getBytes(), 0, 0);
					if (l != null)
						for (byte[] s : l) {
							obj = redisTemplate.getStringSerializer().deserialize(s);// 反序列化
						}
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return obj;
			}
		});
	}

	@Override
	public Object getPtZadd(final String region, final Object key) throws CacheException {
		this.region = region;
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Object obj = null;
				try {
					if (null == key)
						return null;
					Set<byte[]> l = connection.zRange(getKeyPtName(key).getBytes(), 0, 0);
					if (l != null)
						for (byte[] s : l) {
							obj = redisTemplate.getStringSerializer().deserialize(s);// 反序列化
						}
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return obj;
			}
		});
	}

	@Override
	public List<String> getZaddStr(final String region, final Object key, final long start, final long end) throws CacheException {
		this.region = region;
		final List<String> list = new ArrayList<String>();
		redisTemplate.execute(new RedisCallback<List<String>>() {
			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (null == key)
						return null;
					Set<byte[]> l = connection.zRange(getKeyName(key).getBytes(), start, end);
					if (l != null)
						for (byte[] s : l) {

							list.add(new String(s, "utf-8"));// 反序列化
						}

				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return list;
			}
		});
		return list;
	}

	@Override
	public List<Object> getZadd(final String region, final Object key, final long start, final long end) throws CacheException {
		this.region = region;
		final List<Object> list = new ArrayList<Object>();
		redisTemplate.execute(new RedisCallback<List<Object>>() {
			@Override
			public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (null == key)
						return null;
					Set<byte[]> l = connection.zRange(getKeyName(key).getBytes(), start, end);
					if (l != null)
						for (byte[] s : l) {
							list.add(redisTemplate.getStringSerializer().deserialize(s));// 反序列化
						}
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return list;
			}
		});
		return list;
	}

	@Override
	public Long Lpush(final String region, final Object key, final Object value) throws CacheException {
		this.region = region;
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (key == null || value == null)
						return null;
					String objectJson = JsonUtils.toFastjson(value);
					return connection.lPush(getKeyName(key).getBytes(), redisTemplate.getStringSerializer().serialize(objectJson));
				} catch (Exception ex) {
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
			}
		});
		return result;
	}

	@Override
	public boolean Lset(final String region, final Object key, final long index, final Object value) throws CacheException {
		this.region = region;
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean broken = false;
				try {
					if (key == null || index == 0 || value == null)
						return false;
					String objectJson = JsonUtils.toFastjson(value);
					connection.lSet(getKeyName(key).getBytes(), index, redisTemplate.getStringSerializer().serialize(objectJson));
					broken = true;
				} catch (Exception ex) {
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
				return broken;
			}
		});
	}

	@Override
	public Long Lpush(final String region, final Object key, final Object value, final long liveTime) throws CacheException {
		this.region = region;
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (key == null || value == null)
						return null;
					String objectJson = JsonUtils.toFastjson(value);
					Long returnl = connection.lPush(getKeyName(key).getBytes(), redisTemplate.getStringSerializer().serialize(objectJson));
					connection.expire(getKeyName(key).getBytes(), liveTime);
					return returnl;
				} catch (Exception ex) {
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
			}
		});
		return result;
	}

	@Override
	public List<Object> Lrange(final String region, final Object key, final long start, final long end) throws CacheException {
		this.region = region;
		final List<Object> lists = new ArrayList<Object>();
		redisTemplate.execute(new RedisCallback<List<Object>>() {

			@Override
			public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (null == key)
						return null;
					List<byte[]> list = connection.lRange(getKeyName(key).getBytes(), start, end);
					if (list != null)
						for (byte[] s : list) {
							lists.add(redisTemplate.getStringSerializer().deserialize(s));// 反序列化
						}
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						evict(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return lists;
			}
		});
		return lists;
	}

	@Override
	public void Lrem(final String region, final Object key, final long index, final Object value) throws CacheException {
		redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (key == null || value == null)
						return null;
					String objectJson = JsonUtils.toFastjson(value);
					return connection.lRem(getKeyName(key).getBytes(), index, redisTemplate.getStringSerializer().serialize(objectJson));
				} catch (Exception ex) {
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
			}
		});
	}

	@Override
	public boolean sAdd(String region, final Object key, final String value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;
						try {
							connection.sAdd(getKeyName(key).getBytes(), redisTemplate.getStringSerializer().serialize(value));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public boolean set(final String key, final String value, final Integer seconds) throws CacheException {

		boolean bool = false;

		bool = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean broken = false;
				try {
					connection.set(key.getBytes(), redisTemplate.getStringSerializer().serialize(value));
					// 设置生存时间
					connection.expire(key.getBytes(), seconds);
					broken = true;
				} catch (Exception ex) {
					broken = false;
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
				return broken;
			}
		});

		return bool;
	}

	@Override
	public Object get(final String key) throws CacheException {
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Object obj = null;
				try {
					if (null == key)
						return null;
					byte[] b = connection.get(key.getBytes());
					if (b != null)
						obj = redisTemplate.getStringSerializer().deserialize(b);// 反序列化
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						del(key);// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return obj;
			}
		});
	}

	@Override
	public void del(String key) throws CacheException {
		try {
			redisTemplate.delete(key);
		} catch (Exception e) {
			throw new CacheException(e);
		}

	}

	@Override
	public boolean expire(final String key, final Integer seconds) throws CacheException {

		boolean bool = false;

		bool = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean broken = false;
				try {
					// 设置生存时间
					connection.expire(key.getBytes(), seconds);
					broken = true;
				} catch (Exception ex) {
					broken = false;
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
				return broken;
			}
		});

		return bool;
	}

	@Override
	public void evict(String region, Object key) throws CacheException {
		if (region != null && key != null) {
			this.region = region;
			try {
				redisTemplate.delete(getKeyName(key));
			} catch (Exception e) {
				throw new CacheException(e);
			}
		}

	}

	@Override
	public boolean zaddObj(final Object key, final Object value) throws CacheException {
		boolean bool = false;
		if (key != null) {
			if (value == null) {
				del(getKeyPtName(key));
			} else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.zAdd(getKeyPtName(key).getBytes(), 0, redisTemplate.getStringSerializer().serialize(objectJson));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public LinkedList<Object> getZadd(final Object key) throws CacheException {
		return redisTemplate.execute(new RedisCallback<LinkedList<Object>>() {
			@Override
			public LinkedList<Object> doInRedis(RedisConnection connection) throws DataAccessException {
				Object obj = null;
				LinkedList<Object> linkList = new LinkedList<Object>() ;
				try {
					if (null == key)
						return null;
					Set<byte[]> l = connection.zRange(key.toString().getBytes(), 0, -1);
					if (l != null)
						for (byte[] s : l) {
							obj = redisTemplate.getStringSerializer().deserialize(s);// 反序列化
							linkList.add(obj) ; 
						}
				} catch (Exception ex) {
					if (ex instanceof IOException || ex instanceof NullPointerException)
						del(getKeyPtName(key));// 删除缓存key
				} finally {
					connection.close();// 关闭本次连接
				}
				return linkList;
			}
		});
	}

	@Override
	public boolean zaddObj(final Object key, final Object value, final Integer seconds) throws CacheException {
		boolean bool = false;
		if (key != null) {
			if (value == null) {
				del(getKeyPtName(key));
			} else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.zAdd(getKeyPtName(key).getBytes(), 0, redisTemplate.getStringSerializer().serialize(objectJson));
							// 设置生存时间
							connection.expire(getKeyPtName(key).getBytes(), seconds);
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}
	
	@Override
	public boolean zaddStr(String region, final Object key, final String value) throws CacheException {
		boolean bool = false;
		if (region != null && key != null) {
			this.region = region;
			if (value == null)
				evict(getKeyName(key).getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							connection.zAdd(getKeyName(key).getBytes(), 0, redisTemplate.getStringSerializer().serialize(value));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		}
		return bool;
	}

	@Override
	public void incr(final Object key , final long value) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if(null != key) {
			bool = redisTemplate.execute(new RedisCallback<Boolean>() {
				@Override
				public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
					boolean broken = false;
					try {
						connection.incrBy(String.valueOf(key).getBytes() , value);
						broken = true;
					} catch (Exception ex) {
						broken = false;
						throw new CacheException(ex);
					} finally {
						connection.close();// 关闭本次连接
					}
					return broken;
				}
			});
		}
	}

	@Override
	public void set(final String key, final String value) {
		// TODO Auto-generated method stub
		if(null != key && null != value) {
			redisTemplate.execute(new RedisCallback<Boolean>() {
				@Override
				public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
					boolean broken = false;
					try {
						connection.set(key.getBytes() , value.getBytes());
						broken = true;
					} catch (Exception ex) {
						broken = false;
						throw new CacheException(ex);
					} finally {
						connection.close();// 关闭本次连接
					}
					return broken;
				}
			});
		}
	}

	/* (non-Javadoc)
	 * @see com.digitalpublishing.framework.redis.base.RedisCL#zaddObjScope(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean zaddObjScope(final String key, final String value, final Integer order) {
		boolean bool = false;
			if (value == null)
				evict(key.getBytes());
			else {
				bool = redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						boolean broken = false;

						try {
							String objectJson = JsonUtils.toFastjson(value);
							connection.zAdd(key.getBytes(), order, redisTemplate.getStringSerializer().serialize(objectJson));
							broken = true;
						} catch (Exception ex) {
							broken = false;
							throw new CacheException(ex);
						} finally {
							connection.close();// 关闭本次连接
						}
						return broken;
					}
				});
			}
		return bool;
	}

	/**
	 * 查询set集合中的数量
	 * @param key
	 * @return
	 */
	@Override
	public long scard(final String key) {
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					if (key == null)
						return null;
					Long returnl = connection.sCard(key.getBytes());
					return returnl;
				} catch (Exception ex) {
					throw new CacheException(ex);
				} finally {
					connection.close();// 关闭本次连接
				}
			}
		});
		return result;
	}

}
