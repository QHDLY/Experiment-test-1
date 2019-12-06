package cn.liuy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.liuy.list.OperateList;

@Configuration
@ComponentScan(basePackages = "cn.liuy.test")
public class SpringConfig {
	
	@Bean
	public OperateList operateList()
	{
		return new OperateList();
	}
	
}
