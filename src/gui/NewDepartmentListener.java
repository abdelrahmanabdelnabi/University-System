package gui;

import java.util.EventListener;

public interface NewDepartmentListener extends EventListener {
	public void departmentEventOccurred(NewDepartmentEvent e);
}
