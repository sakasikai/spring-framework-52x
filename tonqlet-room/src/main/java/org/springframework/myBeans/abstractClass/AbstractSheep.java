package org.springframework.myBeans.abstractClass;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.myBeans.Object.Wool;

/**
 * @author maiqi
 * @title AbstractSheep
 * @description TODO
 * @create 2023/11/5 17:20
 */
public abstract class AbstractSheep {

	/**
	 * @description: @Lookup注解指定此方法为lookup-method，子类用于方法的调用
	 * @author: maiqi

	 * @return Wool
	 * @update: 2023/11/6 10:44
	 */
	@Lookup
	public Wool getWoolFromSubClass() {
		System.out.println("Otherwise, we declare this as abstract method");
		return null;
	}


	/**
	 * @description: xml中指定此方法为lookup-method，同时定义 代理bean 用于方法的调用
	 * @author: maiqi
	 * @return Wool
	 * @update: 2023/11/6 10:43
	 */
	public abstract Wool getWoolFromXMLProxy();
}

