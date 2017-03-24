package edu.pitt.model;

import java.sql.Timestamp;
import java.util.UUID;

public class ListItem {

	//Local Variables
	private String description;
	private Timestamp timeStamp;
	private String ID;

	public ListItem(String description) {
		this.description = description;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		ID = createUUID();
	}

	public ListItem(String description, String ID) {
		this.description = description;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.ID = ID;
	}

	/**
	 * get the unique ID for the list item
	 * 
	 * @return the unique ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * get the time stamp for when an item was created
	 * 
	 * @return the time stamp for an item
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * gets the description of the list item
	 * 
	 * @return description the String representation of the list item
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * sets the description of the list item
	 * 
	 * @param description
	 *            the String representation of the list item
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String createUUID() {
		UUID id = UUID.randomUUID();
		String returnValue = id.toString();
		return returnValue;
	}

}
