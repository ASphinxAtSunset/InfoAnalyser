package com.spider.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/spider/condition")
public class ConditionController {
	
	@RequestMapping(value="/test")
	public void getAllConditions(Map<String,Object> map){
		String testvalue = (String) map.get("test");
		System.out.println("测试输出===="+testvalue);
	}
}
