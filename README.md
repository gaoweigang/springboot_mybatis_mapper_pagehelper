# springboot_mybatis_demo
本文将分析mybatis与spring整合的MapperScannerConfigurer的底层原理，之前已经分析过java中实现动态，可以使用jdk自带api和cglib第三方库生成动态代理。本文分析的mybatis版本3.2.7，mybatis-spring版本1.2.2。

MapperScannerConfigurer介绍

MapperScannerConfigurer是spring和mybatis整合的mybatis-spring jar包中提供的一个类。

想要了解该类的作用，就得先了解MapperFactoryBean。

MapperFactoryBean的出现为了代替手工使用SqlSessionDaoSupport或SqlSessionTemplate编写数据访问对象(DAO)的代码,使用动态代理实现。

比如下面这个官方文档中的配置：

<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
  <property name="mapperInterface" value="org.mybatis.spring.sample.mapper.UserMapper" />
  <property name="sqlSessionFactory" ref="sqlSessionFactory" />
</bean>
org.mybatis.spring.sample.mapper.UserMapper是一个接口，我们创建一个MapperFactoryBean实例，然后注入这个接口和sqlSessionFactory（mybatis中提供的SqlSessionFactory接口，MapperFactoryBean会使用SqlSessionFactory创建SqlSession）这两个属性。

之后想使用这个UserMapper接口的话，直接通过spring注入这个bean，然后就可以直接使用了，spring内部会创建一个这个接口的动态代理。

当发现要使用多个MapperFactoryBean的时候，一个一个定义肯定非常麻烦，于是mybatis-spring提供了MapperScannerConfigurer这个类，它将会查找类路径下的映射器并自动将它们创建成MapperFactoryBean。

<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <property name="basePackage" value="org.mybatis.spring.sample.mapper" />
</bean>
这段配置会扫描org.mybatis.spring.sample.mapper下的所有接口，然后创建各自接口的动态代理类。
