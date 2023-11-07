package org.springframework.myBeans.entity;

import org.springframework.myBeans.abstractClass.AbstractSheep;
import org.springframework.myBeans.Object.Wool;
import org.springframework.stereotype.Component;

/**
 * @author maiqi
 * @title Sheep
 * @description TODO
 * @create 2023/11/5 18:04
 */
@Component("sheep")
public class Sheep extends AbstractSheep {

	public void produceAndDescWool(){
		Wool o = getWoolFromSubClass();
		o.desc();
	}

	/**
	 * @description:
	 * <p>
	 *     Sheep是单例，但是Wool是原型，DI时用普通注入只会初始化一次，违反原型的语义
	 * </p>
	 * <p>
	 * 		Method Injection 的作用在于用代理，每次都返回一个原型Bean，解决问题
	 * </p>
	 * @author: maiqi

	 * @return Wool
	 * @update: 2023/11/5 22:56
	 */
	@Override
	public Wool getWoolFromXMLProxy() {
		return null;
	}

}
