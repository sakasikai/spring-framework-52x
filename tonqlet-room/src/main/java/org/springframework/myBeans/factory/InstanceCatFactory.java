package org.springframework.myBeans.factory;

import org.springframework.myBeans.entity.Cat;
import org.springframework.stereotype.Component;

/**
 * @author maiqi
 * @title InstanceCatFactory
 * @description TODO
 * @create 2023/11/6 11:53
 */
public class InstanceCatFactory extends AbstractCatFactory{

	public Cat createCat(String type){
		return cats.get(type);
	}
}
