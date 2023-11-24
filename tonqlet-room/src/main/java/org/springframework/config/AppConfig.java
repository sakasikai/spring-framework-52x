package org.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.myBeans.entity.Bird;
import org.springframework.myBeans.entity.Zoo;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author maiqi
 * @title AppConfig
 * @description
 *     - AppConfig 作为 @Configuration配置类，定义了各种bean，<br> 会被传入 AnnotationConfig_ApplicationContext 进行解析
 * <p>
 *     - ComponentScan 会扫描其他包下的 bean
 * </p>
 * <p>
 *     - ImportResource 混入 xml-based 元数据
 * </p>
 * @create 2023/10/31 16:11
 */
@Configuration
@ImportResource("classpath:tq-room-config.xml")
@Import({LookupConfig.class})
public class AppConfig {
	/**
	 * @description: 默认单例bean
	 * @author: maiqi
	 * @update: 2023/11/5 12:02
	 */
	@Bean
	public Zoo aZoo(){
		return new Zoo();
	}

	/**
	 * @description:
	 * 1. 原型bean
	 * <p>
	 * 2. life cycle <br/>
	 * 	  - 指定了 initMethod，destroyMethod 方法<br/>
	 * 	  - 指定了 InitializingBean, DisposableBean 接口
	 * </p>
	 * @author: maiqi
	 * @update: 2023/11/5 12:02
	 */
	@Bean(name = {"bird"}, initMethod = "myInit", destroyMethod = "myDestroy")
	@Scope("prototype")
	public Bird aBird(){
		return new Bird();
	}
}
