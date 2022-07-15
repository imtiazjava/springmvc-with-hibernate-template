package com.cgi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String getAllEmployees(Model model) {
		List<Employee> list=this.employeeDAO.getAllEmployee();
		System.out.println(list);
		model.addAttribute("list",list);
		return "emp-details";
	}
	
	@RequestMapping(value="/employee/{id}",method =RequestMethod.GET)
	public String deleteById(@PathVariable("id") int id) {
		  if(this.employeeDAO.deleteById(id))
			  return "emp-details";
		  else
			  return "home";
	}
}
