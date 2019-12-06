package edu.century.rewards_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Handles the list of Employees
 * 
 * @author qg5250wa
 *
 */
public class EmployeeListHandler {

	private Employee[] emps;
	private ArrayList<String> allNames;
	private File namesFile;

	/**
	 * Constructor, sets the list of Employees to a value.
	 * 
	 * @param amtEmployees Amount of Employees to handle
	 * @throws IOException        if reader can't read the line
	 * @throws URISyntaxException
	 */
	public EmployeeListHandler(int amtEmployees) throws IOException {

		try {
			namesFile = new File(getClass().getResource("genNames.txt").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		allNames = new ArrayList<String>();
		emps = new Employee[amtEmployees];
		
		BufferedReader reader = new BufferedReader(new FileReader(namesFile));
		while (reader.ready()) {
			allNames.add(reader.readLine());
		}
		reader.close();
		
		for (int i = 0; i < emps.length; i++)
			generateEmployee(i);
	}

	/**
	 * Gets every name available to use from genNames.txt
	 * 
	 * @return Every name
	 */
	public String getAllNames() {
		String retval = "";
		for (int i = 0; i < allNames.size(); i++) {
			retval += i + ": " + allNames.get(i) + System.lineSeparator();
		}
		return retval;
	}

	/**
	 * Gets the names currently active in the rankings board
	 * 
	 * @return Current names
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

	/**
	 * Generates an employee with 0 ranking points
	 */
	public void generateEmployee(int index) {
		emps[index] = new Employee(allNames.get((int) (Math.random() * allNames.size())),
				(int) (1 + Math.random() * 10), (int) (1 + Math.random() * 10));
	}

	/**
	 * Generates an Employee with the set number of ranking points
	 * 
	 * @param rankingPoints Ranking points to start off with
	 */
	public void generateEmployee(int index, int rankingPoints) {
		emps[index] = new Employee(allNames.get((int) (1 + Math.random() * allNames.size())),
				(int) (1 + Math.random() * 10), (int) (1 + Math.random() * 10), rankingPoints);
	}

	@Override
	public String toString() {
		String retval = "";
		for (int i = 0; i < emps.length; i++) {
			retval += (i + 1) + ": " + emps[i].getName() + System.lineSeparator() + "\tRP: " + emps[i].getRankingPoints()
					+ " Ethic: " + emps[i].getWorkEthic() + " Social: " + emps[i].getSociability()
					+ System.lineSeparator();
		}
		return retval;
	}
}