package org.springframework.myBeans.Object;

import org.springframework.context.annotation.Scope;
import org.springframework.helper.Describable;
import org.springframework.stereotype.Component;

/**
 * @author maiqi
 * @title Wool
 * @description TODO
 * @create 2023/11/5 17:35
 */
@Component("wool")
@Scope("prototype")
public class Wool implements Describable {


	public void desc(){
		this.desc(Wool.this.toString());
	}
}
