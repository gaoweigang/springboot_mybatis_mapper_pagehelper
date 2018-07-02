package com.gwg.demo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis基础配置
 * @author Administrator
 *
 */
@Configuration
public class DataSourceConfig{
	
	/**
	 * 注释掉，springboot内置的tomcat提供了自带dbcp连接池
	 * 在这里会使用tomcat自带的dbcp连接池
	 */
	/*@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}*/
	

	/**
	 * 生成一个名字为 sqlSessionFactory 的bean
	 * mybatis的sqlSessionFactory配置
	 * @param dataSource
	 */
	@Bean(name="sqlSessionFactory")
	@ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	bean.setDataSource(dataSource);
    	bean.setTypeAliasesPackage("com.gwg.demo.model");
    	
    	ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
    	try {
			bean.setMapperLocations(resolver.getResources("classpath*:com/gwg/demo/mapper/*.xml"));
		} catch (IOException e) {
			e.printStackTrace();	
		}
    	return bean.getObject();
    }
	
    
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
    
	
	/**
	 * 生成一个名字为mapperScannerConfigurer的bean
	 * mapper接口扫描包
	 * org.mybatis.spring.mapper.MapperScannerConfigurer 与 tk.mybatis.spring.mapper.MapperScannerConfigurer 区别？
	 * 这里要使用MyBatis通用Mapper里面的类MapperScannerConfigurer，否则会报找不到表
	 */
    @Bean
    @ConditionalOnBean({DataSource.class, SqlSessionFactory.class, SqlSessionFactoryBean.class})
    public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		configurer.setBasePackage("com.gwg.demo.mapper");
		return configurer;
	}
	
    
    /**
	 * 
	 * @Title: transactionManager   
	 * @Description: 配置事务管理器
	 * @param: @param dataSource
	 * @return: DataSourceTransactionManager      
	 */
/*	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource)
			throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}
*/

}
