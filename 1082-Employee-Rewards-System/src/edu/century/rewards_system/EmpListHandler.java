package edu.century.rewards_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles the list of Employees
 * 
 * @author qg5250wa
 *
 */
public class EmpListHandler {

	public static final int RANKING_POINTS = 0;
	public static final int SOCIABILITY = 1;
	public static final int WORK_ETHIC = 2;

	private Employee[] emps;
	private ArrayList<String> allNames;
	private File namesFile;

	/**
	 * Constructor for EmployeeListHandler
	 * 
	 * @param listSize Amount of Employees to handle
	 * @throws IOException If the file reader can't read the genNames.txt file
	 *                     correctly (e.g. it doesn't exist)
	 */
	public EmpListHandler(int listSize) {

		try {
			namesFile = new File(getClass().getResource("genNames.txt").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		allNames = new ArrayList<String>();
		emps = new Employee[listSize];

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(namesFile));
			while (reader.ready()) {
				allNames.add(reader.readLine()); // adds each line of the txt to the list, as long as there is a line to
													// read.
			}
			reader.close(); // close the reader; we don't need it anymore.
		} catch (IOException e) {
			System.err.println("File can't be read properly!");
		}

		for (int i = 0; i < emps.length; i++)
			generateEmployee(i);
	}

	/**
	 * 
	 * @return Every name in genNames.txt
	 */
	public String getAllNames() {
		String retval = "";
		for (int i = 0; i < allNames.size(); i++) {
			retval += i + ": " + allNames.get(i) + System.lineSeparator();
		}
		return retval;
	}
	
	/**
	 * 
	 * @return How many employees are in the current list
	 */
	public int getAmtEmployees() {
		return emps.length;
	}

	/**
	 * 
	 * @return All names currently in the Employee List
	 */
	public String getActiveNames() {
		String retval = "";
		for (int i = 0; i < emps.length; i++) {
			if (emps[i] != null && emps[i].getName() != null)
				retval += i + ": " + emps[i].getName() + System.lineSeparator();
		}
		return retval;
	}

	/**
	 * Replaces an employee from the list with a null value
	 * 
	 * @param rip Name of the employee to be canned
	 * @return true if the employee was found and removed, false if the employee
	 *         couldn't be found
	 */
	public boolean remove(String rip) {
		for (int i = 0; i < emps.length; i++) {
			if (emps[i].getName().equals(rip)) {
				emps[i] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets a certain variable in one of the Employees in the list
	 * 
	 * @param index Which entry in the list to change
	 * @param var   Which variable to change (use this class's enums)
	 * @param value Value to set the variable to
	 */
	public void setEmployeeValue(int index, int var, int value) {
		switch (var) {
		case RANKING_POINTS:
			emps[index].setRankingPoints(value);
			break;
		case SOCIABILITY:
			emps[index].setSociability(value);
			break;
		case WORK_ETHIC:
			emps[index].setWorkEthic(value);
			break;
		default:
			break;
		}
	}
	/**
	 * Adds the specified amount of ranking points to the Employee at the given index
	 * @param index Which Employee to add ranking points to
	 * @param value How many ranking points to add
	 */
	public void addRankingPoints(int index, int value) {
		emps[index].addRankingPoints(value);
	}

	/**
	 * Attempts to fill in the gaps created by removed Employees.
	 */
	public void fillGaps() {
		int minPts = emps[0].getRankingPoints();
		int maxPts = 0;
		int err = (int) (Math.random() * (minPts / 2));

		for (int i = 0; i < emps.length; i++) {
			if (emps[i].getRankingPoints() > maxPts)
				maxPts = emps[i].getRankingPoints();
			else if (emps[i].getRankingPoints() < minPts)
				minPts = emps[i].getRankingPoints();
		}

		for (int i = 0; i < emps.length; i++) {
			if (emps[i] == null) {
				generateEmployee(i, ((minPts + maxPts) / 2) + err);
			}
		}
	}
	
	public Employee searchEmployees(String name){
		for(int i = 0; i < emps.length; i++) {
			if(name.equals(emps[i].getName())) {
				return emps[i];
			}
		}
		return null;
	}

	/**
	 * Sorts the list by ranking points, and puts null values at the bottom
	 */
	public void sortList() {
		Arrays.sort(emps);
	}

	/**
	 * Generates an employee with 0 ranking points
	 */
	public void generateEmployee(int index) {
		generateEmployee(index, 0);
	}

	/**
	 * Generates an Employee with the set number of ranking points
	 * 
	 * @param rankingPoints Ranking points to start off with
	 */
	public void generateEmployee(int index, int rankingPoints) {
		boolean used = false;
		String newName = "";
		do {
			newName = allNames.get((int) (Math.random() * allNames.size()));
			for (int i = 0; i < emps.length; i++) {
				if (emps[i] != null) {
					if (!emps[i].getName().equals(newName)) {
						used = false;
					} else {
						used = true;
						break;
					}
				}
			}
		} while (used);
		emps[index] = new Employee(newName, (int) (1 + Math.random() * 10), (int) (1 + Math.random() * 10),
				rankingPoints);
		// creates an employee with random name from allNames, random workEthic (0-10
		// incl.) and random Sociability (0-10 incl.)
	}

	@Override
	public String toString() {
		String retval = "";
		for (int i = 0; i < emps.length; i++) {
			retval += (i + 1) + ": " + emps[i].getName() + System.lineSeparator() + "\tRP: "
					+ emps[i].getRankingPoints() + " Ethic: " + emps[i].getWorkEthic() + " Social: "
					+ emps[i].getSociability() + System.lineSeparator();
		}
		return retval;
	}
}