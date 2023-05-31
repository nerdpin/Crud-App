package com.praveen.sort;

import java.util.Comparator;

import com.praveen.Model.Employee;

public class SortUsingemail implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getName().compareTo(e2.getName());
	}

}
