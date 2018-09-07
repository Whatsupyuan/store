package com.captain.store.base.redis ;

import org.apache.ibatis.cache.CacheException;

import java.util.LinkedList;
import java.util.List;

/****************************************************************
 * 调用缓存基础算法<Redis>
 * 
 * @author by hr.yuan
 * @version 0.0.1-SNAPSHOT
 * @since 2016-12-26
 * 
 *
 *****************************************************************/
public interface RedisCL {

	/****************************************************************
	 * 添加单条string<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 *
	 *****************************************************************/
	public boolean setObjStr(final String region, final Object key, final String value) throws CacheException;

	/****************************************************************
	 * 添加缓存sadd<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param value
	 *****************************************************************/
	public boolean sAdd(final String region, final Object key, final String value) throws CacheException;

	/****************************************************************
	 * 添加缓存数据(set 类型为String)<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param value
	 *****************************************************************/
	public boolean setObj(final String region, final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 不添加区域缓存数据(zadd)<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 *****************************************************************/
	public boolean zaddObj(final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 不添加区域缓存数据并设置存活时间,<Redis> 并且指定生存时间，单位为：秒(zadd)
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *****************************************************************/
	public boolean zaddObj(final Object key, final Object value, final Integer seconds) throws CacheException;

	/****************************************************************
	 * 添加缓存数据(zadd)<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param value
	 *****************************************************************/
	public boolean zaddObj(final String region, final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 添加(有序)缓存数据(zadd)<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param i
	 * @param value
	 *****************************************************************/
	public boolean zaddObj(final String region, final Object key, final long i, final Object value) throws CacheException;

	/****************************************************************
	 * 添加(有序)缓存数据(String)<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param i
	 * @param value
	 *****************************************************************/
	public boolean zaddStr(final String region, final Object key, final long i, final String value) throws CacheException;

	/****************************************************************
	 * 删除不添加区域（key）缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-27
	 * 
	 * @param key
	 *****************************************************************/
	public void del(final String key) throws CacheException;

	/****************************************************************
	 * 删除（key）缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 *****************************************************************/
	public void evict(final Object key) throws CacheException;

	/****************************************************************
	 * 根据区域删除（key）缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * 
	 *****************************************************************/
	public void evict(final String region, final Object key) throws CacheException;

	/****************************************************************
	 * 批量删除缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param keys
	 *****************************************************************/
	@SuppressWarnings("rawtypes")
	public void evict(final List keys) throws CacheException;

	/****************************************************************
	 * 修改缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 *****************************************************************/
	public void updateSet(final String region, final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 修改缓存数据zadd<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param value
	 *****************************************************************/
	public void updateZadd(final String region, final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 修改指定缓存数据zadd<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param i
	 * @param value
	 *****************************************************************/
	public void updateZadd(final String region, final Object key, final long i, final Object value) throws CacheException;

	/****************************************************************
	 * 通过key获取对象<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 *****************************************************************/
	public Object get(final String region, final Object key) throws CacheException;

	/****************************************************************
	 * 通过key获取zadd对象<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 *****************************************************************/
	public Object getZadd(final String region, final Object key) throws CacheException;

	/****************************************************************
	 * 通过key获取zadd对象<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 *****************************************************************/
	public LinkedList<Object> getZadd(final Object key) throws CacheException;

	/****************************************************************
	 * 通过key获取zadd String 集合<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param start
	 * @param end
	 *****************************************************************/
	public List<String> getZaddStr(final String region, final Object key, final long start, final long end) throws CacheException;

	/****************************************************************
	 * 通过key获取zadd object 集合<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param region
	 * @param key
	 * @param start
	 * @param end
	 *****************************************************************/
	public List<Object> getZadd(final String region, final Object key, final long start, final long end) throws CacheException;

	/****************************************************************
	 * 集合添加缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 *****************************************************************/
	public Long Lpush(final String region, final Object key, final Object value) throws CacheException;

	/****************************************************************
	 * 把一个值添加对应的集合中<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param index
	 * @param value
	 *****************************************************************/
	public boolean Lset(final String region, final Object key, final long index, final Object value) throws CacheException;

	/****************************************************************
	 * 集合添加缓存数据，并且设置列表存活时间<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *****************************************************************/
	public Long Lpush(final String region, final Object key, final Object value, final long liveTime) throws CacheException;

	/****************************************************************
	 * 集合查询缓存数据<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 *            列表名
	 * @param start
	 *            开始位置
	 * @param end
	 *            结束位置
	 *****************************************************************/
	public List<Object> Lrange(final String region, final Object key, final long start, final long end) throws CacheException;

	/****************************************************************
	 * 删除指定列表中 index 值为value 的元素<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param index
	 * @param value
	 *****************************************************************/
	public void Lrem(final String region, final Object key, final long index, final Object value) throws CacheException;

	/****************************************************************
	 * 设置String类型的值，并且指定生存时间，单位为：秒<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *****************************************************************/
	public boolean set(final String key, final String value, final Integer seconds) throws CacheException;

	/****************************************************************
	 * 获取单条<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 *****************************************************************/
	public Object get(final String key) throws CacheException;

	/****************************************************************
	 * 设置生存时间，单位为：秒<Redis>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-26
	 * 
	 * @param key
	 * @param seconds
	 *****************************************************************/
	public boolean expire(final String key, final Integer seconds) throws CacheException;

	public Object getPtZadd(final String region, final Object key) throws CacheException;
	
	public boolean zaddStr(final String region, final Object key, final String value) throws CacheException;

	/**
	 * **************************************************************
	* incr : 自增key . value+1
	* 
	* @author by hr.yuan
	* @version 0.0.1-SNAPSHOT
	* @throws Exception
	* @since 2017年4月20日
	* @param key key名
	*
	****************************************************************
	 */
	public void incr(final Object key, long value) ;
	/**
	 * **************************************************************
	* set key 与 value值
	*
	* @author by hr.yuan
	* @version 0.0.1-SNAPSHOT
	* @throws Exception
	* @since 2017年4月24日
	*
	*
	****************************************************************
	 */
	public void set(final String key, final String value) ;

	/**
	 * @param key
	 * @param value
	 * @param order
	 * @return
	 */
	boolean zaddObjScope(String key, String value, Integer order);
	
	/**
	 * 查询set集合中的数量
	 * @param key
	 * @return
	 */
	public long scard(final String key);
}
