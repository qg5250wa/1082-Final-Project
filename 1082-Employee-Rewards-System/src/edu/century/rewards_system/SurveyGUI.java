package edu.century.rewards_system;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Survey questions:
 * 1: Who helped you
 * 2: Overall score 1-10 [n-(max/2)]
 * 3: Speed score 1-10 [n-(max/2)]
 * 4: Eagerness/Attentiveness score 1-10 [n-(max/2)]
 * 5: Rewards card offer [y/n] [+5, -5]
 * 6: Rewards card signup [list] [+10, +9, +8, +7, -2, 0]
 * 7: Charge card offer [y/n] [+10, -10]
 * 8: Charge card signup [list] [+20, +18, +16, +14, -4, 0]
 */
public class SurveyGUI extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 2010821726451298482L;

	private JLabel[] questions;
	private JComboBox<String> cEmps;
	private JSlider sOverall, sSpeed, sAttention;
	private JRadioButton[] bRewards, bRewardsSignup, bCharge, bChargeSignup;
	private ButtonGroup gRewards, gRewardsSignup, gCharge, gChargeSignup;
	private JButton bSubmit, bClose;
	private JPanel pMainUpper, pMainLower, pMain, pBottom;
	private JTextField tOverall, tSpeed, tAttention;
	private int nOverall = 5, nSpeed = 5, nAttention = 5;

	public SurveyGUI(String title, EmpListHandler emps, Employee correctEmp) {
		super(title);
		setSize(450, 830);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		questions = new JLabel[] { new JLabel("Who was the employee who handled your transaction?"), new JLabel(
				"<html>Out of 10, please rate your transaction,<br>with 10 being the best and 1 being the worst</html>"),
				new JLabel(
						"<html>Out of 10, please rate the speed of your transaction,<br>with 10 being the fastest and 1 being the slowest</html>"),
				new JLabel(
						"<html>Out of 10, please rate the eagerness and attentiveness of<br>the employee who helped you, with 10 being the most eager and<br>attentive and 1 being the least eager and attentive</html>"),
				new JLabel("<html>Did the employee who handled your transaction offer you a Rewards Card?</html>"),
				new JLabel("Did you sign up for a Rewards Card?"),
				new JLabel("<html>Did the employee who handled your transaction offer you a Charge Card?</html>"),
				new JLabel("Did you sign up for a Charge Card?") };

		cEmps = new JComboBox<String>(emps.getActiveNames());
		cEmps.setPrototypeDisplayValue("mmmmmmmmmmmmmmmmm");

		sOverall = new JSlider(1, 10, 5);
		sOverall.setMinorTickSpacing(1);
		sOverall.setPaintTicks(true);
		sOverall.addChangeListener(this);

		sSpeed = new JSlider(1, 10);
		sSpeed.setMinorTickSpacing(1);
		sSpeed.setPaintTicks(true);
		sSpeed.addChangeListener(this);

		sAttention = new JSlider(1, 10);
		sAttention.setMinorTickSpacing(1);
		sAttention.setPaintTicks(true);
		sAttention.addChangeListener(this);

		tOverall = new JTextField("5", 2);
		tOverall.setEditable(false);
		tSpeed = new JTextField("5", 2);
		tSpeed.setEditable(false);
		tAttention = new JTextField("5", 2);
		tAttention.setEditable(false);

		bRewardsSignup = new JRadioButton[] { new JRadioButton("Yes, I signed up for one during this transaction"),
				new JRadioButton("Yes, I signed up for one after this transaction"),
				new JRadioButton("No, but I will sign up for one"), new JRadioButton("No, because I already have one"),
				new JRadioButton("No, and I don't intend on signing up for one"),
				new JRadioButton("No, because I was never offered one") };
		gRewardsSignup = new ButtonGroup();
		for (int i = 0; i < bRewardsSignup.length; i++) {
			gRewardsSignup.add(bRewardsSignup[i]);
		}

		bChargeSignup = new JRadioButton[] { new JRadioButton("Yes, I signed up for one during this transaction"),
				new JRadioButton("Yes, I signed up for one after this transaction"),
				new JRadioButton("No, but I will sign up for one"), new JRadioButton("No, because I already have one"),
				new JRadioButton("No, and I don't intend on signing up for one"),
				new JRadioButton("No, because I was never offered one") };
		gChargeSignup = new ButtonGroup();
		for (int i = 0; i < bChargeSignup.length; i++)
			gChargeSignup.add(bChargeSignup[i]);

		bRewards = new JRadioButton[] { new JRadioButton("Yes"), new JRadioButton("No") };
		gRewards = new ButtonGroup();
		for (int i = 0; i < bRewards.length; i++)
			gRewards.add(bRewards[i]);

		bCharge = new JRadioButton[] { new JRadioButton("Yes"), new JRadioButton("No") };
		gCharge = new ButtonGroup();
		for (int i = 0; i < bCharge.length; i++)
			gCharge.add(bCharge[i]);

		bSubmit = new JButton("Submit");
		bSubmit.addActionListener(this);
		bClose = new JButton("Close");
		bClose.addActionListener(this);

		pMainUpper = new JPanel();
		pMainUpper.add(questions[0]);
		pMainUpper.add(cEmps);
		pMainUpper.add(questions[1]);
		pMainUpper.add(sOverall);
		pMainUpper.add(tOverall);
		pMainUpper.add(questions[2]);
		pMainUpper.add(sSpeed);
		pMainUpper.add(tSpeed);
		pMainUpper.add(questions[3]);
		pMainUpper.add(sAttention);
		pMainUpper.add(tAttention);

		pMainLower = new JPanel();
		pMainLower.setLayout(new BoxLayout(pMainLower, BoxLayout.Y_AXIS));
		pMainLower.add(questions[4]);
		for (int i = 0; i < bRewards.length; i++)
			pMainLower.add(bRewards[i]);
		pMainLower.add(questions[5]);
		for (int i = 0; i < bRewardsSignup.length; i++)
			pMainLower.add(bRewardsSignup[i]);
		pMainLower.add(questions[6]);
		for (int i = 0; i < bCharge.length; i++)
			pMainLower.add(bCharge[i]);
		pMainLower.add(questions[7]);
		for (int i = 0; i < bChargeSignup.length; i++)
			pMainLower.add(bChargeSignup[i]);
		pMainUpper.add(pMainLower);

		pBottom = new JPanel();
		pBottom.add(bSubmit);
		pBottom.add(bClose);

		add(pMainUpper, BorderLayout.CENTER);
		add(pBottom, BorderLayout.SOUTH);

		setVisible(true);
	}
	
	/**
	 * Adds the score of every selected menu item.
	 * @return Total score
	 */
	public int tallyScore() {
		
		
		
		return (sOverall.getValue() - 5) + (sSpeed.getValue() - 5) + (sAttention.getValue() - 5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(bSubmit.getActionCommand())) {
			System.out.println(getSize());
		}
		if (e.getActionCommand().equals(bClose.getActionCommand())) {
			dispose();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		tOverall.setText(String.valueOf(sOverall.getValue()));
		tSpeed.setText(String.valueOf(sSpeed.getValue()));
		tAttention.setText(String.valueOf(sAttention.getValue()));
	}
}
