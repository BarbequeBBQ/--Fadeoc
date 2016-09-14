package com.ssh.demo.test.user;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.test.AbstractContextControllerTests;
//1.在测试环境下运行 4 = for
@RunWith(SpringJUnit4ClassRunner.class)
//2.启动事务
@Transactional
public class UserControllerTests extends AbstractContextControllerTests 
{

	private MockMvc mockMvc;
	//3.@Before : @Test运行之前执行:测试前的准备工作,例如初始化环境
	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}

	//@Before //测试数据的初始化
	public void initData() throws Exception {
		
	}
	//4.测试用例:一个测试类 可以有多个用例@Test,如果不希望某些用例运行则直接注释掉@Test即可.
	@Test
	@Rollback(true)//事务回滚:保护数据现场.配合@Transactional注解使用.
	public void testSave() throws Exception {
					//使用 get方式 请求地址:/user/save		匹配返回数据(String)
		this.mockMvc.perform(get("/user/save")).andExpect(content().string("Hello world!"));
	}
	
	/**
	 * 编写分页查询的测试用例
	 * @throws Exception
	 */
	//@Test  //不运行
	@Rollback(true)
	public void testFindPage() throws Exception {
		
	}


}
