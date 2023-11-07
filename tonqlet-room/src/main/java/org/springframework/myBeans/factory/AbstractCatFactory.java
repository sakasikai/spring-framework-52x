package org.springframework.myBeans.factory;

import org.springframework.myBeans.entity.Cat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maiqi
 * @title CatFactory
 * @description TODO
 * @create 2023/11/6 11:51
 */
public abstract class AbstractCatFactory {
	public static Map<String, Cat> cats = new HashMap<>();

	static {
		cats.put("银渐", new Cat("银渐"));
		cats.put("布偶", new Cat("布偶"));
		cats.put("花猫", new Cat("花猫"));
	}
}
