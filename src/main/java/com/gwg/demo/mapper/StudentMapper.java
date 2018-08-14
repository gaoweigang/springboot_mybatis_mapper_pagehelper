package com.gwg.demo.mapper;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.dto.StudentDto;
import com.gwg.demo.model.Student;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudentMapper extends Mapper<Student>{
	
	public Student queryStudentByName(String name);

	/**
	 * 分页查询 查询某个年龄段的人
	 */
	public List<Student> queryStudentByLimit(StudentDto dto);

}
