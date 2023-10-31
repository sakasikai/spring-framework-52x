package org.springframework.myBeans;

/**
 * @author maiqi
 * @title Bird
 * @description TODO
 * @create 2023/10/31 16:19
 */
public class Bird {
	String type;
	String id;

	public void init(){
		System.out.println("[+] Init life cycle ...");
	}

	public void mock(){
		System.out.println(Thread.currentThread().getName());
	}

	public void destroy(){
		System.out.println("[-] Destroy life cycle ...");
	}
}
