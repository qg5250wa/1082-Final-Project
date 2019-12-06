package edu.century.rewards_system;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This is the object class that handles Employee functions, such as generated
 * personal identifiers (like personality and name).
 * 
 * @author qg5250wa
 *
 */
public class Employee {

//	private static ArrayList<Integer> usedNames;
	private static final String nameGenFile = "genNames.txt";
	private String name;
	private int workEthic; // how hard the Employee tries at their job; 0-10
	private int sociability; // how much the Employee tries to talk to customers; 0-10
	private int rankingPoints;

	/**
	 * 
	 * @param nameIndex Which name to take from genNames.txt
	 */
	public Employee(String name, int workEthic, int sociability) {
		this.name = name;
		this.workEthic = workEthic;
		this.sociability = sociability;
	}
	
	public Employee(String name, int workEthic, int sociability, int rankingPoints) {
		this(name, workEthic, sociability);
		this.setRankingPoints(rankingPoints);
	}

	public String getName() {
		return name;
	}

	public int getWorkEthic() {
		return workEthic;
	}

	public int getSociability() {
		return sociability;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWorkEthic(int workEthic) {
		this.workEthic = workEthic;
	}

	public void setSociability(int sociability) {
		this.sociability = sociability;
	}

	public int getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

}