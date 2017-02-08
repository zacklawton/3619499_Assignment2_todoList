package edu.pitt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewUser implements ActionListener {

	private Controller controller;

	public AddNewUser(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 controller.getView().userInfoWindow();
		 controller.getView().getBtnUserSave().addActionListener(controller.getSaveUser());
	}
}
