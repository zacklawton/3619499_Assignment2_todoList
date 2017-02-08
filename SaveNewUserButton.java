package edu.pitt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveNewUserButton implements ActionListener {

	private Controller controller;
	private User newUser;

	public SaveNewUserButton(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		System.out.println("Button Pressed to save a new user!");
		
		//grab first, last, and ID from view
		String fName = controller.getView().getTxtFirstName();
		String lName = controller.getView().getTxtLastName();
		String userID = controller.getView().getTxtUserLogin();
		
		//create a User object, save the first, last, and ID into that user
		newUser = new User(fName, lName, userID);
		
		//add the newUser to the model
		controller.getModel().addUsers(newUser);
		
		//Close the window upon save
		controller.getView().getUserFrame().setVisible(false);
		
	}
}
