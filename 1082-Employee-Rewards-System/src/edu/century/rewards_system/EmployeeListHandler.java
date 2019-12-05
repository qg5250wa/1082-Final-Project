package edu.century.rewards_system;

/**
 * Handles the list of Employees
 * @author qg5250wa
 *
 */
public class EmployeeListHandler {
	
	private static int listSize;
	private static Employee[] emps;
	
	/**
	 * Constructor, sets the list of Employees to a value
	 * @param amtEmployees Amount of Employees to handle
	 */
	public EmployeeListHandler(int amtEmployees) {
		listSize = amtEmployees;
		emps = new Employee[listSize];
		for(int i = 0; i < listSize; i++) {
			emps[i] = new Employee();
		}
	}
	
	/**
	 * Creates an Employee list with 10 Employees.
	 */
	public EmployeeListHandler() {
		this(10);
	}
}
