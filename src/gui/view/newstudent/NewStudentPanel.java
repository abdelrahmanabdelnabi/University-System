package gui.view.newstudent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class NewStudentPanel extends JPanel {
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField GPAField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JSpinner ageSpinner;
	private JTextField addressField;

	private StudentPanelListener listener;
	
	private List<String> courses = new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public NewStudentPanel() {
		setBackground(Color.YELLOW);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("New Student Info");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(140, 24, 147, 22);
		add(titleLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(30, 59, 85, 14);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(30, 86, 85, 14);
		add(lblLastName);
		
		JLabel lblCurrentGpa = new JLabel("Current GPA");
		lblCurrentGpa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentGpa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentGpa.setBounds(30, 175, 85, 14);
		add(lblCurrentGpa);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(30, 206, 85, 14);
		add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(30, 233, 85, 14);
		add(lblEmail);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(150, 57, 163, 20);
		add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(150, 84, 163, 20);
		add(lastNameField);
		
		GPAField = new JTextField();
		GPAField.setColumns(10);
		GPAField.setBounds(150, 173, 71, 20);
		add(GPAField);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(150, 204, 163, 20);
		add(phoneNumberField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(150, 231, 233, 20);
		add(emailField);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartment.setBounds(30, 258, 85, 22);
		add(lblDepartment);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourses.setBounds(30, 291, 85, 22);
		add(lblCourses);
		
		JComboBox comboBox = new JComboBox(courses.toArray());
		comboBox.setBounds(150, 262, 93, 20);
		add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = "submit";
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String email = emailField.getText();
				String phoneNumber = phoneNumberField.getText();
				String address = addressField.getText();
				int age = (int) ageSpinner.getValue();
				StudentPanelEvent ev = new StudentPanelEvent(this, action);
				ev.setFirstName(firstName);
				ev.setLastName(lastName);
				ev.setEmail(email);
				ev.setPhoneNumber(phoneNumber);
				ev.setAddress(address);
				ev.setAge(age);
				
				if(listener != null){
					listener.StudentPanelEventOccurred(ev);
				}
			}
		});
		btnSubmit.setBounds(250, 334, 89, 23);
		add(btnSubmit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPanelEvent ev = new StudentPanelEvent(this, "main");
				
				if(listener != null)
					listener.StudentPanelEventOccurred(ev);
			}
		});
		btnMainMenu.setBounds(419, 334, 115, 23);
		add(btnMainMenu);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(30, 118, 85, 14);
		add(lblAddress);
		
		addressField = new JTextField();
		addressField.setBounds(150, 115, 318, 20);
		add(addressField);
		addressField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(30, 150, 85, 14);
		add(lblAge);
		
		ageSpinner = new JSpinner();
		ageSpinner.setModel(new SpinnerNumberModel(18, 14, 99, 1));
		ageSpinner.setBounds(150, 146, 57, 20);
		add(ageSpinner);
	}
	
	public void setStudentPanelListener( StudentPanelListener listener){
		this.listener = listener;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
}