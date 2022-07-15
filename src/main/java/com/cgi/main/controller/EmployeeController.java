package com.cgi.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.main.dao.EmployeeDAO;
import com.cgi.main.model.Employee;

@Controller
@RequestMapping
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/home")
	public String indexView() {
		return "home";
	}
	
	@RequestMapping(value = "/store",method=RequestMethod.POST)
	public String  store(@ModelAttribute Employee emp) {
			boolean b=this.employeeDAO.insert(emp);
			if(b==true)
				return "success";
			else
				return "home";
	}
}
