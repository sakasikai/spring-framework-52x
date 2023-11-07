package org.springframework.myBeans.Object;

import org.springframework.context.annotation.Scope;
import org.springframework.helper.Describable;
import org.springframework.stereotype.Component;

/**
 * @author maiqi
 * @title Milk
 * @description TODO
 * @create 2023/11/5 23:01
 */
@Component()
@Scope("prototype")
public class Milk implements Describable {
	public void desc(){
		this.desc(Milk.this.toString());
	}
}
