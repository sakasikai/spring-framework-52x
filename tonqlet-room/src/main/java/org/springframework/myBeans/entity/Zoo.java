package org.springframework.myBeans.entity;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.helper.Describable;
import org.springframework.myBeans.events.DinnerEvent;
import org.springframework.myBeans.events.SleepEvent;

/**
 * @author maiqi
 * @title Zoo
 * @description TODO
 * @create 2023/10/31 16:27
 */
public class Zoo implements Describable, ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;


	public void desc(){
		this.desc(Zoo.this.toString());
	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void manageEvening(){
		System.out.println("晚餐时间到！");
		this.publisher.publishEvent(new DinnerEvent(this));

		System.out.println();
		System.out.println("闭圆时间到！");
		this.publisher.publishEvent(new SleepEvent(this));
	}
}
