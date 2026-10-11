package com.cjc.ims.app.serviceimpl;

import java.util.*;

import com.cjc.ims.app.model.*;
import com.cjc.ims.app.servicei.Cjc;

public class Karvenagar implements Cjc{

	Scanner sc = new Scanner(System.in);
	
	
	Map<Integer , Course> cmap = new LinkedHashMap<>();
	
	Map<Integer , Faculty> fmap = new LinkedHashMap<>();
	
	Map<Integer , Batch> bmap = new LinkedHashMap<>();
	
	Map<Integer , Student> smap = new LinkedHashMap<>();
		
	
	
	@Override
	public void addCourse() {
		
		Course c = new Course();
		
		try {
			
			System.out.println("Enter Course Id: ");
			c.setCid(sc.nextInt());
			
			
			System.out.println("Enter Course Name: ");
			c.setCname(sc.next()+sc.nextLine());
			
			cmap.put(c.getCid(), c);
			
		} catch(Exception e) {
			
			System.out.println("Enter Details In Required Data Formate.\n");
			System.out.println("-----------------------------------------");
			sc.nextLine();

		}

	}

	@Override
	public void viewCourse() {
		
		if(cmap.isEmpty()) {
			
			System.out.println("No Course Available.");
			
			
		}else {
			
			System.out.println("\n-----------Course Details-----------\n");
		
		for(Course c : cmap.values()) {
			
			System.out.println("Course Id: "+c.getCid());
			System.out.println("Course Name: "+c.getCname());
			System.out.println("--------------------------");
		}
		
	}
		
}

	@Override
	public void addFaculty() {

		Faculty f = new Faculty();
		
		try {
			
		if(cmap.isEmpty()) {
			
			System.out.println("No Course Available, Add Course First");
			
		}
		
		else {
			
				
				System.out.println("Enter Faculty Id: ");
				f.setFid(sc.nextInt());
				
				System.out.println("Enter Faculty Name: ");
				f.setFname(sc.next()+sc.nextLine());
				
				System.out.println("\n-----------Course Details-----------\n");
				
				for(Course c : cmap.values()) {
					
					System.out.println("Course Id: "+c.getCid());
					System.out.println("Course Name: "+c.getCname());
					System.out.println("--------------------------");		

				}
				
				System.out.println("Enter Course Id To Assign Faculty:");
				
				int id = sc.nextInt();
				
				if(cmap.containsKey(id)) {
					
					Course c = cmap.get(id);

					f.setCourse(c);
					
					fmap.put(f.getFid(), f);
					
			        System.out.println("Faculty Added Successfully.");

				} else {
					
			        System.out.println("Invalid Course Id.");

				}
		} 
		
		} catch(Exception e) {
			
			System.out.println("Enter Details In Required Data Formate.\n");
			System.out.println("-----------------------------------------");
			sc.nextLine();

		}
	}

	@Override
	public void viewFaculty() {

		if(fmap.isEmpty()) {
			
			System.out.println("No Faculty Avalaibe");
			return;
			
		} else {
			
				System.out.println("\n-----------Faculty Details-----------\n");	
			for(Faculty f : fmap.values()) {
				
				System.out.println("Faculty Id: "+f.getFid());
				System.out.println("Faculty Name: "+f.getFname());

				Course c = f.getCourse();
				
				if(c!=null) {
					
					System.out.println("Assigned Course Id: "+c.getCid());
					System.out.println("Assigned Course Name: "+c.getCname());
				}
				
				System.out.println("--------------------------");
			}
		}
	}

	@Override
	public void addBatch() {

		Batch b = new Batch();
		
		try {
			
		if(fmap.isEmpty()) {
			
			System.out.println("No Faculty Avalible, Add Faculty First");
			return;
			
		} else {
			
			
				
				System.out.println("\n-----------Batch Detalis-----------\n");
				System.out.println("Enter Batch Id: ");
				b.setBid(sc.nextInt());
				
				System.out.println("Enter Batch Name: ");
				b.setBname(sc.next()+sc.nextLine());
				
				System.out.println("Enter Faculty Id To Assign Batch: ");
				
				System.out.println("\n-----------Faculty Detalis-----------\n");
				
			for(Faculty f : fmap.values()) {
				
				System.out.println("Faculty Id: "+f.getFid());
				System.out.println("Faculty Name: "+f.getFname());

				Course c = f.getCourse();
				
				if(c!=null) {
					
					System.out.println("Assigned Course Id: "+c.getCid());
					System.out.println("Assigned Course Name: "+c.getCname());
				}
				
				System.out.println("--------------------------");
			   }
			
				System.out.println("Enter Id: "); 
				int id = sc.nextInt();
				
				if(fmap.containsKey(id)) {
					
					Faculty f1 = fmap.get(id);
					
					b.setFaculty(f1);
					bmap.put(b.getBid(), b);
					
			        System.out.println("Batch Added Successfully.");

					
				} else {
					
					System.out.println("Invalid Id.");
				}
				
			}
		
		} catch(Exception e) {
			
			System.out.println("Enter Details In Required Data Formate.\n");
			System.out.println("-----------------------------------------");
			sc.nextLine();

		}
		
	}

