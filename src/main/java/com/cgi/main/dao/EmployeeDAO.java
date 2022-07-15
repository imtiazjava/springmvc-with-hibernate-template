package com.cgi.main.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cgi.main.model.Employee;

@Component
public class EmployeeDAO {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public boolean insert(Employee emp) {
		template.save(emp);
		return true;
	}
}
