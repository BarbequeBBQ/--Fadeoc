package com.ssh.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.entity.User;

public interface IUserService 
{
	//继承:CrudRepository
	public void save(User user);//saveOrUpdate()
	public void save(List<User> userLists);
	public User findOne(Long id);
	
	public List<User> findAll();
	public List<User> findAll(List<Long> ids);

	
	public void delete(Long id);
	public void delete(User user);
	public void delete(List<User> userLists);
	public void deleteAll();
	
	public boolean exists(Long id);
	public long count();

	//继承:PagingAndSortingRepository
	public List<User> findAll(Sort sort);
	public Page<User> findAll(Pageable pageable);

	//继承:JpaSpecificationExecutor
	public User findOne(Specification<User> spec);
	public List<User> findAll(Specification<User> spec);
	public List<User> findAll(Specification<User> spec, Sort sort);
	public Page<User> findAll(Specification<User> spec, Pageable pageable);


	//自定义


}
