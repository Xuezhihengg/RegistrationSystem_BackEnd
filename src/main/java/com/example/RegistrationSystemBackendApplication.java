package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.example.dao")
public class RegistrationSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationSystemBackendApplication.class, args);
	}

}
