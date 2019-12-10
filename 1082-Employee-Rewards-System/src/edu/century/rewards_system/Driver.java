package edu.century.rewards_system;

public class Driver {

	public static void main(String[] args) {
		EmpListHandler listH = new EmpListHandler(10);
		new SurveyHandler(listH);
	}
}
