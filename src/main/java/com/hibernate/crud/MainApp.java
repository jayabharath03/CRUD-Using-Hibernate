package com.hibernate.crud;

import java.util.List;

import com.hibernate.crud.dao.StudentDAO;
import com.hibernate.crud.model.Student;

public class MainApp 
{
    public static void main( String[] args )
    {
    	StudentDAO dao = new StudentDAO();
    	
    	Student s1 = new Student("ram","kumar","ram@gmail.com");
    	Student s2 = new Student("mani", "dhar", "mani@gmail.com");
    	Student s3 = new Student("jaya","harish","harish@gmail.com");
    	Student s4 = new Student("rudhra","moorthy","rudhra@gmail.com");
    	
    	dao.saveStudent(s1);

    	Student fetched = dao.getStudent(1);
    	System.out.println("Fetched: "+fetched);
    	
    	Student update = dao.getStudent(23);
    	update.setEmail("mani@gmail.com");
    	dao.updateStudent(update);
    	
    	dao.deleteStudent(7);
    	
    	List<Student> allStudents = dao.getAllStudents();
    	if(allStudents != null && !allStudents.isEmpty()) {
    		for(Student s: allStudents) {
    			System.out.println(s);
    		}
    	}else {
    		System.out.println("no student records found");
    	}
    }
}