	@Override
	public void viewBatch() {
		
		if(bmap.isEmpty()) {
			
			System.out.println("No Batch Avalible");
			return;
			
		} else {
			
			System.out.println("\n-----------Batch Detalis-----------\n");

			for(Batch b : bmap.values()) {
				
				
				System.out.println("Batch Id: "+b.getBid());
				System.out.println("Batch Name: "+b.getBname());
				
				Faculty f = b.getFaculty();
				
				if(f!=null) {
					
					System.out.println("Assigned Faculty Id: "+f.getFid());
					System.out.println("Assigned Faculty Name: "+f.getFname());
					
					Course c = f.getCourse();
					
					if(c!=null) {
						
						System.out.println("Assigned Course Id: "+c.getCid());
						System.out.println("Assigned Course Name: "+c.getCname());
					}
					
				}
				
				System.out.println("--------------------------");
				
			}
			
		}		
		
	}

	@Override
	public void addStudent() {

		Student s = new Student();
		
		try {
			
		if(bmap.isEmpty()) {
			
			System.out.println("No Batch Available, Add Batch First.");
			
		} else {
			
		
				
			System.out.println("Enter Student Id: ");
			s.setSid(sc.nextInt());
			
			System.out.println("Enter Student Name: ");
			s.setSname(sc.next()+sc.nextLine());
			
			System.out.println("\n-----------Batch Detalis-----------\n");

			for(Batch b : bmap.values()) {
				
				
				System.out.println("Batch Id: "+b.getBid());
				System.out.println("Batch Name: "+b.getBname());
				
				Faculty f = b.getFaculty();
				
				if(f!=null) {
					
					System.out.println("Assigned Faculty Id: "+f.getFid());
					System.out.println("Assigned Faculty Name: "+f.getFname());
					
					Course c = f.getCourse();
					
					if(c!=null) {
						
						System.out.println("Assign Course Id: "+c.getCid());
						System.out.println("Assign Course Name: "+c.getCname());
					}
					
				}
				
				System.out.println("--------------------------");
				
			}		
			
			
			System.out.println("Enter Batch Id to Assign Student: ");
			int id = sc.nextInt();
			
			if(bmap.containsKey(id)) {
				
				Batch b = bmap.get(id);
				
				s.setBatch(b);
				smap.put(s.getSid(), s);
				
				System.out.println("Student Added Successfully.");
			}
			
			else {
				
				
				System.out.println("Invalid Id.");
			}
		}
		
		} catch(Exception e) {
			
			System.out.println("Enter Details In Required Data Formate.\n");
			System.out.println("-----------------------------------------");
			sc.nextLine();

		}
	}

	@Override
	public void viewStudent() {
		
		
		if(smap.isEmpty()) {
			
			System.out.println("No Student Available. ");
			
		} else {
			
			System.out.println("\n-----------Student Detalis-----------\n");

			for(Student s : smap.values()) {
				
				
				System.out.println("Student Id: "+s.getSid());
				System.out.println("Student Name: "+s.getSname());
				
				Batch b = s.getBatch();
				
				if(b!=null) {
					
					System.out.println("Assigned Batch Id: "+b.getBid());
					System.out.println("Assigned Btach Name: "+b.getBname());
					
					Faculty f = b.getFaculty();
					
					if(f!=null) {
						
						System.out.println("Assigned Faculty Id: "+f.getFid());
						System.out.println("Assigned Faculty Name: "+f.getFname());
						
						Course c = f.getCourse();
						
						if(c!=null) {
							
							System.out.println("Assigned Course Id: "+c.getCid());
							System.out.println("Assigned Course Name: "+c.getCname());
						}
					}
				}
				
				System.out.println("--------------------------");
			}
			
		}
		
	}

