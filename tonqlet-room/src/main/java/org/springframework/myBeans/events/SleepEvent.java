package org.springframework.myBeans.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author maiqi
 * @title SleepEvent
 * @description TODO
 * @create 2023/11/13 15:39
 */
public class SleepEvent extends ApplicationEvent {
	private static final long serialVersionUID = -49899690954778327L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public SleepEvent(Object source) {
		super(source);
	}
}
