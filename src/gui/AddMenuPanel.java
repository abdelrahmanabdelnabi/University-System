package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMenuPanel extends JPanel {

	private MenuPanelListener menuPanelListener;

	/**
	 * Create the panel.
	 */

	public AddMenuPanel() {
		setLayout(null);

		JButton StdBtn = new JButton("New Student");
		StdBtn.setBounds(160, 60, 130, 23);
		add(StdBtn);
		StdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanelEvent ev = new MenuPanelEvent(this, "student");

				if (menuPanelListener != null) {
					menuPanelListener.menuEventOccurred(ev);
				}
			}
		});

		JButton ProfBtn = new JButton("New Professor");
		ProfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanelEvent ev = new MenuPanelEvent(this, "professor");

				if (menuPanelListener != null) {
					menuPanelListener.menuEventOccurred(ev);
				}
			}
		});
		ProfBtn.setBounds(160, 110, 130, 23);
		add(ProfBtn);

		JButton DptBtn = new JButton("New Department");
		DptBtn.setBounds(160, 160, 130, 23);
		add(DptBtn);
		DptBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPanelEvent ev = new MenuPanelEvent(this, "department");

				if (menuPanelListener != null) {
					menuPanelListener.menuEventOccurred(ev);
				}
			}
		});

		JButton CourseBtn = new JButton("New Course");
		CourseBtn.setBounds(160, 210, 130, 23);
		add(CourseBtn);

	}

	public void setMenuPanelListener(MenuPanelListener listener) {
		this.menuPanelListener = listener;
	}
}
