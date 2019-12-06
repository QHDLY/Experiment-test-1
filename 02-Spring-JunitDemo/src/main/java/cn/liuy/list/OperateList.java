package cn.liuy.list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.liuy.entity.User;

public class OperateList {
	
	private static File file = new File("D:/test1.txt");
	
	static {
		if(!file.exists() && !file.isDirectory())
		{
			System.out.println("文件夹路径不存在!");
			file.mkdir();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//增加用户数据
	public void addUser(User user)
	{
		addData(user);
		
		selectUserAll();
	}
	
	
	/*删除某行用户数据 
	步骤:
	1.先读取数据,将不删除的数据放入list集合中,
	2.再将list中的数据覆盖写入.*/
	public void deleteUser(Integer id)
	{
		List<String> result = readData();
		
		List<String> result2 = new ArrayList<String>();
		
		for(String s : result) {
			if(s.startsWith(id.toString()))
		    {
		    	continue;
		    }
			result2.add(s);
		}
		
		coverData(result2);
		
		selectUserAll();
	}
	

	//修改某行用户数据
	public void updateUser(User user)
	{
			List<String> result = readData();
			
			List<String> result2 = new ArrayList<String>();
			
			for(String s : result)
			{
				if(s.startsWith(user.getId().toString()))
			    {
			    	if(user.getName() == null)
					{
						String name = s.split(" ")[3];
						result2.add(user.getId()+" "+name+" "+user.getPassword());
					}
					
					if(user.getPassword() == null)
					{
						String password = s.split(" ")[2];
						result2.add(user.getId()+" "+user.getName()+" "+password);
					}
					
					if(user.getName() != null && user.getPassword() != null)
					{
						String password = s.split(" ")[2];
						String name = s.split(" ")[3];
						result2.add(user.getId()+" "+name+" "+password);
					}
					continue;
			    }
				
			    result2.add(s);
			}
			
		coverData(result2);
		
		selectUserAll();
	}
	
	//查询所有用户数据
	public void selectUserAll()
	{
		List<String> result =  readData();
		for(String s : result)
		{
			System.out.println(s);
		}
	}
	
	//通过ID查询某行用户数据
	public void selectUserById(Integer id)
	{
		List<String> result = readData();
		for(String s : result)
		{
			if(s.startsWith(id.toString()))
			{
				System.out.println(s);
				break;
			}
		}
	}
	
	
	
	
	
	//追加文件数据
	public void addData(User user)
	{
		try {
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(user.getId()+" "+user.getName()+" "+user.getPassword());
			bw.newLine();

			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//读取数据
	public List<String> readData()
	{
		List<String> result = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			//构造一个BufferedReader类来读取文件
			String s = null;
			while((s = br.readLine())!=null){
			    //使用readLine方法，一次读一行
			    result.add(s);
			  }
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//覆盖写入数据
	public void coverData(List<String> result)
	{
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String s1 : result)
			{
				bw.write(s1);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
