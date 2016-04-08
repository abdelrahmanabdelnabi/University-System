package gui;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {
	private JTextField SearchField;
	private JRadioButton StudentRBtn;
	private JRadioButton ProfessorRBtn;
	private JRadioButton CourseRBtn;
	private JRadioButton DepartmentRBtn;
	private JTextArea textArea;
	private ButtonGroup group;
	
	private SearchPanelListener listener;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		
		StudentRBtn = new JRadioButton("student");
		StudentRBtn.setBounds(50, 80, 109, 23);
		StudentRBtn.setSelected(true);
		add(StudentRBtn);
		
		ProfessorRBtn = new JRadioButton("professor");
		ProfessorRBtn.setBounds(186, 80, 109, 23);
		add(ProfessorRBtn);
		
		CourseRBtn = new JRadioButton("course");
		CourseRBtn.setBounds(315, 80, 109, 23);
		add(CourseRBtn);
		
		DepartmentRBtn = new JRadioButton("department");
		DepartmentRBtn.setBounds(437, 80, 109, 23);
		add(DepartmentRBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(60, 127, 49, 23);
		add(lblName);
		
		SearchField = new JTextField();
		SearchField.setBounds(150, 129, 160, 20);
		add(SearchField);
		SearchField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(60, 182, 486, 187);
		add(textArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(390, 128, 89, 23);
		add(btnSearch);
		
		group = new ButtonGroup();
		group.add(StudentRBtn);
		group.add(ProfessorRBtn);
		group.add(CourseRBtn);
		group.add(DepartmentRBtn);

	}
	
	public void setSearchPanelListener(SearchPanelListener listener){
		this.listener = listener;
	}
}
