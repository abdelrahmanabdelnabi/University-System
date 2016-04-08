package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private AddMenuPanel addMenuPane;
	private JPanel newStudentPanel;
	private NewDepartmentPanel dptPanel;
	private MainMenu mainMenuPanel;
	private NewProfPanel newProfPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		// construct the panels
		mainMenuPanel = new MainMenu();
		addMenuPane = new AddMenuPanel();
		newStudentPanel = new NewStudentPanel();
		dptPanel = new NewDepartmentPanel();
		newProfPanel = new NewProfPanel();

		// add the main menu panel to the window
		add(mainMenuPanel);

		// initialize the panels' listeners
		initMainMenuListener();
		initAddMenuListener();
		initNewDptListener();
		initNewProfListener();

	}

	/*
	 * sets the main menu panel listener
	 */
	private void initMainMenuListener() {
		mainMenuPanel.setMainMenuListener(new MainMenuListener() {
			@Override
			public void MenuEventOccurred(MainMenuEvent e) {
				// TODO check which action was triggered and switch panels
				// accordingly
				String action = e.getAction();

				if (action.equals("add")) {
					revalidate();
					setContentPane(addMenuPane);
					addMenuPane.setVisible(true);
					revalidate();
				}

			}
		});
	}

	private void initAddMenuListener() {
		addMenuPane.setMenuPanelListener(new MenuPanelListener() {
			@Override
			public void menuEventOccurred(MenuPanelEvent e) {
				// replace current panel with the new panel
				// removeAll();
				revalidate();
				// TODO check the action that was selected using e.getAction()
				// and then set the new panel accordingly
				String action = e.getAction();
				if(action.equals("student")){
					setContentPane(newStudentPanel);
					newStudentPanel.setVisible(true);
					revalidate();
				}
				else if(action.equals("department")){
					setContentPane(dptPanel);
					dptPanel.setVisible(true);
					revalidate();
				}
				else if(action.equals("professor")){
					setContentPane(newProfPanel);
					newProfPanel.setVisible(true);
					revalidate();
				}

				
			}
		});
	}
	
	private void initNewDptListener(){
		dptPanel.setEventListener(new NewDepartmentListener() {
			
			@Override
			public void departmentEventOccurred(NewDepartmentEvent e) {
				// check the action triggered
				String action = e.getAction();
				if( action.equals("new") ){
					// do as appropriate
				}
				
			}
		});
	}
	
	private void initNewProfListener(){
		newProfPanel.setNewProfListener(new NewProfListener() {
			
			@Override
			public void EventOccurred(NewProfEvent e) {
				// TODO create a new professor object with the given data in the event
			}
		});
	}

}
