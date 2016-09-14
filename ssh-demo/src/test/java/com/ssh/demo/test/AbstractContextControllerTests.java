package com.ssh.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

//1.启动Web项目的测试配置
@WebAppConfiguration
//2.加载Spring配置文件初始化上下文环境.
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring-web-servlet.xml",
		"file:src/main/resources/spring/applicationContext-bean.xml",
		"file:src/main/resources/spring/applicationContext-orm.xml"
})
public class AbstractContextControllerTests {

	//3.注入web程序的上下文对象,获取控制层对象
	@Autowired
	protected WebApplicationContext wac;
}
