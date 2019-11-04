package edu.century.rewards_system;
import jdk.internal.loader.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is the object class that handles Employee functions, such as generated
 * personal identifiers (like personality and name).
 * 
 * @author qg5250wa
 *
 */
public class Employee {
	
	

	private static int totalEmployees = 0;
	private static int[] usedNames;
	private int name; // tells RankingsBoard which name to show from genNames.txt
	private int workEthic; // how hard the Employee tries at their job; 1-10
	private int sociability; // how much the Employee tries to talk to customers; 1-10

	public Employee(int amtNames) {
		name = genName(amtNames);
	}

	/**
	 * Generates a name reference to use in genNames.txt
	 * @return
	 */
	public int genName(int amtNames) {
		return (int) (1 + Math.random() * amtNames);
	}

	public static int getTotalEmployees() {
		return totalEmployees;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getWorkEthic() {
		return workEthic;
	}

	public void setWorkEthic(int workEthic) {
		this.workEthic = workEthic;
	}

	public int getExtraversion() {
		return sociability;
	}

	public void setExtraversion(int extraversion) {
		this.sociability = extraversion;
	}
}
