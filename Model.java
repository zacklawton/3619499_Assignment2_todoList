package edu.pitt.model;

import java.util.Vector;

public class Model {

	private Vector<ListItem> todoList;
	ListItem a;

	public Model() {
		todoList = new Vector<ListItem>();
	}

	/**
	 * Adds an item to the ListItem Vector
	 * 
	 * @param item
	 */
	public void addListItem(String item) {
		a = new ListItem(item);
		todoList.add(a);
	}

	/**
	 * Deletes an item from the ListItem Vector
	 * 
	 * @param item
	 */
	public void deleteListItem(String item) {

		for (int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).getDescription().equals(item)) {
				todoList.remove(todoList.get(i));
				System.out.println("Item Deleted");
			} else {
				System.out.println("Could not find item to delete");
			}
		}
	}

	public Vector<ListItem> getList() {
		return this.todoList;

	}
}
