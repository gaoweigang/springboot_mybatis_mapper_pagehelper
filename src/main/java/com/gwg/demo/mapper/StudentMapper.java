package com.gwg.demo.mapper;

import com.gwg.demo.model.Student;

import tk.mybatis.mapper.common.Mapper;

public interface StudentMapper extends Mapper<Student>{
	
	public Student queryStudentByName(String name);

}
