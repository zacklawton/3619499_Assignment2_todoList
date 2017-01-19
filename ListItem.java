package edu.pitt.model;

public class ListItem {

	private String description;

	public ListItem(String description) {
		this.description = description;
	}

	/**
	 * getDescription Method
	 * gets the description of the list item
	 * @return String description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * setDescription Method
	 * sets the description of the list item
	 * @param String description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
