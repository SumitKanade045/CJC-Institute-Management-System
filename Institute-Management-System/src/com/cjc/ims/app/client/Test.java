package com.cjc.ims.app.client;

import com.cjc.ims.app.servicei.*;
import com.cjc.ims.app.serviceimpl.*;
import com.cjc.ims.app.model.*;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Cjc c = new Karvenagar();
		
		System.out.println("\n=====IMS=====\n");
		
		
		try {


		while(true) {
			
			
			System.out.println("1.Add Course\n"+"2.View Course\n"+"3.Add Faculty\n"+"4.View Faculty\n"+"5.Add Batch\n"+"6.View Batch\n"+"7.Add Student\n"+"8.View Student\n"+"9.Delete Record\n"+"10.Exite\n");
			System.out.println("\nEnter Your Choise: ");
			int n = sc.nextInt();
			sc.nextLine();
			
			
			switch(n) {
			
			case 1:
				
				c.addCourse();
				break;
				
			case 2:
				
				c.viewCourse();
				break;
				
			case 3:
				
				c.addFaculty();
				break;
				
			case 4:
				
				c.viewFaculty();
				break;
				
			case 5:
				
				c.addBatch();
				break;
				
			case 6:
				
				c.viewBatch();
				break;
				
			case 7:
				
				c.addStudent();
				break;
				
			case 8:
				
				c.viewStudent();
				break;
				
			case 9:
				
				c.deleteData();
				break;
				
			case 10:
				
				System.out.println("Thank You!");
				System.exit(0);
				
				
			default: 
				
				System.out.println("Enter valid Choise.");
			
			}
		}
		
		} catch(Exception e) {
			
			System.out.println("Enter Number only.");
			sc.nextLine();
			
		}
		
	}

}
