package edu.century.rewards_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.*;
import javax.swing.border.Border;

/*
 * GUI Elements to add:
 * Toolbar [top]
 * List of employees [center, possible GridLayout]
 * * Sorted by ranking (highest amount of points to lowest)
 */
@SuppressWarnings("serial")
public class RankingBoardGUI extends JFrame implements ActionListener{

	private final int AMT_EMPLOYEES = 10;

	EmpListHandler listH;
	SurveyGUI sGui;

	JPanel listPanel, logPanel, centerPanel, buttonsPanel;
	JButton stepButton, clearButton, surveyButton;
	JTextArea logText, listText;
	JScrollPane logPane, listPane;

	public RankingBoardGUI(String winTitle) {
		super(winTitle);

		listH = new EmpListHandler(AMT_EMPLOYEES);

//		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);

		// List panel
		listPanel = new JPanel();
		listText = new JTextArea(11, 50);
		listText.setEditable(false);
		for (int i = 0; i < listH.getAmtEmployees(); i++) {
			listText.append(listH.getEmployee(i).getName() + " RP: " + listH.getEmployee(i).getRankingPoints() + System.lineSeparator());
		}
		listPane = new JScrollPane(listText);
		listPanel.add(listPane);

		// Log panel
		logPanel = new JPanel();
		logText = new JTextArea(5, 25);
		logText.setEditable(false);
		logPane = new JScrollPane(logText);
		logPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Log"));
		logPanel.add(logPane);

		listPanel.add(logPanel);

		// Buttons panel
		buttonsPanel = new JPanel();

		stepButton = new JButton("Next Step");
		stepButton.addActionListener(this);

		clearButton = new JButton("Clear Log");
		clearButton.addActionListener(this);

		surveyButton = new JButton("New Survey");
		surveyButton.addActionListener(this);

		buttonsPanel.add(surveyButton);
		buttonsPanel.add(stepButton);
		buttonsPanel.add(clearButton);

		add(listPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Adds Ranking Points to the employee in the given index
	 * 
	 * @param index Placement of Employee in list
	 * @param rp    Amount of ranking points to add
	 */
	public void passNewRankingValue(int index, int rp) {
		listH.addRankingPoints(index, rp);
		listH.sortList();
		listText.setText("");
		for (int i = 0; i < listH.getAmtEmployees(); i++) {
			listText.append(listH.getEmployee(i).getName() + " RP: " + listH.getEmployee(i).getRankingPoints() + System.lineSeparator());
		}
	}
	
	public void passNewRankingValue(int[] rp) {
		passNewRankingValue(rp[0], rp[1]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(surveyButton.getActionCommand())) {
			logText.append("Starting new survey..." + System.lineSeparator());
			sGui = new SurveyGUI("Customer Experience Questionairre", listH, listH.getRandomEmployee());
		}
		if (e.getActionCommand().equals(clearButton.getActionCommand())) {
			logText.setText("");
		}
		if (e.getActionCommand().equals(stepButton.getActionCommand())) {
			if(sGui != null && sGui.getSubmitted()) {
				passNewRankingValue(sGui.getTotalScore());
			}
		}
	}
}
