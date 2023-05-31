package com.praveen.Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.praveen.sort.SortUsingName;
import com.praveen.sort.SortUsingemail;

public class Main {
	
	private static List<Employee> employees =new ArrayList<>();
	
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int choice ;;
		
		do {
			System.out.println("   MENU:-");
			System.out.println("1. DISPLAY");
			System.out.println("2. CREATE");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. SORT");
			System.out.println("6. EXIT");
			System.out.println("Enter Your Choice: ");
			
			choice=getIntInput();
		
			switch(choice) {
			case 1:
				displayEmployee();
				break;
				
				
			case 2:
				createEmployee();
				break;
				
			case 3:
				updateEmployee();
				break;
				
			case 4:
				deleteEmployee();
				break;
				
			case 5:
				sortEmployee();
				break;
				
			case 6:
				System.out.println("Exit from Application");
				break;
				
			default:
				System.out.println("Invalid Choice. Choose Correct choice");
			}
			
		} while (choice !=6);
        
		scanner.close();
	}

	
	private static void displayEmployee() {
		
		if(employees.isEmpty()) {
			System.out.println("No employee Found");
			return;
		};
		
		System.out.println("Employees:");   
		
		for(Employee employee:employees) {
			System.out.println(employee);
		}
 		
	}
	
	private static void createEmployee() {
		
		System.out.println("CREATE Employee:");
		
	    System.out.println("Enter  Name:");
			String name=validateStringInput();
		
		System.out.println("Enter Gender:");
		String gender=validateGenderInput();
		
		
		
	    System.out.println("Enter Email:");
	    String email=validateEmailInput();
		
		System.out.println("Enter DateOfBirth:");
	    String dateofBirth=validateDateOfBirthInput();
		
	
	    System.out.println("Enter Phone:");
	    String phone=validatePhoneInput();
	    
	
	    
	    
	    Employee employee=new Employee(name, gender, dateofBirth, email, phone);
	    employees.add(employee);
	    
	    System.out.println("Employee added succesfully");
		
	}
	
	private static void updateEmployee() {
		
		System.out.println("Enter  phone of the employee to update");
		String phoneUpdate=validatePhoneInput();
		
		boolean match=false;
		
		for(Employee employee:employees) {
			if(employee.getPhone().equals(phoneUpdate)) {
				System.out.println("employee found . Enter new Details");
				
				
			    System.out.println("Enter  Name:");
				String name=validateStringInput();
				employee.setName(name);
			
				System.out.println("Enter Gender:");
				String gender=validateGenderInput();
				employee.setGender(gender);
			
			    System.out.println("Enter Email:");
			    String email=validateEmailInput();
			    employee.setEmail(email);
			
				System.out.println("Enter DateOfBirth:");
			    String dateofBirth=validateDateOfBirthInput();
			    employee.setDateofbirth(dateofBirth);
			
			
			    System.out.println("Enter Phone:");
			    String phone=validatePhoneInput();
			    employee.setPhone(phoneUpdate);
		    
			    System.out.println("Employee updated succesfully.");
			    
			    match=true;
			    break;
			}
		}
		
		if(!match) {
			System.out.println("Employee not found.");
		}
		
	}
	
	private static void deleteEmployee() {
		
		if(employees.isEmpty()) {
			System.out.println("NO Employee found");
			return;
		}
		
		System.out.println("Enter the phone of the employee to delete");
		String phone=validatePhoneInput();
		
		boolean delete=false;
		
		for(Employee employee:employees) {
			if(employee.getPhone().equals(phone)) {
				employees.remove(employee);
				System.out.println("Employee Remove Succesfully");
				
				delete=true;
				break;
			}	
		}
		
		if(!delete) {
			System.out.println("Employee not Found");
		}

	}
	
	private static void sortEmployee() {
		if(employees.isEmpty()) {
			
			System.out.println("Employee Notfound");
			return;
		}
		
		
		System.out.println("Sorting employees:");
		
		System.out.println("1. Sort By Name");
		
		System.out.println("Enter your choice:");
		
		int choice=scanner.nextInt();
		
		switch(choice) {
		case 1:
			
			Collections.sort(employees,new SortUsingName());
			
			for(Employee emp:employees) {
				System.out.println(emp.toString());
			}
			System.out.println("Employee sort by Name successfully.");
			break;
	    
			
		case 2:
		Collections.sort(employees,new SortUsingemail());
			
			for(Employee emp:employees) {
				System.out.println(emp.toString());
			}
			System.out.println("Employee sort by Email successfully.");
			break;
		
	}

}
	
	
	
	
//	validation for valid input 
	private static int getIntInput() {
		
	    int input;
	    while (true) {
	        try {
	            input = scanner.nextInt();
	            scanner.nextLine(); 
	            break;
	        }
	        catch (InputMismatchException e) {
	            scanner.nextLine(); 
	            System.out.print("Invalid input. Please enter a number: ");
	           }
	    }
	        
	        return input;

	}
	
	
//	gender validations 
	private static String validateGenderInput() {
	    String input;
	    while (true) {
	        input = scanner.next();
	        if (input.equalsIgnoreCase("male") || input.equalsIgnoreCase("female")) {
	            break;
	        } else {
	            System.out.println("Invalid input. Please enter 'Male' or 'Female':");
	        }
	    }
	    return input;
	}
	
	
//	validation for email
	private static String validateEmailInput() {
	    String input;
	    while (true) {
	        input = scanner.next();
	        if (input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            break;
	        } else {
	            System.out.println("Invalid input. Please enter a valid email address:");
	        }
	    }
	    return input;
	}
	
//	validation for dateofbirth
	private static String validateDateOfBirthInput() {
	    String input;
	    while (true) {
	        input = scanner.next();
	        if (input.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
	            break;
	        } else {
	            System.out.println("Invalid input. Please enter date of birth in the format 'dd-mm-yyyy':");
	        }
	    }
	    return input;
	}

	private static String validateStringInput() {
	    String input;
	    while (true) {
	        input = scanner.next();
	        if (input.matches("^[a-zA-Z\\s]+$")) {
	            break;
	        } else {
	            System.out.println("Invalid input. Please enter a valid string:");
	        }
	    }
	    return input;
	}
//	validation for phonenumber
	private static String validatePhoneInput() {
	    String input;
	    while (true) {
	        input = scanner.next();
	        if (input.matches("^\\d{10}$")) {
	            break;
	        } else {
	            System.out.println("Invalid input. Please enter a 10-digit phone number:");
	        }
	    }
	    return input;
	}
}


