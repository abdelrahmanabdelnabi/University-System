package gui.view.newprof;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class NewProfPanel extends JPanel {
	private JTextField degreeField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JSpinner SalarySpinner;
	private JRadioButton maleRBtn;
	private JRadioButton femaleRBtn;
	private ButtonGroup group;
	
	private List<String> courses;
	
	private NewProfListener listener;
	/**
	 * Create the panel.
	 */
	public NewProfPanel() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(null);
		
		JLabel lblNewProfessorInfo = new JLabel("New Professor Info");
		lblNewProfessorInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewProfessorInfo.setBounds(220, 11, 140, 24);
		add(lblNewProfessorInfo);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(30, 59, 85, 14);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(30, 93, 85, 14);
		add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(30, 124, 85, 14);
		add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(30, 160, 85, 14);
		add(lblEmail);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(150, 57, 163, 20);
		add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(150, 91, 163, 20);
		add(lastNameField);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(150, 122, 163, 20);
		add(phoneNumberField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(150, 158, 233, 20);
		add(emailField);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDegree.setBounds(30, 197, 46, 14);
		add(lblDegree);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSalary.setBounds(30, 234, 46, 14);
		add(lblSalary);
		
		degreeField = new JTextField();
		degreeField.setBounds(150, 194, 163, 20);
		add(degreeField);
		degreeField.setColumns(10);
		
		SalarySpinner = new JSpinner();
		SalarySpinner.setAlignmentX(Component.LEFT_ALIGNMENT);
		SalarySpinner.setModel(new SpinnerNumberModel(1000, 0, 100000, 50));
		SalarySpinner.setBounds(150, 231, 90, 20);
		add(SalarySpinner);
		
		maleRBtn = new JRadioButton("Male");
		maleRBtn.setBounds(150, 268, 70, 23);
		maleRBtn.setSelected(true);
		add(maleRBtn);
		
		femaleRBtn = new JRadioButton("Female");
		femaleRBtn.setBounds(233, 268, 70, 23);
		add(femaleRBtn);
		
		group = new ButtonGroup();
		group.add(maleRBtn);
		group.add(femaleRBtn);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(30, 272, 46, 14);
		add(lblGender);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the input from the fields
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String phoneNumber = phoneNumberField.getText();
				String email = emailField.getText();
				String degree = firstNameField.getText();
				float salary = (float) Float.parseFloat(SalarySpinner.getValue().toString());
				char gender = maleRBtn.isSelected() ? 'M' : 'F';

				// set each event variable with the corresponding input
				NewProfEvent ev = new NewProfEvent(this);
				ev.setFirstName(firstName);
				ev.setLastName(lastName);
				ev.setPhoneNumber(phoneNumber);
				ev.setEmail(email);
				ev.setDegree(degree);
				ev.setSalary(salary);
				
				if(listener != null){
					listener.EventOccurred(ev);
				}
				
			}
		});
		btnSubmit.setBounds(220, 330, 89, 23);
		add(btnSubmit);
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProfEvent ev = new NewProfEvent(this);
				ev.setAction("main");
				
				if(listener != null){
					listener.EventOccurred(ev);
				}
				
			}
		});
		mainMenuBtn.setBounds(381, 330, 140, 23);
		add(mainMenuBtn);
	}
	
	public void setNewProfListener(NewProfListener listener){
		this.listener = listener;
	}
	
	public void setCourses(List<String> courses){
		this.courses = courses;
	}
}
