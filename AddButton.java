package edu.pitt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.view.View;

public class AddButton implements ActionListener {

	private Controller controller;
	private String userID;
	private String item;

	public AddButton(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Get item from the text field in the view
		item = controller.getView1().getItem();
		// get user ID
		userID = controller.getView1().getTxtUserLogin();

		// add that item to the model and the database
		controller.getModel().addListItem(item);
		
		//add user to model
		controller.getModel().addUserItem(userID);

		// add item as a node to the tree
		controller.getView1().addNode((Object) item);
		
		//controller.getView().setItem(userID);

		// create blank space in the text field
		controller.getView1().getItemText().setText("");

	}
}
