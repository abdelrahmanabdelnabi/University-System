package gui;

import java.util.EventObject;

/*
 * This class is used whenever the new department panel wants to send data
 * to the main frame.
 * 
 * This event class should contain all the information/data that will be sent to the
 * listeners
 * 
 * It can be used to ask the main frame to create a new department
 */
public class NewDepartmentEvent extends EventObject {

	private String action;

	private String departmentName;
	
	public NewDepartmentEvent(Object source) {
		super(source);
	}
	
	public NewDepartmentEvent(Object source, String action, String dpt) {
		super(source);
		this.departmentName = dpt;
		this.action = action;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
}
