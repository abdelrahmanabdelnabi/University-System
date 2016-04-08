package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewDepartmentPanel extends JPanel {
	private JLabel titleLabel;
	private NewDepartmentListener listener;
	private JTextField DptNameField;

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
}
