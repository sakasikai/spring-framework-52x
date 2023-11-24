package org.springframework.myBeans.entity;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.helper.Describable;
import org.springframework.myBeans.events.DinnerEvent;
import org.springframework.myBeans.events.SleepEvent;
import org.springframework.stereotype.Component;

/**
 * @author maiqi
 * @title Cat
 * @description TODO
 * @create 2023/11/6 11:54
 */
@Component
@Scope("prototype")
public class Cat implements Describable {
	String type;

	public Cat() { this("银渐"); }

	public Cat(String type){
		this.type = type;
	}

	public void desc(){
		System.out.printf("[%s] => ", this.type);
		this.desc(Cat.this.toString());
	}

	@EventListener({DinnerEvent.class})
	public void onDinnerEvent() {
		System.out.print("喵唔～ ");
		this.desc(Cat.this.toString(), "猫粮 as my Dinner～");
	}

	@EventListener(SleepEvent.class)
	public void onSleepEvent(){
		System.out.print("喵唔～ ");
		this.desc(Cat.this.toString(), "回猫舍喽～");
	}
}
