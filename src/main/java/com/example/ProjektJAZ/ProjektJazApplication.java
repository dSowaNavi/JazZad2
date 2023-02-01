package com.example.ProjektJAZ;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.ArrayList;

@EnableCaching
@SpringBootApplication
public class ProjektJazApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektJazApplication.class, args);
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(60))
				.disableCachingNullValues()
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John", "john1243", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Tom", "Stansilav", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Navb", "cat", "1234", new ArrayList<>()));

			userService.updateUserRole(1, "ROLE_USER");
		};
	}*/
}
