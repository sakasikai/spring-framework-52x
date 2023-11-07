package org.springframework.constants;

/**
 * @author maiqi
 * @title AnimalSex
 * @description TODO
 * @create 2023/11/3 11:48
 */
public enum AnimalSex {
	MALE("雄性"),
	FEMALE("雌性"),
	NONE("无性");

	String value;


	AnimalSex(String value) {
		value = value;
	}
}
