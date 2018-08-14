package com.gwg.demo.controller;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.common.PageResult;
import com.gwg.demo.dto.StudentDto;
import com.gwg.demo.model.Student;
import com.gwg.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudentByName", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public @ResponseBody Student queryStudentByName(String name){

        return studentService.getStudentByName(name);
    }

    @RequestMapping(value = "/getStudentByLimit", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public PageResult<Student> queryStudentByName(@RequestBody StudentDto dto){

        PageInfo<Student> pageInfo = studentService.queryStudentByLimit(dto);
        return new PageResult<Student>((int)pageInfo.getTotal(), pageInfo.getList());
    }



}
