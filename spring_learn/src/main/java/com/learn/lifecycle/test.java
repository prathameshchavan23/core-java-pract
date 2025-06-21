package com.learn.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/learn/lifecycle/config.xml");
//			Bean bean = (Bean) context.getBean("bean1");
//			System.out.println(bean);
//			withIntf wif = (withIntf) context.getBean("bean2");
//			System.out.println(wif);
			
			construct constr = (construct)context.getBean("example");
			System.out.println(constr);
			context.registerShutdownHook();
			
		}
}


