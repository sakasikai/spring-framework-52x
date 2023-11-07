package org.springframework.myBeans.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.helper.Describable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

public class Bird implements InitializingBean, DisposableBean, Describable {

	String type;

	// Override (itf)default methods
	public void desc(){
		this.desc(Bird.this.toString());
	}

	// -----------
	// life cycle
	// -----------

	@PostConstruct
	public void testPostConstruct(){
//		System.out.println("[1] @PostConstruct method invoked.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
//		System.out.println("[2] afterPropertiesSet() invoked.");
	}



	/**
	 * @description: 由 @Bean(initMethod = "myInit", destroyMethod = "myDestroy") 指定
	 * @author: maiqi
	 * @update: 2023/11/5 12:20
	 */
	public void myInit(){
//		System.out.println("[3] Init method invoked.");
	}


	@PreDestroy
	public void testPreDestroy(){
//		System.out.println("[-3] DisposableBean.destroy()");
	}

	@Override
	public void destroy() throws Exception {
//		System.out.println("[-2] destroy() method invoked.");
	}

	/**
	 * @description: 由 @Bean(initMethod = "myInit", destroyMethod = "myDestroy") 指定
	 * @author: maiqi
	 * @update: 2023/11/5 12:20
	 */
	public void myDestroy(){
//		System.out.println("[-1] Destroy method invoked.");
	}
}
