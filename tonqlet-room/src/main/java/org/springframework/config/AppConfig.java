package org.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.myBeans.Bird;
import org.springframework.myBeans.Zoo;

/**
 * @author maiqi
 * @title AppConfig
 * @create 2023/10/31 16:11
 */
@Configuration
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public Bird aBird(){
		return new Bird();
	}

	// Singleton
	@Bean
	public Zoo aZoo(){
		return new Zoo();
	}
}
