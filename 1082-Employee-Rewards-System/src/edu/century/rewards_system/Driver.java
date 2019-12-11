package edu.century.rewards_system;

public class Driver {

	public static void main(String[] args) {
		EmpListHandler emps = new EmpListHandler(10);
		new SurveyGUI("GUI", emps);
	}
}
