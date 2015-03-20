package com.penglecode.common.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.penglecode.common.serializer.ObjectSerializer;
import com.penglecode.common.serializer.protostuff.ProtostuffSerializer;

public class ProtostuffRedisSerializer implements RedisSerializer<Object> {

	private ObjectSerializer objectSerializer = new ProtostuffSerializer();
	
	public byte[] serialize(Object object) throws SerializationException {
		if(object != null){
			return objectSerializer.serialize(object);
		}
		return null;
	}

	public Object deserialize(byte[] bytes) throws SerializationException {
		if(bytes == null || bytes.length == 0){
			return null;
		}
		return objectSerializer.deserialize(bytes);
	}

}
