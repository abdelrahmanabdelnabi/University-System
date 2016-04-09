package gui.view.newcourse;

import java.util.EventObject;

public class NewCourseEvent extends EventObject {

	private String action;
	private String name;
	private int creditHours;
	
	public NewCourseEvent(Object arg0) {
		super(arg0);
	}
	
	public NewCourseEvent(Object arg0, String action) {
		super(arg0);
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
}
