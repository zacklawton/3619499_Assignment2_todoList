package edu.pitt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.pitt.view.View;

public class AddButton implements ActionListener {

	private Controller controller;

	public AddButton(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Get item from the text field in the view
		String item = controller.getView().getItem();

		// add that item to the model and the database
		controller.getModel().addListItem(item);

		// add item to the list in the view
		controller.getView().setItem();

		// create blank space in the text field
		controller.getView().getItemText().setText("");

	}
}
