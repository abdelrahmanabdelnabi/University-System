package gui.view.newstudent;

import java.util.EventObject;

public class StudentPanelEvent extends EventObject{
	
	
	// TODO add the remaining attributes
	private String action;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private int age;
	
	public StudentPanelEvent(Object arg0) {
		super(arg0);
	}
	
	public StudentPanelEvent(Object o, String action) {
		super(o);
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
