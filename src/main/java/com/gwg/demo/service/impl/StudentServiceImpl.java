package com.gwg.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gwg.demo.dto.StudentDto;
import com.gwg.demo.mapper.StudentMapper;
import com.gwg.demo.model.Student;
import com.gwg.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired(required=true)
    private StudentMapper studentMapper;


    public Student getStudentByName(String name){
        System.out.println("studentMapper："+studentMapper+", 入参name:"+name);
        Student result =  studentMapper.queryStudentByName(name);
        return result;
    }

    /**
     * 分页查询
     */
    public PageInfo<Student> queryStudentByLimit(StudentDto dto){
        PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        List<Student> studentList = studentMapper.queryStudentByLimit(dto);
        PageInfo<Student> page = new PageInfo<Student>(studentList);
        return page;
    }
}
