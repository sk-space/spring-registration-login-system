package com.project.registration.dao.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.registration.dao.UserDao;
import com.project.registration.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public void addUser(User u) {
		session = sessionFactory.getCurrentSession();
		session.save(u);
	}

	@Override
	@Transactional
	public boolean isExit(String username) {
		session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM User AS u WHERE u.username=?");
		q.setParameter(0, username);
		List<User> uList = q.list();
		if(uList.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	@Transactional
	public User loginUser(String username, String password) {
		session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM User AS u WHERE u.username=? AND u.password=?");
		q.setParameter(0, username);
		q.setParameter(1, password);
		User u = (User) q.uniqueResult();
		if(u != null){
			return u;
		}
			return null;
	}
}
