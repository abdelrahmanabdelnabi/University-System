package gui.view.enrollpanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollPanel extends JPanel {

	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnCourse;
	private JRadioButton rdbtnInCourse;
	private JRadioButton rdbtnDepartment;
	private JButton btnEnroll;
	private ButtonGroup fromGroup;
	private ButtonGroup toGroup;
	private JButton btnMainMenu;
	private JTextField FromNameField;
	private JTextField toNameField;
	private JLabel lblName;
	private JLabel label;
	
	private EnrollPanelListener listener;
	/**
	 * Create the panel.
	 */
	public EnrollPanel() {

		setBackground(Color.yellow);
		setLayout(null);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				refresh();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblEnroll = new JLabel("Enroll");
		lblEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnroll.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnroll.setBounds(250, 30, 92, 27);
		add(lblEnroll);
		
		rdbtnStudent = new JRadioButton("student");
		rdbtnStudent.setBounds(60, 65, 109, 23);
		rdbtnStudent.setSelected(true);
		add(rdbtnStudent);
		
		rdbtnProfessor = new JRadioButton("professor");
		rdbtnProfessor.setBounds(60, 91, 109, 23);
		add(rdbtnProfessor);
		
		rdbtnCourse = new JRadioButton("course");
		rdbtnCourse.setBounds(60, 117, 109, 23);
		add(rdbtnCourse);
		
		JLabel lblIn = new JLabel("in");
		lblIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIn.setBounds(250, 95, 46, 14);
		add(lblIn);
		
		rdbtnInCourse = new JRadioButton("course");
		rdbtnInCourse.setBounds(391, 78, 109, 23);
		rdbtnInCourse.setSelected(true);
		add(rdbtnInCourse);
		
		rdbtnDepartment = new JRadioButton("department");
		rdbtnDepartment.setBounds(391, 104, 109, 23);
		add(rdbtnDepartment);
		
		fromGroup = new ButtonGroup();
		fromGroup.add(rdbtnStudent);
		fromGroup.add(rdbtnProfessor);
		fromGroup.add(rdbtnCourse);
		
		toGroup = new ButtonGroup();
		toGroup.add(rdbtnInCourse);
		toGroup.add(rdbtnDepartment);
		
		
		
		btnEnroll = new JButton("enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fromName = FromNameField.getText();
				String toName = toNameField.getText();
				int fromType = getFromType();
				int toType = getToType();
				
				EnrollPanelEvent ev = new EnrollPanelEvent(this, "enroll");
				ev.setFromName(fromName);
				ev.setFromType(fromType);
				ev.setToName(toName);
				ev.setToType(toType);
				
				if(listener != null){
					listener.EnrollPanelEventOccurred(ev);
				}
			}
		});
		btnEnroll.setBounds(232, 234, 89, 23);
		add(btnEnroll);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollPanelEvent ev = new EnrollPanelEvent(this, "main");
				
				if(listener != null){
					listener.EnrollPanelEventOccurred(ev);
				}
			}
		});
		btnMainMenu.setBounds(409, 294, 134, 23);
		add(btnMainMenu);
		
		FromNameField = new JTextField();
		FromNameField.setBounds(116, 169, 151, 20);
		add(FromNameField);
		FromNameField.setColumns(10);
		
		toNameField = new JTextField();
		toNameField.setColumns(10);
		toNameField.setBounds(391, 169, 168, 20);
		add(toNameField);
		
		lblName = new JLabel("Name");
		lblName.setBounds(60, 172, 46, 14);
		add(lblName);
		
		label = new JLabel("Name");
		label.setBounds(332, 172, 46, 14);
		add(label);
		
	}
	
	private void refresh(){
		if(rdbtnCourse.isSelected()){
			rdbtnInCourse.setSelected(false);
			rdbtnInCourse.setEnabled(false);
			rdbtnDepartment.setEnabled(true);
			rdbtnDepartment.setSelected(false);
		}
		else if(rdbtnProfessor.isSelected()){
			rdbtnDepartment.setSelected(false);
			rdbtnDepartment.setEnabled(false);
			rdbtnInCourse.setEnabled(true);
			rdbtnInCourse.setSelected(false);
		}
	}
	
	public void setEnrollPanelListener(EnrollPanelListener listener){
		this.listener = listener;
	}
	
	private int getFromType(){
		if(rdbtnStudent.isSelected())
			return 1;
		else if(rdbtnProfessor.isSelected())
			return 2;
		else if(rdbtnCourse.isSelected())
			return 3;
		return 0;
	}
	
	private int getToType(){
		if(rdbtnInCourse.isSelected())
			return 1;
		else if(rdbtnDepartment.isSelected())
			return 2;
		return 0;
	}
}