	@Override
	public void deleteData() {

	    System.out.println("1.Delete Course Data ");
	    System.out.println("2.Delete Faculty Data ");
	    System.out.println("3.Delete Batch Data ");
	    System.out.println("4.Delete Student Data ");

	    int num = sc.nextInt();

	    switch (num) {

	    // ===================== COURSE =====================
	    case 1:

	        System.out.println("1. Delete All Data");
	        System.out.println("2. Delete Particular Data");

	        int choice1 = sc.nextInt();

	        switch (choice1) {

	        case 1:

	            System.out.println("Press 1 to confirm delete all data:");
	            int confirm1 = sc.nextInt();

	            if (confirm1 == 1) {
	                cmap.clear();
	                System.out.println("All Course Data Deleted Successfully.");
	            } else {
	                System.out.println("Delete Cancelled.");
	            }
	            break;

	        case 2:

	            if (cmap.isEmpty()) {
	                System.out.println("No Course Available.");
	                break;
	            }

	            System.out.println("\n------ Course Details ------");

	            for (Course c : cmap.values()) {
	                System.out.println("Course ID   : " + c.getCid());
	                System.out.println("Course Name : " + c.getCname());
	                System.out.println("----------------------------");
	            }

	            System.out.print("Enter Course ID to Delete: ");
	            int cid = sc.nextInt();

	            if (cmap.containsKey(cid)) {
	                cmap.remove(cid);
	                System.out.println("Course Deleted Successfully.");
	            } else {
	                System.out.println("Course ID Not Found.");
	            }

	            break;

	        default:
	            System.out.println("Invalid Choice.");
	        }

	        break;

	    // ===================== FACULTY =====================
	    case 2:

	        System.out.println("1. Delete All Data");
	        System.out.println("2. Delete Particular Data");

	        int choice2 = sc.nextInt();

	        switch (choice2) {

	        case 1:

	            if (fmap.isEmpty()) {
	                System.out.println("No Faculty Available.");
	                break;
	            }
	            
	            System.out.println("Press 1 to confirm delete all data:");
	            int confirm2 = sc.nextInt();

	            if (confirm2 == 1) {
	                fmap.clear();
	                System.out.println("All Faculty Data Deleted Successfully.");
	            } else {
	                System.out.println("Delete Cancelled.");
	            }

	            break;

	        case 2:

	            if (fmap.isEmpty()) {
	                System.out.println("No Faculty Available.");
	                break;
	            }

	            System.out.println("\n------ Faculty Details ------");

	            for (Faculty f : fmap.values()) {
	                System.out.println("Faculty ID   : " + f.getFid());
	                System.out.println("Faculty Name : " + f.getFname());
	                System.out.println("-----------------------------");
	            }

	            System.out.print("Enter Faculty ID to Delete: ");
	            int fid = sc.nextInt();

	            if (fmap.containsKey(fid)) {
	                fmap.remove(fid);
	                System.out.println("Faculty Deleted Successfully.");
	            } else {
	                System.out.println("Faculty ID Not Found.");
	            }

	            break;

	        default:
	            System.out.println("Invalid Choice.");
	        }

	        break;

	    // ===================== BATCH =====================
	    case 3:

	        System.out.println("1. Delete All Data");
	        System.out.println("2. Delete Particular Data");

	        int choice3 = sc.nextInt();

	        switch (choice3) {

	        case 1:

	            if (bmap.isEmpty()) {
	                System.out.println("No Batch Available.");
	                break;
	            }
	            
	            System.out.println("Press 1 to confirm delete all data:");
	            int confirm3 = sc.nextInt();

	            if (confirm3 == 1) {
	                bmap.clear();
	                System.out.println("All Batch Data Deleted Successfully.");
	            } else {
	                System.out.println("Delete Cancelled.");
	            }

	            break;

	        case 2:

	            if (bmap.isEmpty()) {
	                System.out.println("No Batch Available.");
	                break;
	            }

	            System.out.println("\n------ Batch Details ------");

	            for (Batch b : bmap.values()) {
	                System.out.println("Batch ID   : " + b.getBid());
	                System.out.println("Batch Name : " + b.getBname());
	                System.out.println("---------------------------");
	            }

	            System.out.print("Enter Batch ID to Delete: ");
	            int bid = sc.nextInt();

	            if (bmap.containsKey(bid)) {
	                bmap.remove(bid);
	                System.out.println("Batch Deleted Successfully.");
	            } else {
	                System.out.println("Batch ID Not Found.");
	            }

	            break;

	        default:
	            System.out.println("Invalid Choice.");
	        }

	        break;

	    // ===================== STUDENT =====================
	    case 4:

	        System.out.println("1. Delete All Data");
	        System.out.println("2. Delete Particular Data");

	        int choice4 = sc.nextInt();

	        switch (choice4) {

	        case 1:

	        	if (smap.isEmpty()) {
	                System.out.println("No Student Available.");
	                break;
	            }
	        	
	            System.out.println("Press 1 to confirm delete all data:");
	            int confirm4 = sc.nextInt();

	            if (confirm4 == 1) {
	                smap.clear();
	                System.out.println("All Student Data Deleted Successfully.");
	            } else {
	                System.out.println("Delete Cancelled.");
	            }

	            break;

	        case 2:

	            if (smap.isEmpty()) {
	                System.out.println("No Student Available.");
	                break;
	            }

	            System.out.println("\n------ Student Details ------");

	            for (Student s : smap.values()) {
	                System.out.println("Student ID   : " + s.getSid());
	                System.out.println("Student Name : " + s.getSname());
	                System.out.println("-----------------------------");
	            }

	            System.out.print("Enter Student ID to Delete: ");
	            int sid = sc.nextInt();

	            if (smap.containsKey(sid)) {
	                smap.remove(sid);
	                System.out.println("Student Deleted Successfully.");
	            } else {
	                System.out.println("Student ID Not Found.");
	            }

	            break;

	        default:
	            System.out.println("Invalid Choice.");
	        }

	        break;

	    default:
	        System.out.println("Please Select a Valid Option.");
	    }
	    
	    
	   }
	
	}