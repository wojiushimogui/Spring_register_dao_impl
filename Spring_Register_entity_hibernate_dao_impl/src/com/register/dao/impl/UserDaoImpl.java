package com.register.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.register.dao.UserDao;
import com.register.hibernateutil.HibernateUtil;
import com.register.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User user) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public boolean exists(User user) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		//利用hql来查询数据库中是否已经存在此名字的用户
		String hql="from User as u where u.username=?";
		Query query=session.createQuery(hql);
		query.setString(0, user.getUsername());
		List list=query.list();
		if(!list.isEmpty()){
			return true;
		}
		session.getTransaction().commit();
		return false;
	}

}
