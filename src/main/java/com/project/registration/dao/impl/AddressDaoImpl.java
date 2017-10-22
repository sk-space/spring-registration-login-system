package com.project.registration.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.registration.dao.AddressDao;
import com.project.registration.entity.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public void addAddress(Address a) {
		session = sessionFactory.getCurrentSession();
		session.save(a);
	}

}
