package com.project.registration.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		List<User> u = session.createQuery("FROM User WHERE username='"+username+"'").list();
		if(u.isEmpty()){
			return false;
		}
		return true;
	}
}
