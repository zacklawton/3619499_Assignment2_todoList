package edu.pitt.controller;

import java.sql.Timestamp;

public class User {

	// Local Variables
	private String firstName;
	private String lastName;
	private String ID;

	public User() {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}
	
	public User(String firstName, String lastName, String ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}
	
	

	/**
	 * get the first name value for the user
	 * 
	 * @return first name of user as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set the first name value for the user
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get the last name value for the user
	 * 
	 * @return last name of user as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set the first name value for the user
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get the ID value for the user
	 * 
	 * @return ID value as a String
	 */
	public String getID() {
		return ID;
	}

	/**
	 * set the ID value for the user
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}

}
