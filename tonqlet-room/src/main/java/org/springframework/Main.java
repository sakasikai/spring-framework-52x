package org.springframework;

import org.springframework.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.myBeans.Bird;

/**
 * @description: TODO
 * @author: maiqi
 * @update: 2023/10/31 16:10
 */
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Bird o = ctx.getBean(Bird.class);
		o.mock();

		System.out.println("done");
	}
}