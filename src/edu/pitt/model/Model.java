package edu.pitt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

import edu.pitt.controller.Controller;

public class Model {

	private Vector<ListItem> todoList;
	private String description = "";
	private String UUID = "";
	private ListItem listItem;
	private Connection con;
	private Statement statement;

	public Model() {
		// create a list
		todoList = new Vector<ListItem>();

		//get the driver and a connection to the database
		dbDriver();
		getConnection();
	}

	/**
	 * Adds an item to the ListItem Vector and Database
	 * 
	 * @param item	The String to be added to the list
	 */
	public void addListItem(String item) {

		listItem = new ListItem(item);
		//add to model
		todoList.add(listItem);
		// add to database
		addToDatabase(item);
	}

	/**
	 * Add a string item to the MySQL database
	 * 
	 * @param item	The String to be added to the database
	 */
	public void addToDatabase(String item) {

		// Insert statement for the database
		String sql = "INSERT INTO ToDoList (description, tstamp, UUID) ";
		sql = sql + "VALUES ";
		sql = sql + "('" + listItem.getDescription();
		sql = sql + "', '" + listItem.getTimeStamp();
		sql = sql + "', '" + listItem.getID() + "');";
		System.out.println(sql);

		// execute the update to the database
		try {
			Statement statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an item from the model list and the database
	 * 
	 * @param description	The String that will be deleted from the list and the database
	 */
	public void deleteListItem(String description) {
		// create a place to store the items that need to be deleted
		Vector<ListItem> itemsToDelete = new Vector<ListItem>();

		// for each item in the list that matches the String input, add it to
		// the items to delete
		for (ListItem item : todoList) {
			if (item.getDescription().equals(description)) {
				itemsToDelete.add(item);
				System.out.println(item.getID());
			}
		}
		for (ListItem item : itemsToDelete) {
			// remove item from the model
			todoList.remove(item);

			// remove item from the database
			String sql = "DELETE FROM ToDoList ";
			sql = sql + "WHERE UUID = " + "'" + item.getID() + "';";
			System.out.println(sql);
			try {
				Statement statement = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * This method allows a connection to be made to the MySQL database
	 */
	public void getConnection() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu:3306/zbl2is1017", "zbl2is1017",
					"zbl2@pitt.edu");
			String query = "USE zbl2is1017";
			query = "SELECT * FROM ToDoList";

			// Execute query to database
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				// save each list item into output
				description = rs.getString("description");
				UUID = rs.getString("UUID");

				// turn output into a ListItem
				listItem = new ListItem(description, UUID);

				// add the listItem to the todoList
				todoList.addElement(listItem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method calls the mySQL driver
	 */
	public void dbDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve the list
	 * @return	The list from the model
	 */
	public Vector<ListItem> getList() {
		return this.todoList;
	}

}
