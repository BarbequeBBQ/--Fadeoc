package com.ssh.demo.web;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.demo.entity.User;
import com.ssh.demo.service.IUserService;
import com.ssh.demo.util.PageableBean;

//@Component
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private IUserService userService;

	//  http://localhost:8080/ssh-demo/user/save
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody String saveOrUpdate(User user,HttpSession session) 
	{
	
		if(user.getId()!=null){
			//更新
			//user.setUpdater(session.getAttribute("userName")+"");
			user.setUpdateTime(new Date());
		}else{
			//保存/插入
			//user.setCreater(session.getAttribute("userName")+"");
			user.setCreaterTime(new Date());
		}
		userService.save(user);

		return "success:true";
	}

	//JqGrid分野条件:rows:10,page:1,sidx:id,sord:desc
	//http://localhost:8080/ssh-demo/user/pageLists?rows=10&page=1&sidx=id&sord=desc
	@RequestMapping("/pageLists")
	public @ResponseBody Page<User> findPage(
			@RequestParam("rows") int rows,
			@RequestParam("page") int page,
			@RequestParam("sidx") String sidx,//id
			@RequestParam("sord") String sord) 
	{
		//Sort sort = new Sort(Direction.ASC, "departmentName").and(new Sort(Direction.ASC, "staffCode"));
		Sort sort = new Sort(Direction.DESC, sidx);
		if(!sord.equals("desc")){
			sort = new Sort(Direction.ASC, sidx);
		}
//		Pageable pageable = new PageRequest(page-1, rows);
//		Pageable pageable = new PageRequest(page-1, rows,Direction.ASC,"id","staffCode");
		Pageable pageable = new PageRequest(page-1, rows,sort);
		Page<User> userPage = userService.findAll(pageable);

		return userPage;
	}
	
	/**
	 * 分野条件参数封装:自动封装数据到JavaBean,重用Pageable的创建代码.
	 * @param pageableBean
	 * @return
	 */
	//http://localhost:8080/ssh-demo/user/pageLists2?rows=10&page=1&sidx=id&sord=desc
	@RequestMapping("/pageLists2")
	public @ResponseBody Page<User> findPage(PageableBean pageableBean
			//,@RequestParam("ids[]") int[] ids
	){

		Page<User> userPage = userService.findAll(pageableBean.getPageable());

		return userPage;
	}
	
	
	

}
