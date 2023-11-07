package org.springframework.myBeans.entity;

import org.springframework.helper.Describable;

/**
 * @author maiqi
 * @title Cat
 * @description TODO
 * @create 2023/11/6 11:54
 */

public class Cat implements Describable {
	String type;

	public Cat(String type){
		this.type = type;
	}

	public void desc(){
		System.out.printf("[%s] => ", this.type);
		this.desc(Cat.this.toString());
	}
}
