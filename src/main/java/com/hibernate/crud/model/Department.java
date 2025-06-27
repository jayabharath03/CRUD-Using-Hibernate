package com.hibernate.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	private int id;

	private String dept_name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Student> stud = new ArrayList<>();
	
	public Department(int id, String dept_name) {
		super();
		this.id = id;
		this.dept_name = dept_name;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Student> getStud() {
		return stud;
	}

	public void setStud(List<Student> stud) {
		this.stud = stud;
	}

}
