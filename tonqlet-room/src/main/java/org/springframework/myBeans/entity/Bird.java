package org.springframework.myBeans.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;
import org.springframework.helper.Describable;
import org.springframework.myBeans.events.DinnerEvent;
import org.springframework.myBeans.events.SleepEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
@Component
//@Scope("prototype")
public class Bird implements InitializingBean, DisposableBean, Describable {

	// Override (itf)default methods
	public void desc(){
		this.desc(this.toString());
	}

	@EventListener
	public void onApplicationEvent(DinnerEvent event) {
		System.out.print("啾啾～ ");
		this.desc(this.toString(), "Birds do not eat Dinner.");
	}

	@EventListener
	public void onApplicationEvent(SleepEvent event) {
		System.out.print("啾啾～ ");
		this.desc(this.toString(), "fly to my tree hole.");
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
