package com.qdd.logback.model;

import lombok.Data;

@Data
public class Employee {
	/**
	 * 员工id(数据库自增)
	 */
	private Integer id;
	/**
	 * 员工名字
	 */
	private String name;
	/**
	 * 员工年龄
	 */
	private Integer age;
	/**
	 * 员工性别
	 */
	private String gender;

}
