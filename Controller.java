package edu.pitt.controller;

import edu.pitt.model.Model;
import edu.pitt.view.View;

public class Controller {

	private View view;
	private Model model;
	private AddButton addButton;
	private DeleteButton deleteButton;

	public Controller(View view, Model model) {
		addButton = new AddButton(this);
		deleteButton = new DeleteButton(this);
		
		
		//Action Listeners for Model and View
		view.getSaveButton().addActionListener(addButton);
		view.getDeleteButton().addActionListener(deleteButton);
		
		this.view = view;
		this.model = model;

	}

	public View getView() {
		return this.view;
	}

	public Model getModel() {
		return this.model;
	}

	public void getAddButton() {
		this.addButton = addButton;
	}

	public void getDeleteButton() {
		this.deleteButton = deleteButton;
	}

}
