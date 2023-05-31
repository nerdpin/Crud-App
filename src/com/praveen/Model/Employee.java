package com.praveen.Model;

import java.sql.Date;

public class Employee {
	
	private String Name;
	private String Gender;
	private String Dateofbirth;
	private String Email;
	private String Phone;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Employee(String name, String gender, String dateofbirth, String email, String phone) {
		super();
		Name = name;
		Gender = gender;
		Dateofbirth = dateofbirth;
		Email = email;
		Phone = phone;
	}




	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getDateofbirth() {
		return Dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		Dateofbirth = dateofbirth;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public void setPhone(String phone) {
		Phone = phone;
	}




	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", Gender=" + Gender + ", Dateofbirth=" + Dateofbirth + ", Email=" + Email
				+ ", Phone=" + Phone + "]";
	}
	
	
	
	

}
