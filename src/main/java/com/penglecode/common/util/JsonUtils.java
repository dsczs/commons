package com.penglecode.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * 基于alibaba的fastjson框架的json数据序列化与反序列化工具类
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月20日 下午7:58:15
 * @version  	1.0
 */
public class JsonUtils {

	static {
		/**
		 * 设置序列化时的全局日期格式
		 */
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	}
	
	/**
	 * <p>将java对象序列化为json字符串(其中String类型字段的值为null时将序列化为空串"")</p>
	 * 
	 * @param object
	 * @return
	 */
	public static String object2Json(Object object){
		return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * <p>将java对象序列化为json字符串</p>
	 * 
	 * @param object
	 * @param serializerFeatures
	 * @return
	 */
	public static String object2Json(Object object, SerializerFeature... serializerFeatures){
		return JSON.toJSONString(object, serializerFeatures);
	}
	
	/**
	 * <p>将json字符串反序列化为java对象</p>
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T json2Object(String json, Class<T> clazz){
		return JSON.parseObject(json, clazz, Feature.DisableCircularReferenceDetect);
	}
	
	/**
	 * <p>将json字符串反序列化为java对象</p>
	 * 
	 * @param json
	 * @param clazz
	 * @param features
	 * @return
	 */
	public static <T> T json2Object(String json, Class<T> clazz, Feature... features){
		return JSON.parseObject(json, clazz, features);
	}
	
	/**
	 * <p>将json字符串反序列化为java对象(支持泛型)</p>
	 * 
	 * @param json
	 * @param typeReference
	 * @return
	 */
	public static <T> T json2Object(String json, TypeReference<T> typeReference){
		return JSON.parseObject(json, typeReference, Feature.DisableCircularReferenceDetect);
	}
	
	/**
	 * <p>将json字符串反序列化为java对象(支持泛型)</p>
	 * 
	 * @param json
	 * @param typeReference
	 * @param features
	 * @return
	 */
	public static <T> T json2Object(String json, TypeReference<T> typeReference, Feature... features){
		return JSON.parseObject(json, typeReference, features);
	}
	
}
