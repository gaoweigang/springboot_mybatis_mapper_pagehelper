package com.gwg.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 实体类
 * @author gaoweigang
 *
 */
@Table(name = "student")
public class Student implements Serializable{
	
	/**
     * 姓名
     */
    @Column(name = "name")
	private String name;
	
    /**
     * 年龄
     */
    @Column(name = "age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
