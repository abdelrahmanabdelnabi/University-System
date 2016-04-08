package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.LayoutFocusTraversalPolicy;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewStudentPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		lblCurrentGpa.setBounds(30, 131, 85, 14);
		add(lblCurrentGpa);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(30, 162, 85, 14);
		add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(30, 189, 85, 14);
		add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(150, 57, 163, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 84, 163, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 129, 71, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 160, 163, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 187, 233, 20);
		add(textField_4);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartment.setBounds(30, 214, 85, 22);
		add(lblDepartment);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourses.setBounds(30, 247, 85, 22);
		add(lblCourses);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(338, 111, 60, 20);
		comboBox.addItem("compu");
		comboBox.addItem("electro");
		add(comboBox);
	}
}