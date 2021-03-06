package gui.controller;

import gui.view.addmenu.AddMenuPanel;
import gui.view.addmenu.MenuPanelEvent;
import gui.view.addmenu.MenuPanelListener;
import gui.view.enrollpanel.EnrollPanel;
import gui.view.enrollpanel.EnrollPanelEvent;
import gui.view.enrollpanel.EnrollPanelListener;
import gui.view.mainmenu.MainMenu;
import gui.view.mainmenu.MainMenuEvent;
import gui.view.mainmenu.MainMenuListener;
import gui.view.newcourse.CoursePanelListener;
import gui.view.newcourse.NewCourseEvent;
import gui.view.newcourse.NewCoursePanel;
import gui.view.newdepartment.NewDepartmentEvent;
import gui.view.newdepartment.NewDepartmentListener;
import gui.view.newdepartment.NewDepartmentPanel;
import gui.view.newprof.NewProfEvent;
import gui.view.newprof.NewProfListener;
import gui.view.newprof.NewProfPanel;
import gui.view.newstudent.NewStudentPanel;
import gui.view.newstudent.StudentPanelEvent;
import gui.view.newstudent.StudentPanelListener;
import gui.view.searchpanel.SearchPanel;
import gui.view.searchpanel.SearchPanelEvent;
import gui.view.searchpanel.SearchPanelListener;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import system.Course;
import system.Departement;
import system.Professor;
import system.Student;
import system.University;

public class Frame extends JFrame {

	private AddMenuPanel addMenuPane;
	private NewStudentPanel newStudentPanel;
	private NewDepartmentPanel dptPanel;
	private MainMenu mainMenuPanel;
	private NewProfPanel newProfPanel;
	private SearchPanel searchPanel;
	private NewCoursePanel newCoursePanel;
	private EnrollPanel enrollPanel;

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
		newCoursePanel = new NewCoursePanel();
		enrollPanel = new EnrollPanel();

		// initialize the panels' listeners
		initMainMenuListener();
		initAddMenuListener();
		initNewDptListener();
		initNewProfListener();
		initSearchPanelListener();
		initStudentPanelListener();
		initNewCoursePanelListener();
		initEnrollPanelListener();

		// make a list of course names
		// List<Course> courses = university.getCourse();
		List<String> courseName = new ArrayList<String>();
		// for(Course c : courses){
		// courseName.add(c.getName());
		// }

		// pass the list of course names to the new student, professor and
		// department panels
		newStudentPanel.setCourses(courseName);
		newProfPanel.setCourses(courseName);
		dptPanel.setCourses(courseName);

