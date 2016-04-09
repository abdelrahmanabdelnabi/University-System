package gui.view.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private MainMenuListener listener;
	
	/**
	 * Create the panel.
	 */
	public MainMenu() {
		
		setBackground(Color.blue);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JButton addBtn = new JButton("Add");
		
		addBtn.setBounds(223, 51, 120, 23);
		add(addBtn);
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuEvent ev = new MainMenuEvent(this, "add");
				
				if(listener != null){
					listener.MenuEventOccurred(ev);
				}
			}
		});
		
		
		
		JButton editBtn = new JButton("Edit");
		editBtn.setBounds(223, 97, 120, 23);
		add(editBtn);

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(223, 190, 120, 23);
		add(deleteBtn);

		JButton searchBtn = new JButton("Search/Delete");
		searchBtn.setBounds(223, 143, 120, 23);
		add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuEvent ev = new MainMenuEvent(this, "search");
				
				if(listener != null){
					listener.MenuEventOccurred(ev);
				}
			}
		});

		JLabel lblAlexandriaUniversitySystem = new JLabel(
				"Alexandria University System");
		lblAlexandriaUniversitySystem
				.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlexandriaUniversitySystem.setBounds(154, 11, 250, 18);
		add(lblAlexandriaUniversitySystem);
	
	} // end constructor
	
	public void setMainMenuListener(MainMenuListener listener){
		this.listener = listener;
	}

}
