package cn.liuy.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.liuy.entity.User;
import cn.liuy.list.OperateList;

public class UserTest {
	
	private OperateList ol;
	
	@Before
	public void getOperateList()
	{
		ol = new OperateList();
	}
	
	
	@After
	public void delOperateList()
	{
		ol = null;
	}
	
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
