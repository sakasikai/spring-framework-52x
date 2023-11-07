package org.springframework.myBeans.entity;

import org.springframework.helper.Describable;

/**
 * @author maiqi
 * @title Zoo
 * @description TODO
 * @create 2023/10/31 16:27
 */
public class Zoo implements Describable {

	public void desc(){
		this.desc(Zoo.this.toString());
	}



}
