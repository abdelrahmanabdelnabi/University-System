package gui.view.searchpanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btnDelete;
	private JButton MainMenuBtn;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		
		StudentRBtn = new JRadioButton("student");
		StudentRBtn.setBounds(50, 36, 109, 23);
		StudentRBtn.setSelected(true);
		add(StudentRBtn);
		
		ProfessorRBtn = new JRadioButton("professor");
		ProfessorRBtn.setBounds(186, 36, 109, 23);
		add(ProfessorRBtn);
		
		CourseRBtn = new JRadioButton("course");
		CourseRBtn.setBounds(315, 36, 109, 23);
		add(CourseRBtn);
		
		DepartmentRBtn = new JRadioButton("department");
		DepartmentRBtn.setBounds(437, 36, 109, 23);
		add(DepartmentRBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(60, 83, 49, 23);
		add(lblName);
		
		SearchField = new JTextField();
		SearchField.setBounds(150, 85, 160, 20);
		add(SearchField);
		SearchField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(60, 138, 486, 187);
		add(textArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(345, 84, 89, 23);
		add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = SearchField.getText();
				int type = getSelectedBtn();
				
				SearchPanelEvent ev = new SearchPanelEvent(this, "search", query, type);

				if(listener != null){
					listener.SearchEventOccurred(ev);
				}
				
			}
		});
		
		group = new ButtonGroup();
		group.add(StudentRBtn);
		group.add(ProfessorRBtn);
		group.add(CourseRBtn);
		group.add(DepartmentRBtn);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = SearchField.getText();
				int type = getSelectedBtn();
				
				SearchPanelEvent ev = new SearchPanelEvent(this, "delete", query, type);

				if(listener != null){
					listener.SearchEventOccurred(ev);
				}
			}
		});
		btnDelete.setBounds(470, 84, 89, 23);
		add(btnDelete);
		
		MainMenuBtn = new JButton("Main Menu");
		MainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPanelEvent ev = new SearchPanelEvent(this);
				ev.setAction("main");
				
				if(listener != null){
					listener.SearchEventOccurred(ev);
				}
			}
		});
		MainMenuBtn.setBounds(399, 351, 160, 23);
		add(MainMenuBtn);

	}
	
	public void setSearchPanelListener(SearchPanelListener listener){
		this.listener = listener;
	}
	
	public JTextArea getTextArea(){
		return textArea;
	}
	
	private int getSelectedBtn(){
		if(StudentRBtn.isSelected())
			return 1;
		if(ProfessorRBtn.isSelected())
			return 2;
		if(CourseRBtn.isSelected())
			return 3;
		if(DepartmentRBtn.isSelected())
			return 4;
		return 0;
	}
}
