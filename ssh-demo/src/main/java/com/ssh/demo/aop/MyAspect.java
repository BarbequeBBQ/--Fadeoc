package com.ssh.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ssh.demo.entity.User;


//1.切面类
@Aspect
@Component//组件
public class MyAspect {

	//2.切点:一个切面类可以有任意多个切点,切点只作为一个标志，永远不会执行的。
	@Pointcut("execution(public * *(..))")//执行一个公共的方法 *任意的返回类型  *任意的方法名  ..任意的参数列表
	private void anyPublicOperation() {
	
	}
	
	
	@Pointcut("within(com.ssh.demo.service..*)")
	private void servicePointcut() {}
	
	@Pointcut("within(com.ssh.demo.dao..*)")
	private void daoPointcut() {}

	
	@Pointcut("anyPublicOperation() && servicePointcut()")
	private void serviceAnyPublicOperation() {
		System.out.println("永远不会执行的");
	}
	
	
	//3.通知(增强)方式:5种  前置通知，后置通知，异常通知，最终通知，环绕通知。
	@Before("serviceAnyPublicOperation() && args(user)")
	public void doMethodBefore(User user) {
		System.out.println("@Before 前置通知:数据校验...权限校验...事务开始...");
		System.out.println("UserName:"+user.getUserName());
	}
	
	@AfterReturning("serviceAnyPublicOperation()")
	public void doMethodAfterReturning() {
		System.out.println("@AfterReturning 后置通知:事务提交...");
	}
	
	@AfterThrowing("serviceAnyPublicOperation()")
	public void doMethodAfterThrowing() {
		System.out.println("@AfterThrowing 异常通知:异常捕获/处理 ... 错误日志...事务回滚...");
	}
	
	@After("serviceAnyPublicOperation()")
	public void doMethodAfter() {
		System.out.println("@After 最终通知:资源回收...操作日志..");
	}
	
	//4.表达式
}
