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

import system.University;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private AddMenuPanel addMenuPane;
	private NewStudentPanel newStudentPanel;
	private NewDepartmentPanel dptPanel;
	private MainMenu mainMenuPanel;
	private NewProfPanel newProfPanel;
	private SearchPanel searchPanel;

	private University university = new University();

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
		searchPanel = new SearchPanel();

		// add the main menu panel to the window
		add(mainMenuPanel);

		// initialize the panels' listeners
		initMainMenuListener();
		initAddMenuListener();
		initNewDptListener();
		initNewProfListener();
		initSearchPanelListener();
		initStudentPanelListener();
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
				} else if (action.equals("search")) {
					revalidate();
					setContentPane(searchPanel);
					searchPanel.setVisible(true);
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
				if (action.equals("student")) {
					setContentPane(newStudentPanel);
					newStudentPanel.setVisible(true);
					revalidate();
				} else if (action.equals("department")) {
					setContentPane(dptPanel);
					dptPanel.setVisible(true);
					revalidate();
				} else if (action.equals("professor")) {
					setContentPane(newProfPanel);
					newProfPanel.setVisible(true);
					revalidate();
				}

			}
		});
	}

	private void initNewDptListener() {
		dptPanel.setEventListener(new NewDepartmentListener() {

			@Override
			public void departmentEventOccurred(NewDepartmentEvent e) {
				// check the action triggered
				String action = e.getAction();
				if (action.equals("new")) {
					// do as appropriate
				}

			}
		});
	}

	private void initNewProfListener() {
		newProfPanel.setNewProfListener(new NewProfListener() {

			@Override
			public void EventOccurred(NewProfEvent e) {
				// TODO create a new professor object with the given data in the
				// event

				university.addprof(e.getFirstName() + " " + e.getLastName());
			}
		});
	}

	private void initSearchPanelListener() {
		searchPanel.setSearchPanelListener(new SearchPanelListener() {

			@Override
			public void SearchEventOccurred(SearchPanelEvent e) {
				int type = e.getType();

				// TODO add other cases
				switch (type) {
				case 1:
					if (university.findstudent(e.getQuery()) != null) {
						String result = university.findstudent(e.getQuery())
								.getName();
						searchPanel.getTextArea().setText(result);
					} else {
						searchPanel.getTextArea().setText("no results found");
					}
					break;
				case 2:
					university.findprof(e.getQuery());
					break;
				case 3:
					break;
				case 4:
					break;
				}
			}
		});
	}

	private void initStudentPanelListener() {
		newStudentPanel.setStudentPanelListener(new StudentPanelListener() {

			@Override
			public void StudentPanelEventOccurred(StudentPanelEvent ev) {
				String action = ev.getAction();

				if (action.equals("main")) {
					// return to main menu
					revalidate();
					setContentPane(mainMenuPanel);
					mainMenuPanel.setVisible(true);
					revalidate();
				}

				else if (action.equals("submit")) {

				}
				String firstName = ev.getFirstName();
				String lastName = ev.getLastName();
				String email = ev.getEmail();
				String phoneNumber = ev.getPhoneNumber();
				
				// create a student with this data
				university.addstudent(firstName + " " + lastName);
			}
		});
	}

}
