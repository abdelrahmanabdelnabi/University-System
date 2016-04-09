package gui.view.mainmenu;

import java.util.EventObject;

public class MainMenuEvent extends EventObject {

	private String action;
	
	public MainMenuEvent(Object source) {
		super(source);
	}
	
	public MainMenuEvent(Object source, String action) {
		super(source);
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	

}
