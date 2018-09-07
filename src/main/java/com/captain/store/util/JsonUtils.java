package com.captain.store.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

/****************************************************************
 * jackson 工具类
 * 
 * @author by
 * @version 0.0.1-SNAPSHOT
 * @since 2016-10-14
 * 
 *
 *****************************************************************/
public class JsonUtils {
	
	private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	private  static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getInstance() {
        //转化不为空的实体
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
           //允许出现特殊字符和转义符
          //objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
         //允许出现单引号
        //objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true) ;
        return objectMapper;
    }

    /****************************************************************
     * javaBean,list,array convert to json string
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    public static String obj2json(Object obj)  {
        try {

			return getInstance().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
            logger.error("对象转json异常{}",e.fillInStackTrace());
		}
        return "";
    }

 
    /****************************************************************
     * json string convert to javaBean
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    public static <T> T json2pojo(String jsonStr, Class<T> clazz){
        try {
			return getInstance().readValue(jsonStr, clazz);
		} catch (Exception e) {
            logger.error("json转对象异常{}", e.fillInStackTrace());
		} 
        return null;
    }

    /****************************************************************
     * json string convert to map
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    @SuppressWarnings("unchecked")
	public static <T> Map<String, Object> json2map(String jsonStr)
            throws Exception {
        return getInstance().readValue(jsonStr, Map.class);
    }

    /****************************************************************
     * json string convert to map with javaBean
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = getInstance().readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }


    /****************************************************************
     * json array string convert to list with javaBean
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = getInstance().readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }


    /****************************************************************
     * map convert to javaBean
     * 
     * @author by
     * @version 0.0.1-SNAPSHOT
     * @since 2016-10-14
     * 
     *
     *****************************************************************/
    @SuppressWarnings("rawtypes")
	public static <T> T map2pojo(Map map, Class<T> clazz) {
        return getInstance().convertValue(map, clazz);
    }
    
    /****************************************************************
	 * 将List对象序列化为JSON文本.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *
	 *****************************************************************/
	public static <T> String toJSONString(List<T> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	/****************************************************************
	 * 将对象序列化为JSON文本[{}].<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *
	 *****************************************************************/
	public static String toJSONString(Object object){
		JSONArray jsonArray = JSONArray.fromObject(object);
	    return jsonArray.toString();
	}

	/****************************************************************
	 * Java对象转化成JSON对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param obj
	 *****************************************************************/
	public static JSONObject toJsonObject(Object obj, String...fields){
//		JSONObject jObj = new JSONObject();
//		Field[] oFields = obj.getClass().getDeclaredFields();
//		for(Field field : oFields){
//			if("serialVersionUID".equals(field.getName())){
//				continue;
//			}
//			if("buttons".equals(field.getName())){
//				continue;
//			}
//			if(StringUtils.hasStr(fields, field.getName())){
//				continue;
//			}
//			Object value = Reflections.getFieldValueNew(obj, field.getName());
//
//			if(ObjectUtil.isNull(value)){
//				jObj.element(field.getName(), "");
//			}else{
//				jObj.element(field.getName(), value);
//			}
//		}
//		return jObj;
		return null ;
	}

	/****************************************************************
	 * 将对象转换纯json文本格式｛｝方法1.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static String toJson(Object object){
		JSONObject jsonStr=JSONObject.fromObject(object);
		return toJSONString(jsonStr);
	}

	/****************************************************************
	 * 将对象转换纯json文本格式｛｝方法2.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static String toFastjson(Object object){
//		String fastJson=com.alibaba.fastjson.JSON.toJSONString(object);
//		return fastJson.toString();
		return null ;
	}

	/****************************************************************
	 * 将JSON对象数组序列化为JSON文本.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static String toJSONString(JSONArray jsonArray){
		return jsonArray.toString();
	}

	/****************************************************************
	 * 将JSON对象序列化为JSON文本.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static String toJSONString(JSONObject jsonObject){
		return jsonObject.toString();
	}
	
	/****************************************************************
	 * 将对象转换为List对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List toArrayList(Object object){
		List arrayList = new ArrayList();
		JSONArray jsonArray = JSONArray.fromObject(object);
		Iterator it = jsonArray.iterator();
		while (it.hasNext()){
			JSONObject jsonObject = (JSONObject) it.next();
			Iterator keys = jsonObject.keys();
			 while (keys.hasNext()){
				 Object key = keys.next();
				 Object value = jsonObject.get(key);
				 arrayList.add(value);
			 }
		}
		 return arrayList;
	}

	/****************************************************************
	 * 将对象转换为Collection对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings("rawtypes")
	public static Collection toCollection(Object object){
		JSONArray jsonArray = JSONArray.fromObject(object);
		return JSONArray.toCollection(jsonArray);
	}
	
	/****************************************************************
	 * 将对象转换为JSON对象数组.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static JSONArray toJSONArray(Object object){
		return JSONArray.fromObject(object);
	}

	/****************************************************************
	 * 将对象转换为JSON对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	public static JSONObject toJSONObject(Object object){
		 return JSONObject.fromObject(object);
	}
	
	/****************************************************************
	 * 将对象转换为HashMap.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings("rawtypes")
	public static HashMap toHashMap(Object object){
		HashMap<String, Object> data = new HashMap<String, Object>();
		JSONObject jsonObject = JsonUtils.toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()){
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}
	
	/****************************************************************
	 * 将对象转换为List<Map<String,Object>>.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings("rawtypes")
	public static List<Map<String, Object>> toList(Object object){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = JSONArray.fromObject(object);
		for (Object obj : jsonArray){
			JSONObject jsonObject = (JSONObject) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator it = jsonObject.keys();
			while (it.hasNext()){
				String key = (String) it.next();
				Object value = jsonObject.get(key);
				map.put((String) key, value);
			}
			list.add(map);
		}
		return list;
	}
	
	/****************************************************************
	 * 将JSON对象数组转换为传入类型的List.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass){
		return JSONArray.toList(jsonArray, objectClass);
	}
	
	/****************************************************************
	 * 将对象转换为传入类型的List.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> List<T> toList(Object object, Class<T> objectClass){
		JSONArray jsonArray = JSONArray.fromObject(object);
		return JSONArray.toList(jsonArray, objectClass);
	}
	public static void main(String[] args) {
	/*	JSONUtils u  = new  JSONUtils();
		UserD zhuoxuan = new UserD();
		zhuoxuan.setUserId("111");
		zhuoxuan.setSax("23");
		zhuoxuan.setUnick("");
		zhuoxuan.setName("zhangsan");
		List<UserD> s= u.toList(zhuoxuan, UserD.class);*/
	}
	
