package com.gwg.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwg.demo.mapper.StudentMapper;
import com.gwg.demo.model.Student;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * debug mapper
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testStudentMapper(){
		System.out.println("studentMapper："+studentMapper);
		String name = "gaoweigang";
		Student result =  studentMapper.queryStudentByName(name);
		System.out.println(result);
		
	}
	
	@Test
	public void testQueryStudent() throws SQLException{
		Example example = new Example(Student.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("name", "gaoweigang");
		List<Student> studentList = studentMapper.selectByExample(example);
		System.out.println(studentList.get(0));
		
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);

		
		System.out.println(dataSource);
		
		System.out.println(sqlSessionFactory);
		/*//3.创建Statement  
		Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();  
        String sql = "select * from student";
        
        ResultSet rs = stmt.executeQuery(sql);
        String str = null;
        try {  
            ResultSetMetaData rsmd = rs.getMetaData();  
            System.out.println(rsmd.getColumnCount());
            System.out.println(rsmd.getColumnName(1));
            System.out.println(rsmd.getColumnName(2));
            while(rs.next()){
                System.out.println(rs.getString(1));
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  */

	}

}
