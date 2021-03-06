package gui.view.newdepartment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewDepartmentPanel extends JPanel {
	private JLabel titleLabel;
	private NewDepartmentListener listener;
	private JTextField DptNameField;

	private List<String> courses;
	/**
	 * Create the panel.
	 */
	public NewDepartmentPanel() {
		setBackground(Color.YELLOW);
		setLayout(null);

		titleLabel = new JLabel("New Department Info");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(270, 24, 147, 22);
		add(titleLabel);

		JLabel dptNameLbl = new JLabel("Department Name");
		dptNameLbl.setBounds(50, 63, 125, 20);
		add(dptNameLbl);

		DptNameField = new JTextField();
		DptNameField.setBounds(210, 63, 160, 20);
		add(DptNameField);
		DptNameField.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(300, 340, 100, 23);
		add(btnNewButton);
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewDepartmentEvent ev = new NewDepartmentEvent(this);
				ev.setAction("main");
				
				if(listener != null){
					listener.departmentEventOccurred(ev);
				}
			}
		});
		mainMenuBtn.setBounds(450, 340, 125, 23);
		add(mainMenuBtn);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the department name entered
				String dptName = DptNameField.getText();

				// check if there is text entered
				if (!dptName.isEmpty()) {
					NewDepartmentEvent ev = new NewDepartmentEvent(this, "new",
							dptName);

					// check if there are listeners
					if (listener != null) {
						listener.departmentEventOccurred(ev);
					}
				}
			}
		});

		// TODO add a courses list and an option to add existing courses to this
		// department
	}

	public void setEventListener(NewDepartmentListener listener) {
		this.listener = listener;
	}
	
	public void setCourses(List<String> courses){
		this.courses = courses;
	}
}
