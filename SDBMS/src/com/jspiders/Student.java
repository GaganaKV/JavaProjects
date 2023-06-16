package com.jspiders;

public class Student {
private String id;
private String name;
private int age;
private int marks;
private static int count=101;
Student(String name,int age,int marks){
	this.id="JSP"+count;
	this.name=name;
	this.age=age;
	this.marks=marks;
	count++;
}
public String getId() {
	return id;
}
public void setName(String name) {
	this.name=name;
}
public String getName() {
	return name;
}
public void setAge(int age) {
	this.age=age;
}
public int getAge() {
	return age;
}
public void setMarks(int marks) {
	this.marks=marks;
}
public int getMarks() {
	return marks;
}
@Override
public String toString() {
	return "Student id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks ;
}


}
