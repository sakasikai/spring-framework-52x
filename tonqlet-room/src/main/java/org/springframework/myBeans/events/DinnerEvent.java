package org.springframework.myBeans.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author maiqi
 * @title DinnnerEvent
 * @description TODO
 * @create 2023/11/13 15:39
 */
public class DinnerEvent extends ApplicationEvent {
	private static final long serialVersionUID = -4742425836036411624L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public DinnerEvent(Object source) {
		super(source);
	}
}