		// add the main menu panel to the window
		add(mainMenuPanel);

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
				} else if (action.equals("enroll")) {
					revalidate();
					setContentPane(enrollPanel);
					enrollPanel.setVisible(true);
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
				} else if (action.equals("course")) {
					setContentPane(newCoursePanel);
					newCoursePanel.setVisible(true);
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
					String name = e.getDepartmentName();
					university.adddep(name);
				}else if(action.equals("main")){
					returnToMainMenu();
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

				String action = e.getAction();
				if(action.equals("main")){
					returnToMainMenu();
				}
				else{
					university.addprof(e.getFirstName() + " " + e.getLastName());					
				}
			}
		});
	}

	private void initSearchPanelListener() {
		searchPanel.setSearchPanelListener(new SearchPanelListener() {

			@Override
			public void SearchEventOccurred(SearchPanelEvent e) {
				String action = e.getAction();
				int type = e.getType();

				if (action.equals("main")) {
					returnToMainMenu();
				} else if (action.equals("search")) {
					switch (type) {
					case 1:
						if (university.findstudent(e.getQuery()) != null) {
							Student std = university.findstudent(e.getQuery());
							String result = std.getName() + ", "
									+ std.getAddress() + ", " + std.getAge();
							searchPanel.getTextArea().setText(result);
						} else {
							searchPanel.getTextArea().setText(
									"no results found");
						}
						break;
					case 2:
						if (university.findprof(e.getQuery()) != null) {
							Professor prof = university.findprof(e.getQuery());
							String result = prof.getName() + ", "
									+ prof.getAddress() + ", " + prof.getAge();
							searchPanel.getTextArea().setText(result);
						} else {
							searchPanel.getTextArea().setText(
									"no results found");
						}
						break;
					case 3:
						if (university.findcourse(e.getQuery()) != null) {
							Course course = university.findcourse(e.getQuery());
							// String result = course.getName() + ", " +
							// course.getId();
							// searchPanel.getTextArea().setText(result);
						} else {
							searchPanel.getTextArea().setText(
									"no results found");
						}
						break;
					case 4:
						if (university.finddep(e.getQuery()) != null) {
							Departement dpt = university.finddep(e.getQuery());
							// String result = dpt.getName() + ", " +
							// dpt.getId();
							// searchPanel.getTextArea().setText(result);
						} else {
							searchPanel.getTextArea().setText(
									"no results found");
						}

						break;
					}
				} else if (action.equals("delete")) {
					String query = e.getQuery();
					switch (type) {
					case 1:
						if (university.delstudent(query) != true) {
							JOptionPane.showMessageDialog(getParent(),
									"student not found", "Deletion Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							searchPanel.getTextArea().setText(
									"student successfully deleted");
						}
						break;
					case 2:
						if (university.delprof(query) != true) {
							JOptionPane.showMessageDialog(getParent(),
									"professor not found", "Deletion Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							searchPanel.getTextArea().setText(
									"professor successfully deleted");
						}
						break;
					case 3:
						if (university.delcourse(query) != true) {
							JOptionPane.showMessageDialog(getParent(),
									"course not found", "Deletion Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							searchPanel.getTextArea().setText(
									"course successfully deleted");
						}
						break;
					case 4:
						if (university.deldep(query) != true) {
							JOptionPane.showMessageDialog(getParent(),
									"department not found", "Deletion Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							searchPanel.getTextArea().setText(
									"department successfully deleted");
						}

						break;
					}

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
					returnToMainMenu();
				}

				else if (action.equals("submit")) {

				}
				String firstName = ev.getFirstName();
				String lastName = ev.getLastName();
				String email = ev.getEmail();
				String phoneNumber = ev.getPhoneNumber();
				String address = ev.getAddress();
				int age = ev.getAge();

				// create a student with this data
				university.addstudent(firstName + " " + lastName);
				Student std = university
						.findstudent(firstName + " " + lastName);
				std.setAddress(address);
				std.setAge(age);
			}
		});
	}

	private void initNewCoursePanelListener() {
		newCoursePanel.setNewCoursePanelListener(new CoursePanelListener() {

			@Override
			public void CourseEventOccurred(NewCourseEvent e) {

				String action = e.getAction();

				if (action.equals("main")) {
					// return to main menu panel
					returnToMainMenu();
				} else if (action.equals("submit")) {
					String name = e.getName();
					int creditHours = e.getCreditHours();

					university.addcourse(name);
				}
			}
		});
	}

	private void initEnrollPanelListener() {
		enrollPanel.setEnrollPanelListener(new EnrollPanelListener() {

			@Override
			public void EnrollPanelEventOccurred(EnrollPanelEvent e) {
				String action = e.getAction();
				if (action.equals("main")) {
					returnToMainMenu();
				} else if (action.equals("enroll")) {
					String fromName = e.getFromName();
					String toName = e.getToName();

					int fromType = e.getFromType();
					int toType = e.getToType();

					Student fromS;
					Course fromC;
					Professor fromP;

					Course toC;
					Departement toD;

					if (fromType == 1) {
						fromS = university.findstudent(fromName);
						if (fromS == null) {
							JOptionPane.showMessageDialog(getParent(),
									"student not found", "Enroll Error",
									JOptionPane.WARNING_MESSAGE);
						}
						if (toType == 1) {
							toC = university.findcourse(toName);
							if (toC == null) {
								JOptionPane.showMessageDialog(getParent(),
										"Course not found", "Enroll Error",
										JOptionPane.WARNING_MESSAGE);
							} else {
								// enroll the student in the course
							}
						} else if (toType == 2) {
							toD = university.finddep(toName);
							if (toD == null) {
								JOptionPane.showMessageDialog(getParent(),
										"Course not found", "Enroll Error",
										JOptionPane.WARNING_MESSAGE);
							} else {
								// enroll student in department
							}
						}
					} else if (fromType == 2) {
						fromP = university.findprof(fromName);
						if (fromP == null) {
							JOptionPane.showMessageDialog(getParent(),
									"professor not found", "Enroll Error",
									JOptionPane.WARNING_MESSAGE);
						}
						toC = university.findcourse(toName);
						if (toC == null) {
							JOptionPane.showMessageDialog(getParent(),
									"course not found", "Enroll Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							// enroll professor in course
						}
					} else if (fromType == 3) {
						fromC = university.findcourse(fromName);
						if (fromC == null) {
							JOptionPane.showMessageDialog(getParent(),
									"course not found", "Enroll Error",
									JOptionPane.WARNING_MESSAGE);
						} else {
							toD = university.finddep(toName);
							if (toD == null) {
								JOptionPane.showMessageDialog(getParent(),
										"course not found", "Enroll Error",
										JOptionPane.WARNING_MESSAGE);
							} else {
								// enroll course in department
							}
						}
					}
				}
			}
		});
	}

	private void returnToMainMenu() {
		revalidate();
		setContentPane(mainMenuPanel);
		mainMenuPanel.setVisible(true);
		revalidate();
	}

}
