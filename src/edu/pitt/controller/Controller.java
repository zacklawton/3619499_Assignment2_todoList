package edu.pitt.controller;

import java.awt.event.KeyEvent;
import java.util.Vector;

import edu.pitt.model.ListItem;
import edu.pitt.model.Model;
import edu.pitt.view.View;

public class Controller {

	private View view;
	private Model model;
	private AddButton addButton;
	private DeleteButton deleteButton;
	int i = 0;
	Vector<ListItem> list;

	public Controller(View view, Model model) {
		addButton = new AddButton(this);
		deleteButton = new DeleteButton(this);
		this.view = view;
		this.model = model;

		// clear the list in the view
		view.deleteAll();

		// get the list from the model, save each item from the list into the
		// view at startup
		for (ListItem item : model.getList()) {
			ListItem a = model.getList().elementAt(i);
			String add = a.getDescription();
			view.addToList(add);
			i++;
		}

		// Action Listeners
		view.getSaveButton().addActionListener(addButton);
		view.getDeleteButton().addActionListener(deleteButton);

	}

	/**
	 * get the view
	 * 
	 * @return the view
	 */
	public View getView() {
		return this.view;
	}

	/**
	 * get the model
	 * 
	 * @return the model
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * get the button to add an item to the list/database
	 */
	public void getAddButton() {
		this.addButton = addButton;
	}

	/**
	 * get the button to delete an item to the list/database
	 */
	public void getDeleteButton() {
		this.deleteButton = deleteButton;
	}
}
