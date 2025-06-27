package com.hibernate.crud;

import java.util.Arrays;

import com.hibernate.crud.dao.StudentDAO;
import com.hibernate.crud.model.Courses;
import com.hibernate.crud.model.Department;
import com.hibernate.crud.model.Passport;
import com.hibernate.crud.model.Student;

public class MainApp 
{
    public static void main( String[] args )
    {
    	
    	Department dept2 = new Department(2,"ECE");
    	
    	Passport p1 = new Passport();
    	p1.setId(2);
    	p1.setPassportNumber("ksj352");
    	
    	Courses c1 = new Courses();
    	c1.setId(101);
    	c1.setCourseName("Java");
    	
    	Courses c2 = new Courses();
    	c2.setId(102);
    	c2.setCourseName("Python");
    	
    	
    	StudentDAO dao = new StudentDAO();
    	
    	
    	Student s1 = new Student("gopal","kumar","gopal@gmail.com");
    	s1.setCourses(Arrays.asList(c1,c2));
    	s1.setDepartment(dept2);

    	s1.setPassport(p1);
    	p1.setStudent(s1);
    	c1.setStudent(Arrays.asList(s1));
    	c2.setStudent(Arrays.asList(s1));
    	
    	
    	dept2.setStud(Arrays.asList(s1));
    	
    	dao.saveStudent(s1);
    
    	
    	
    	
    }
}
