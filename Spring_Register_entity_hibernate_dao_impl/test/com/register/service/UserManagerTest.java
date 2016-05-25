package com.register.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.register.dao.UserDao;
import com.register.dao.impl.UserDaoImpl;
import com.register.model.User;
import com.register.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Test
	public void testExists() {
		UserManager um=new UserManagerImpl();		
		User user=new User();
		user.setUsername("haowu");
		boolean exists=um.exists(user);
		assertEquals(false, exists);
	}

	@Test
	public void testSave() {
		UserManager um=new UserManagerImpl();
		User user=new User();
		user.setUsername("haowuwu");
		user.setPassword("123");
		boolean exists=um.exists(user);
		if(!exists){
			um.save(user);
			//������ǲ�������ݿ��в鿴�Ƿ񱣴�ɹ���������������µĴ��������
			exists=um.exists(user);
			assertEquals(true, exists);
		}
		else{
			fail("save fail!!!");
		}
	}

}
