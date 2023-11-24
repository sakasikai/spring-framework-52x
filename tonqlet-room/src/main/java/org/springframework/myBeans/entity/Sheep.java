package org.springframework.myBeans.entity;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.helper.Describable;
import org.springframework.myBeans.abstractClass.AbstractSheep;
import org.springframework.myBeans.Object.Wool;
import org.springframework.myBeans.events.DinnerEvent;
import org.springframework.myBeans.events.SleepEvent;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author maiqi
 * @title Sheep
 * @description TODO
 * @create 2023/11/5 18:04
 */
@Component("sheep")
public class Sheep extends AbstractSheep implements ApplicationListener<ApplicationEvent>, Describable {

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

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		if(event instanceof DinnerEvent){
			System.out.print("咩～ ");
			this.desc(this.toString(), "eat Grass as my Dinner～");
		} else if (event instanceof SleepEvent) {
			System.out.print("咩～ ");
			this.desc(this.toString(), "go back to my House～");
		} else {
			//
		}
	}
}
