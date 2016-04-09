package gui.view.enrollpanel;

import java.util.EventObject;

public class EnrollPanelEvent extends EventObject{

	private String action;
	private String fromName;
	private String toName;
	private int fromType;
	private int toType;
	
	public EnrollPanelEvent(Object arg0) {
		super(arg0);
	}
	
	public EnrollPanelEvent(Object arg0, String action) {
		super(arg0);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public int getFromType() {
		return fromType;
	}

	public void setFromType(int fromType) {
		this.fromType = fromType;
	}

	public int getToType() {
		return toType;
	}

	public void setToType(int toType) {
		this.toType = toType;
	}


}
