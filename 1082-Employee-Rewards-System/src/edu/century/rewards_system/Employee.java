package edu.century.rewards_system;

/**
 * This is the object class that handles Employee functions, such as generated
 * personal identifiers (like personality and name).
 * 
 * @author qg5250wa
 *
 */
public class Employee implements Comparable<Employee> {

//	private static ArrayList<Integer> usedNames;
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
		this.rankingPoints = rankingPoints;
	}
	
	/**
	 * Adds the specified amount of ranking points to this Employee
	 * @param value How many ranking points to add
	 */
	public void addRankingPoints(int value) {
		rankingPoints += value;
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

	public int getRankingPoints() {
		return rankingPoints;
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

	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

	@Override
	public int compareTo(Employee o) {
		if (rankingPoints == o.getRankingPoints())
			return 0;
		else if (rankingPoints > o.getRankingPoints())
			return -1;
		else if (rankingPoints < o.getRankingPoints())
			return 1;
		else
			return 0;
	}

}