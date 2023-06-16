package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;
import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByName;
import com.sortinglogic.SortStudentBymarks;

public class StudentManagementSystemImpl implements StudentManagementSystem {
	//Collection-> DataBase -> Map & LinkedHashMap -> key(String) -> value(Student)
	//Scanner

	Scanner sc=new Scanner(System.in);
	Map<String,Student> db= new LinkedHashMap<String,Student>() ;

	@Override
	public void addStudent() {
		//Accept name,age,and marks
		//student object
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Age");
		int age=sc.nextInt();
		System.out.println("Enter marks");
		int marks=sc.nextInt();

		Student s=new Student(name,age,marks);
		db.put( s.getId(), s);
		System.out.println("Student Record inderted successfully!");
		System.out.println("your Sudent id is "+s.getId());


	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student id:");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student obj=db.get(id);
			System.out.println("Id: "+obj.getId());
			System.out.println("Name: "+obj.getName());
			System.out.println("Age: "+obj.getAge());
			System.out.println("Marks: "+obj.getMarks());
			//sop(obj);
			//toString() is overridden-->opt`ional
		}
		else {
			try {
				throw new StudentNotFoundException("Student record not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		Set<String> keys=db.keySet();
		System.out.println("Student Records are as follows:");
		System.out.println("================");
		if(db.size()!=0) {
			for(String key :keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				throw new StudentNotFoundException(("student records not available to display"));
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		//accept the id-String
		//uppercase
		//containsKey(

		//remove()
	//else-SNFE-handle
		System.out.println("Enter studnet id");
		//String id=sc.next();
		//id=id.toUpperCase();
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student recor deleted successfully");
		}
		else {
			try {
				throw new StudentNotFoundException("Student record not available to display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudents() {
		System.out.println("Total number of students records are:"+db.size());
		db.clear();
		System.out.println("all student records are deleted successfully!");

	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1.Update name\n2.Update Age\n3.Update marks");
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				String name=sc.next();
				std.setName(name);
				//std.setName(sc.next())
				System.out.println("name updated successfully");
				break;
			case 2:
				System.out.println("Enter age:");
				int age=sc.nextInt();
				std.setAge(age);
				//std.setName(sc.next())
				System.out.println("age updated successfully");
				break;
			case 3:
				System.out.println("Enter marks:");
				int marks=sc.nextInt();
				std.setMarks(marks);
				//std.setName(sc.next())
				System.out.println("marks updated successfully");
				break;
				
			}
		}
		

	}

	@Override
	public void countStudents() {
		System.out.println("Total Number of Records: "+db.size());

	}

	@Override
	public void sortStudents() {
		//Convert Map into Set->keySet()
  Set<String> keys=db.keySet();  //"JSP101 "JSP102"
  List<Student> list=new ArrayList<Student>();
  for(String key:keys) {
	  list.add(db.get(key));   //Adding Student Objects from Map to List
  }
  System.out.println("1.SortStudentByName\n2.SortStudentByAge");
  System.out.println("3.SortStudentByMarks");
  System.out.println("Enter your choice");
  int choice=-sc.nextInt();
  
  switch(choice) {
  case 1:
	  Collections.sort(list,new SortStudentByName());
//	  for(Student s:list) {
//		  System.out.println(s);
//	  }
	  display(list);
	  break;
  case 2:
	  Collections.sort(list,new SortStudentByAge());
	 
	  break;
  case 3:
	  Collections.sort(list,new SortStudentById());
	 display(list);
	  break;
  case 4:
	  Collections.sort(list,new SortStudentBymarks());
	display(list) ;
	break;
	
	default:
		try {
			throw new InvalidChoiceException("Invalid choice");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
  }
  }
  private static void display(List<Student> list) {
	  for(Student s:list) {
		  System.out.println(s);
	  
  }
  
  }

}
