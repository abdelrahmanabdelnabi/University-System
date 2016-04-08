package gui;

import java.util.EventObject;

public class SearchPanelEvent extends EventObject{

	private String query;
	private int type; // search for student or course of prof etc..
	// 1 for student
	// 2 for professor
	// 3 for course
	// 4 for department
	
	public SearchPanelEvent(Object arg0) {
		super(arg0);
	}
	
	public SearchPanelEvent(Object o, String query, int type){
		super(o);
		this.query = query;
		this.type = type;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
