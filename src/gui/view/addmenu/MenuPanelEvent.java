package gui.view.addmenu;

import java.util.EventObject;

public class MenuPanelEvent extends EventObject {

	private String action;

	public MenuPanelEvent(Object source) {
		super(source);
	}

	public MenuPanelEvent(Object source, String action) {
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
