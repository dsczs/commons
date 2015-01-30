package com.penglecode.common.redis.core;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.penglecode.common.redis.serializer.ProtostuffRedisSerializer;

public class ProtostuffRedisTemplate extends RedisTemplate<String, Object> {

	public ProtostuffRedisTemplate() {
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		RedisSerializer<Object> protostuffSerializer = new ProtostuffRedisSerializer();
		setKeySerializer(stringSerializer);
		setValueSerializer(protostuffSerializer);
		setHashKeySerializer(stringSerializer);
		setHashValueSerializer(protostuffSerializer);
	}

}
