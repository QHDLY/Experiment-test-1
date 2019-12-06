package cn.liuy.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.liuy.config.SpringConfig;
import cn.liuy.entity.User;
import cn.liuy.list.OperateList;

//扫描配置类
@ContextConfiguration(classes = SpringConfig.class) 
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	@Autowired
	private OperateList ol;
	
	
	@Test
	public void addUser()
	{
		User user = new User(2,"LMM","123456");
		
		ol.addUser(user);
	}
	
	@Test
	public void deleteUser()
	{
		ol.deleteUser(2);
	}
	
	@Test
	public void updateUser()
	{
		User user = new User();
		
		user.setId(3);
		user.setName("LCL");
		ol.updateUser(user);
	}
	
	@Test
	public void selectUserAll()
	{
		ol.selectUserAll();
	}
	
	@Test
	public void selectUserById()
	{
		ol.selectUserById(4);
	}
}
