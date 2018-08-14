package com.gwg.demo.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gwg.demo.mapper.StudentMapper;
import com.gwg.demo.model.Student;

public interface StudentService {

	public Student getStudentByName(String name);

	/**
	 * 分页
	 */
	public PageInfo<Student> queryStudentByLimit(StudentDto dto);

}
