package org.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.myBeans.Object.Milk;
import org.springframework.myBeans.abstractClass.AbstractCow;

/**
 * @author maiqi
 * @title LookupConfig
 * @description TODO
 * @create 2023/11/6 11:14
 */
@Configuration
public class LookupConfig {
	/**
	 * @description:
	 *     - 返回匿名类作为抽象类AbstractCow的实现，用于定义Bean
	 *     <p>- 重写方法注入的方法，调用 @Bean方法 注入多例bean，实现@Lookup平替</p>
	 *
	 * @author: maiqi

	 * @return AbstractCow
	 * @update: 2023/11/6 10:52
	 */
	@Bean
	public AbstractCow replacementForLookup(){
		return new AbstractCow() {
			@Override
			public Milk produceMilk() {
				return aMilk(); // ‼️@Configuration配置类内部调用 @Bean方法 注入多例bean，实现了Lookup平替
			}
		};
	}

	@Bean
	@Scope("prototype")
	public Milk aMilk(){
		return new Milk();
	}
}
