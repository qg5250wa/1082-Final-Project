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
	
	private EmpListHandler listH;
	private File summariesFile;
	private ArrayList<String> synopses;
	private ArrayList<Integer> workEthicMax;
	private ArrayList<Integer> socialMax;
	
	public SurveyHandler(EmpListHandler listH) {
		this.listH = listH;
		try {
			summariesFile = new File(getClass().getResource("genTransactions.txt").toURI());
			createTransactionsList();
			System.out.println(workEthicMax.toString());
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createTransactionsList() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(summariesFile));
		synopses = new ArrayList<String>();
		workEthicMax = new ArrayList<Integer>();
		socialMax = new ArrayList<Integer>();
		
		while(reader.ready()) {
			String temp = reader.readLine().strip();
			if(temp.startsWith("{")) {
				temp = temp.substring(1);
				int tNumSize = temp.indexOf(",");
				workEthicMax.add(Integer.parseInt(temp.substring(0 , tNumSize)));
			}
		}
	}
	
}
