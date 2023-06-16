package com.jspiders;
import com.customexception.InvalidChoiceException;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//Menu driven program
		//upcasting
		//switch case
		//System.exit(0)
		//infinite loop-->while(true)

		//accept input from the user
		Scanner sc=new Scanner(System.in);
		//upcatsing for achievingabstraction
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		System.out.println("Welcom student database project");
		System.out.println("===================");
		while(true) {
			System.out.println("1.add student\n2.display studnet\n3.display all students\n4.remove student\n5.remove all students\n6.update student\n7.count no of students\n.8.sort students\n9.Exit");
			System.out.println("enter your choice:");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: sms.addStudent();
			break;
			case 2:sms.displayStudent();
			break;
			case 3:sms.displayAllStudent();
			break;
			case 4:sms.removeStudent();
			break;
			case 5:sms.removeAllStudents();
			break;
			case 6:sms.updateStudent();
			break;
			case 7:sms.countStudents();
			break;
			case 8:sms.sortStudents();
			break;
			case 9:System.out.println("thank you");
			System.exit(0);
			default:
				try {
					throw new  InvalidChoiceException ("invalid,Kindly enter valid choice");
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		
			System.out.println("===========");
		}
		}
	}
