package edu.century.rewards_system;

import javax.swing.*;
/*
 * GUI Elements to add:
 * Toolbar [top]
 * List of employees [center, possible GridLayout]
 * * Sorted by ranking (highest amount of points to lowest)
 */
@SuppressWarnings("serial")
public class RankingBoardGUI extends JFrame {
	
	private EmployeeListHandler empList;
	private final int amtEmps = 10;

	public RankingBoardGUI(String winTitle) {
		super(winTitle);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 450);
		setVisible(true);
		
//		empList = new EmployeeListHandler(amtEmps);
	}
}
