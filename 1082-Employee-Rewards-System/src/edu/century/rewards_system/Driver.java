package edu.century.rewards_system;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		EmployeeListHandler listH = null;
		try {
			listH = new EmployeeListHandler(10);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listH);
		
	}
}
