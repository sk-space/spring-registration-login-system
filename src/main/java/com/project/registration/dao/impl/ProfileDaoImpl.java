package com.project.registration.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.registration.dao.ProfileDao;
import com.project.registration.entity.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public void addProfile(Profile p) {
		session = sessionFactory.getCurrentSession();
		session.save(p);
	}

}
