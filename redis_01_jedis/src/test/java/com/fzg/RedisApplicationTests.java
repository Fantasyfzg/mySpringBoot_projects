package com.fzg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fzg.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {

//		opsForList 操作字符串，类似String
//		opsForValue 操作List,类似List

//		除了基本的操作，常用的方法都可以通过redistemplate操作，比如事务，和基本的CRUD

//		获取redis的连接对象
//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//		connection.flushAll();
//		connection.flushDb();

		redisTemplate.opsForValue().set("mykey","fzg");
		System.out.println(redisTemplate.opsForValue().get("mykey"));

	}

	@Test
	public void test() throws JsonProcessingException {
		//真实的开发一般都是用json来传递对象
		User fzg = new User("fzg", 21);
		String jsonUser = new ObjectMapper().writeValueAsString(fzg);
		redisTemplate.opsForValue().set("user",jsonUser);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
