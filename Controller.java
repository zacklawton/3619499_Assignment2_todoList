package edu.pitt.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;

import edu.pitt.model.ListItem;
import edu.pitt.model.Model;
import edu.pitt.view.View;

public class Controller {

	private View view;
	private Model model;
	private AddButton addButton;
	private DeleteButton deleteButton;
	private AddNewUser addNewUser;

	private SaveNewUserButton saveUser;
	private ListItem a;
	private int i = 0;
	private String listID;
	private String desc;

	private Enumeration<String> strEnum;
	private String userID;

	public Controller(View view, Model model) {

		this.view = view;
		this.model = model;

		addButton = new AddButton(this);
		deleteButton = new DeleteButton(this);
		addNewUser = new AddNewUser(this);
		saveUser = new SaveNewUserButton(this);

		// clear the list in the view
		view.deleteAll();

		// load list items when view is started
		startupList();

		// Action Listeners
		view.getSaveButton().addActionListener(addButton);
		view.getDeleteButton().addActionListener(deleteButton);
		view.getBtnOpenUserWindow().addActionListener(addNewUser);

	}

	/**
	 * run through the map containing the user/list join info, concatenate the
	 * list item with user id
	 */
	public void startupList() {

		strEnum = Collections.enumeration(model.getUsersLists().keySet());
		while (strEnum.hasMoreElements()) {
			listID = strEnum.nextElement();

			for (ListItem item : model.getList()) {
				a = model.getList().elementAt(i);
				i++;
				if (listID.equals(a.getID())) {
					userID = model.getUsersLists().get(listID);
					desc = a.getDescription();
					break;
				}
			}
			String add = desc;
			System.out.println(desc + " [ID: " + userID + "]");
			view.addToList(add);
			i = 0;
		}
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

	public SaveNewUserButton getSaveUser() {
		return saveUser;
	}

	public void setSaveUser(SaveNewUserButton saveUser) {
		this.saveUser = saveUser;
	}
}
