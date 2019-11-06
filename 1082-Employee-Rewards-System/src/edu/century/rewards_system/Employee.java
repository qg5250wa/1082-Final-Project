package edu.century.rewards_system;

import java.util.ArrayList;
/**
 * This is the object class that handles Employee functions, such as generated
 * personal identifiers (like personality and name).
 * 
 * @author qg5250wa
 *
 */
public class Employee {

//	private static int totalEmployees = 0;
	private static ArrayList<Integer> usedNames;
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
		int temp = 0;
		while(temp == 0) {
			temp = (int) (1 + Math.random() * amtNames);
			for(int i = 0; i < usedNames.size(); i++) {
				if(temp == usedNames.get(i))
					temp = 0;
				else {
					usedNames.add(temp);
				}
			}
		}
		return temp;
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

	public int getSociability() {
		return sociability;
	}

	public void setSociability(int extraversion) {
		this.sociability = extraversion;
	}
}
