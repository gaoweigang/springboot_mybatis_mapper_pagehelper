package com.gwg.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gwg.demo.mapper.StudentMapper;
import com.gwg.demo.model.Student;

@RestController
public class StudentService {
	
	@Autowired(required=true)
	private StudentMapper studentMapper;
	
	@RequestMapping(value = "/getStudentByName", method = RequestMethod.POST,
			   consumes = "application/json", produces = "application/json")
	public @ResponseBody Student getStudentByName(@RequestBody Student student){
		System.out.println("studentMapper："+studentMapper);
		String name = student.getName();
		System.out.println(name);
		Student result =  studentMapper.queryStudentByName(name);
		return result;
	}

}
