package gui.view.newcourse;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCoursePanel extends JPanel {
	private JTextField NameField;
	JSpinner hoursSpinner;
	
	private CoursePanelListener listener;

	/**
	 * Create the panel.
	 */
	public NewCoursePanel() {
		setLayout(null);
		
		JLabel lblNewCoureInfo = new JLabel("New Coure Info");
		lblNewCoureInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewCoureInfo.setBounds(210, 21, 120, 26);
		add(lblNewCoureInfo);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(50, 65, 90, 26);
		add(lblCourseName);
		
		JLabel lblCreditHours = new JLabel("Credit hours");
		lblCreditHours.setBounds(50, 112, 90, 26);
		add(lblCreditHours);
		
		NameField = new JTextField();
		NameField.setBounds(150, 68, 150, 20);
		add(NameField);
		NameField.setColumns(10);
		
		hoursSpinner = new JSpinner();
		hoursSpinner.setModel(new SpinnerNumberModel(3, 1, 6, 1));
		hoursSpinner.setBounds(150, 115, 50, 20);
		add(hoursSpinner);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String action = "submit";
				String name = NameField.getText();
				int creditHours = (int) hoursSpinner.getValue();
				
				NewCourseEvent ev = new NewCourseEvent(this, action);
				ev.setName(name);
				ev.setCreditHours(creditHours);
				
				if(listener != null)
					listener.CourseEventOccurred(ev);
				
			}
		});
		btnSubmit.setBounds(230, 285, 89, 23);
		add(btnSubmit);
		
		JButton MainMenuBtn = new JButton("Main Menu");
		MainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCourseEvent ev = new NewCourseEvent(this, "main");
				
				if(listener != null)
					listener.CourseEventOccurred(ev);
			}
		});
		MainMenuBtn.setBounds(424, 285, 115, 23);
		add(MainMenuBtn);

	}
	
	public void setNewCoursePanelListener(CoursePanelListener listener){
		this.listener = listener;
	}

}
