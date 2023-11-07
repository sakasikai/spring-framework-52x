package org.springframework;

import org.springframework.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.myBeans.abstractClass.AbstractCow;
import org.springframework.myBeans.abstractClass.AbstractSheep;
import org.springframework.myBeans.entity.Bird;
import org.springframework.myBeans.entity.Cat;
import org.springframework.myBeans.entity.Sheep;
import org.springframework.myBeans.entity.Zoo;


public class SpringApplication {
	ApplicationContext ctx;
	{
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	public static void main(String[] args) {
		System.out.println("[+] started ‼️");
		SpringApplication r = new SpringApplication();
		r.toBe();
		System.out.println("[-] done ‼️");
	}

	public void done(){
		this.scope_lifeCycle();
		this.method_injection();
	}
	public void toBe(){
		this.factory_method();
	}


	/**
	 * @description: 创建FactoryBean的两种方法:
	 * <p>
	 *     两种方法都要借助 xml 配置，容器维护FactoryBean，用 factory-method 指定工厂方法 <br/>
	 *     ctx.getBean(factoryName) 得到的 是被声明的Bean，而非FactoryBean，此例为 Cat <br/>
	 *     声明Bean，是靠 FactoryBean#factory-method 间接声明
	 * </p>
	 * <p />
	 * <p>
	 *     静态工厂，将工厂类本身创建为FactoryBean，工厂方法是static <br/>
	 *     实例工厂，依托工厂Bean实例，创建FactoryBean，
	 * </p>
	 *
	 * @author: maiqi
	 * @update: 2023/11/7 11:20
	 */
	public void factory_method(){
		Cat o = ctx.getBean("staticCatFactory", Cat.class);
		o.desc();
		ctx.getBean("staticCatFactory", Cat.class).desc();

		ctx.getBean("staticCatFactory2", Cat.class).desc();
		ctx.getBean("staticCatFactory2", Cat.class).desc();

		ctx.getBean("instanceCatFactory", Cat.class).desc();
		ctx.getBean("instanceCatFactory", Cat.class).desc();
	}



	/**
	 * @description:
	 * <p>
	 *     <p>
	 *         多次（3次）从容器获取Bean对象，不同 scope，以及 life cycle 的变化
	 *     </p>
	 *
	 *     规律：
	 *     <p>- 单例 只会在 ctx创建、销毁时触发</p>
	 *     <p>- 原型 在每次创建时触发，(销毁不触发)</p>
	 * </p>
	 * @author: maiqi
	 * @update: 2023/11/5 12:10
	 */
	public void scope_lifeCycle(){
		// 单例bean
		Zoo o1 = ctx.getBean(Zoo.class);
		o1.desc();
		ctx.getBean(Zoo.class).desc();
		ctx.getBean(Zoo.class).desc();

		// 原型bean + life cycle
		// 注释掉@Scope("prototype") ==》测试 单例bean + life cycle
		Bird o = ctx.getBean(Bird.class);
		o.desc();
		ctx.getBean(Bird.class).desc();
		ctx.getBean(Bird.class).desc();

		((AnnotationConfigApplicationContext) ctx).close();
	}

	/**
	 * @description:
	 *		Singleton Bean 中的方法 获取 Prototype Bean，通过 Method Injection 来实现
	 *		<p>
	 *		 	三种方式:
	 *		</p>
	 *		<p>
	 *		 	定义 AbstractSheep，有两个方法注入的方法：aWool，getWool
	 *		 	<p>
	 *		 	  - aWool 通过 @LookUp标注aWool + 实例化 AbstractSheep的子类Bean 来调用
	 *		 	</p>
	 *		 	<p>
	 *		 	  - getWool 通过 xml_defined_sheep(bean, lookup-method) 定义代理Bean 来调用
	 *		 	</p>
	 *		 	<p>
	 * 			  - @Configuration中返回匿名类作为抽象类AbstractCow的实现，用于定义Bean，调用 @Bean方法 注入多例bean，实现@Lookup平替
	 *		 	</p>
	 *		</p>
	 * @author: maiqi
	 * @update: 2023/11/6 09:33
	 */
	public void method_injection(){
		Sheep o = ctx.getBean(Sheep.class);
		o.produceAndDescWool();
		o.produceAndDescWool();
		o.produceAndDescWool();

		AbstractSheep as = ctx.getBean("xml_defined_sheep", AbstractSheep.class);
		as.getWoolFromXMLProxy().desc();
		as.getWoolFromXMLProxy().desc();
		as.getWoolFromXMLProxy().desc();

		AbstractCow ac = ctx.getBean(AbstractCow.class);
		ac.produceMilk().desc();
		ac.produceMilk().desc();
		ac.produceMilk().desc();
	}


}