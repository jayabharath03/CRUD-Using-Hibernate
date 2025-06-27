package com.hibernate.crud.model;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Courses {
	
	@Id
	private int id;

	private String CourseName;
	
	@ManyToMany(mappedBy = "courses")	
	private List<Student> student = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

}
