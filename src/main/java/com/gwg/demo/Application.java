package com.gwg.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author gaoweigang
 * 
 * 我们的Application类上使用的第一个注解是@RestController。这被称为一个构造型注解。
 * 它为阅读代码的人们提供建议。对于Spring,该类扮演了一个特殊角色。在本示例中，我们的
 * 类是一个web @Controller,所以当处理进来的web请求时，Spring会询问他.
 * 
 * @SpringBootApplication 等价于 @Configuration, @EnableAntoConfiguration 和 @ComponentScan。
 * 
 */
@RestController
@SpringBootApplication//启动了自动配置，如果配置文件中有数据库的配置，则会自动创建dataSource
public class Application{
	
	/**
	 * @RequestMapping注解提供路由信息。它告诉Spring任何来自"/"路径的请求都应该被映射到home方法。
	 * 
	 * 在这里编写一个测试方法用于测试SpringBoot基础环境有没有配置好，可以在浏览器中输入http://localhost:8080/验证
	 */
	@RequestMapping("/")
	String home(){
		return "Hello World";
	}
		
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}

}
