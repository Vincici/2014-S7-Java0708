package com.demo.org.bean;

import java.beans.ConstructorProperties;

/**
 * bean的配置
 * @author xl
 *
 */
public class BeanClass02 {
	private String info;

	public BeanClass02() {
		
	}
	@ConstructorProperties("info")
	public BeanClass02(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void showInfo() {
		System.out.println(info);
	}
}
