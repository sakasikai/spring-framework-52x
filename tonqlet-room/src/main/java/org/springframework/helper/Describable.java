package org.springframework.helper;

/**
 * @author maiqi
 * @title WorkHelper
 * @description TODO
 * @create 2023/11/5 11:53
 */
public interface Describable {
	default void desc(String beanName){
		beanName = beanName.substring(beanName.lastIndexOf(".") + 1);
		System.out.printf("%s => mock from Thread[%s]%n", beanName, Thread.currentThread().getName());
	}

	default void desc(String beanName, String text){
		beanName = beanName.substring(beanName.lastIndexOf(".") + 1);
		System.out.printf("%s says %s%n", beanName, text);
	}
}