	/****************************************************************
	 * 将JSON对象转换为传入类型的对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass){
		return (T) JSONObject.toBean(jsonObject, beanClass);
	}
	
	/****************************************************************
	 * 将将对象转换为传入类型的对象.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 *****************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T toBean(Object object, Class<T> beanClass){
		JSONObject jsonObject = JSONObject.fromObject(object);
         JsonConfig jsonConfig = new JsonConfig();
         jsonConfig.setRootClass(beanClass);
           
       
		return (T) JSONObject.toBean(jsonObject, jsonConfig);
	}

	/****************************************************************
	 * 将JSON文本反序列化为主从关系的实体.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param <T> 泛型T 代表主实体类型
	 * @param <D> 泛型D 代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName 从实体类在主实体类中的属性名称
	 * @param detailClass 从实体类型
	 *****************************************************************/
	public static <T, D> T toBean(String jsonString, Class<T> mainClass,
                                  String detailName, Class<D> detailClass){
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray = (JSONArray) jsonObject.get(detailName);
		
		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
		List<D> detailList = JsonUtils.toList(jsonArray, detailClass);
		try {
			BeanUtils.setProperty(mainEntity, detailName, detailList);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		 return mainEntity;
	}
	
	/****************************************************************
	 * 将JSON文本反序列化为主从关系的实体.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param <T>泛型T 代表主实体类型
	 * @param <D1>泛型D1 代表从实体类型
	 * @param <D2>泛型D2 代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName1 从实体类在主实体类中的属性
	 * @param detailClass1 从实体类型
	 * @param detailName2 从实体类在主实体类中的属性
	 * @param detailClass2 从实体类型
	 *****************************************************************/
	public static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass,
                                       String detailName1, Class<D1> detailClass1, String detailName2, Class<D2> detailClass2){
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
		
		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JsonUtils.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JsonUtils.toList(jsonArray2, detailClass2);
		
		try {
			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		return mainEntity;
	}
	
	/****************************************************************
	 * 将JSON文本反序列化为主从关系的实体.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param <T>泛型T 代表主实体类型
	 * @param <D1>泛型D1 代表从实体类型
	 * @param <D2>泛型D2 代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName1 从实体类在主实体类中的属性
	 * @param detailClass1 从实体类型
	 * @param detailName2 从实体类在主实体类中的属性
	 * @param detailClass2 从实体类型
	 * @param detailName3 从实体类在主实体类中的属性
	 * @param detailClass3 从实体类型
	 *****************************************************************/
	public static <T, D1, D2, D3> T toBean(String jsonString,
                                           Class<T> mainClass, String detailName1, Class<D1> detailClass1,
                                           String detailName2, Class<D2> detailClass2, String detailName3,
                                           Class<D3> detailClass3){
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
		JSONArray jsonArray3 = (JSONArray) jsonObject.get(detailName3);
		
		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JsonUtils.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JsonUtils.toList(jsonArray2, detailClass2);
		List<D3> detailList3 = JsonUtils.toList(jsonArray3, detailClass3);
		
		try {
			 BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			 BeanUtils.setProperty(mainEntity, detailName2, detailList2);
			 BeanUtils.setProperty(mainEntity, detailName3, detailList3);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		return mainEntity;
	}
	
	/****************************************************************
	 * 将JSON文本反序列化为主从关系的实体.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param <T> 主实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailClass 存放了多个从实体在主实体中属性名称和类型
	 *****************************************************************/
	@SuppressWarnings("rawtypes")
	public static <T> T toBean(String jsonString, Class<T> mainClass,
                               HashMap<String, Class> detailClass){
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
		for (Object key : detailClass.keySet()){
			try {
				Class value = (Class) detailClass.get(key);
				BeanUtils.setProperty(mainEntity, key.toString(), value);
			} catch (Exception ex) {
				throw new RuntimeException("主从关系JSON反序列化实体失败！");
			}
		}
		return mainEntity;
	}
	
	

	/****************************************************************
	 * 根据json和属性值返回对应Map类型实体，key：属性名；value：属性值.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param json
     * @param map 实体类对应属性值
     * @return
	 *****************************************************************/
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getObject(String json, Map map) {
        Map<String, Object> jsonObject = null;
        try {
            jsonObject = JSONObject.fromObject(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


	/****************************************************************
	 * 根据json返回List<Map>类型实体集合，key：属性名；value：属性值.<JSON工具>
	 * 
	 * @author by
	 * @version 0.0.1-SNAPSHOT
	 * @since 2016-05-23
	 * 
	 * @param json
     * @return
	 *****************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<String, Object>> getObjectList(String json) {
        JSONArray array = JSONArray.fromObject(json);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Iterator iter = array.iterator(); iter.hasNext();) {
			Map<String, Object> jsonObject = (Map<String, Object>) iter.next();
            list.add(jsonObject);
        }
        return list;
    }

	

}
