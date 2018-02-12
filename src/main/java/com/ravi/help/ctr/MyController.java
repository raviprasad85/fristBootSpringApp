package com.ravi.help.ctr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyController {
    
	@RequestMapping(value="/welcome",method=RequestMethod.POST)
	public String WelcomeNsg() {
		return"welcom to iam indianvvv";
	}
	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	public String getusername(@RequestParam(value="myName")String name) {
		
		return "welcome in india mr "+name;
	}
}
