package org.springframework.myBeans.factory;

import org.springframework.myBeans.entity.Cat;

/**
 * @author maiqi
 * @title StaticCatFactory
 * @description TODO
 * @create 2023/11/6 11:52
 */
public class StaticCatFactory extends AbstractCatFactory {


	// 静态工厂方法
	public static Cat createCat(String type){
		return cats.get(type);
	}
}
