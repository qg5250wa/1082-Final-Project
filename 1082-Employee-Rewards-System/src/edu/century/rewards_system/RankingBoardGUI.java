package edu.century.rewards_system;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;
/*
 * GUI Elements to add:
 * Toolbar [top]
 * List of employees [center, possible GridLayout]
 * * Sorted by ranking (highest amount of points to lowest)
 */
@SuppressWarnings("serial")
public class RankingBoardGUI extends JFrame {

	JPanel listPanel, logPanel, buttonsPanel;
	JButton stepButton, clearButton, surveyButton;
	JTextArea logText;
	JScrollPane logPane;
	
	public RankingBoardGUI(String winTitle) {
		super(winTitle);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 450);
		
		//Log panel
		logPanel = new JPanel();
		logText = new JTextArea(5, 25);
		logPane = new JScrollPane(logText);
		logPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Log"));
		logPanel.add(logPane);
		
		add(logPanel, BorderLayout.CENTER);
		setVisible(true);
	}
}
