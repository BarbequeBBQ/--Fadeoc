package com.ssh.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.dao.UserDao;
import com.ssh.demo.entity.User;

/**
 * 业务层:
 * 1.实现系统核心业务(功能)
 * 2.可以访问数据库(DAO CURD)/上层结构访问下层结构
 * 3.hibernated的事务管理：多个数据操作作为一个完整的业务，必须保证事务的完整性.要么全部成功，要么全部失败。
 */
//@Component
@Service
@Transactional//默认当前类所有的方法 都带  事务管理
public class UserService implements IUserService
{

	@Autowired
	private UserDao  userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public void save(List<User> userLists) {
		userDao.save(userLists);
		
	}

	@Override
	public User findOne(Long id) {

		return userDao.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	@Override
	public List<User> findAll(List<Long> ids) {
		
		return (List<User>)userDao.findAll(ids);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void delete(List<User> userLists) {
		userDao.delete(userLists);
		
	}

	@Override
	public void deleteAll() {
		userDao.deleteAll();
		
	}

	@Override
	public boolean exists(Long id) {
		
		return userDao.exists(id);
	}

	@Override
	public long count() 
	{
		return userDao.count();
	}

	@Override
	public List<User> findAll(Sort sort) {
		
		return (List<User>)userDao.findAll(sort);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}


	@Override
	public User findOne(Specification<User> spec) {
		return userDao.findOne(spec);
	}

	@Override
	public List<User> findAll(Specification<User> spec) {
		
		return userDao.findAll(spec);
	}

	@Override
	public List<User> findAll(Specification<User> spec, Sort sort) {
		return userDao.findAll(spec,sort);
	}

	@Override
	public Page<User> findAll(Specification<User> spec, Pageable pageable) {
		return userDao.findAll(spec,pageable);
	}


	

}
