package com.ssh.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository; //注意注解@Repository与接口Repository的区别.(全路径解决同名类冲突)
//Spring data 四大接口
//import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;//高级查询,搭配查询的方法使用

import com.ssh.demo.entity.User;

/**
 * http://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/
 * 1.配置ORM配置文件:升级hibernate为 spring data jap整合hibernate(其他orm框架)
 * 2.修改持久层:  使用  spring data jap 标准API重构持揪层(DAO代码规范统一,修改配置文件即可与其他持久框架整合,不需要修改持久层的的代码) 
 * 3.Spring Data Jpa 四大接口：
 * 	Repository:集成该接口,可以被jpa管理,该接口注意与@Repository 命名冲突 ,使用全路径解决@org.springframework.stereotype.Repository
 * 	CrudRepository
 * 	PagingAndSortingRepository: Page  Pageable  Sort
 * 	JpaSpecificationExecutor :组装动态查询条件  Specification
 * 
 * 4.@Query(HQL) : HQL自定义查询
 * 5.JPA持久层方法的命名规则：按方法名生成SQL/HQL
 */
//@Component
@Repository
public interface UserDao  extends PagingAndSortingRepository<User, Long> , JpaSpecificationExecutor<User> 
{
	//自定义
}
