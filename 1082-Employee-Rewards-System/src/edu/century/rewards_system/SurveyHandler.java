package edu.century.rewards_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/*
 * Survey questions:
 * 1: Who helped you
 * 2: Overall score 1-10 [n-5]
 * 3: Speed score 1-10 [n-5]
 * 4: Eagerness/Attentiveness score 1-10 [n-5]
 * 5: Rewards card offer [y/n] [+5, -5]
 * 6: Rewards card signup [list] [+10, +9, +8, +7, -2, 0]
 * 7: Charge card offer [y/n] [+10, -10]
 * 8: Charge card signup [list] [+20, +18, +16, +14, -4, 0]
 */
public class SurveyHandler {

	private Employee emp;
	private File summariesFile;
	private ArrayList<ArrayList<String>> synopses;
	private ArrayList<ArrayList<Integer>> workEthicMax;
	private ArrayList<ArrayList<Integer>> socialMax;

	public SurveyHandler(Employee emp) {
		this.emp = emp;
		try {
			summariesFile = new File(getClass().getResource("genTransactions.txt").toURI());
			createTransactionsList();
		} catch (URISyntaxException | IOException e) {
			System.exit(1);
		}
	}

	public void createTransactionsList() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(summariesFile));

		synopses = new ArrayList<ArrayList<String>>();
		workEthicMax = new ArrayList<ArrayList<Integer>>();
		socialMax = new ArrayList<ArrayList<Integer>>();

		while (reader.ready()) {
			if (reader.readLine().strip().startsWith("#")) {
				synopses.add(new ArrayList<String>());
				workEthicMax.add(new ArrayList<Integer>());
				socialMax.add(new ArrayList<Integer>());
			}
		}
		reader.close();

		reader = new BufferedReader(new FileReader(summariesFile));

		int index = -1;
		while (reader.ready()) {
			String temp = reader.readLine().strip();
			if (temp.startsWith("#")) {
				index++;
			} else if (temp.startsWith("{")) {
				temp = temp.substring(1);
				int tNumSize = temp.indexOf(",");
				workEthicMax.get(index).add(Integer.parseInt(temp.substring(0, tNumSize)));

				temp = temp.substring(tNumSize + 2);
				tNumSize = temp.indexOf("}");
				socialMax.get(index).add(Integer.parseInt(temp.substring(0, tNumSize)));

				temp = temp.substring(tNumSize + 2);
				synopses.get(index).add(temp);
			}
		}
		if(index == -1)
			throw new IOException("No categories!");
	}
	
	public String genSynopsis() {
		for(int i = 0; i < synopses.size(); i++) {
			
		}
	}

	/**
	 * Formats the line given, replacing instances of regex with the name given
	 * 
	 * @param replacement What to replace regex with
	 * @param line        Line that contains the regex strings
	 * @param regex       What to look for when replacing with name
	 */
	public String formatLine(String replacement, String line, String regex) {
		String retval = line;
		boolean done = false;
		while (!done) {
			if (retval.contains(regex)) {
				String[] temps = retval.split(regex);
				retval = "";
				for (int i = 0; i < temps.length - 1; i++) {
					retval += temps[i] + replacement;
				}
				retval += temps[temps.length - 1];
			} else {
				done = true;
			}
		}
		return retval;
	}

	public Employee returnEmployee() {
		return emp;
	}

}
