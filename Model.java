package edu.pitt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import edu.pitt.controller.Controller;
import edu.pitt.controller.User;

public class Model {

	private Vector<ListItem> todoList;
	private Vector<User> userSave;
	private Vector<User> userLoad;
	private String description = "";
	private String itemID = "";
	private ListItem listItem;
	private User user;
	private Connection con;
	private Statement statement;
	int i;

	public Model() {
		// create a list
		todoList = new Vector<ListItem>();
		userSave = new Vector<User>();

		// get the driver and a connection to the database
		dbDriver();
		getConnection();
		loadUsers();
	}

	/**
	 * Adds an item to the ListItem Vector and Database
	 * 
	 * @param item
	 *            The String to be added to the list
	 */
	public void addListItem(String item) {
		listItem = new ListItem(item);
		// add to model
		todoList.add(listItem);
		// add to database
		addItemToDatabase(item);

	}

	public void addUsers(User user) {
		// load current users from the database
		userLoad = loadUsers();

		// if the user ID entered already exists, ask for a new entry
		for (int i = 0; i < userLoad.size(); i++) {
			if (userLoad.elementAt(i).getID().equals(user.getID())) {
				JOptionPane.showMessageDialog(null, "No bueno, try a different user id");
				break;
			}
		}

		// add user to the users vector
		userSave.add(user);

		String sql = "INSERT INTO Users (user_id, first_name, last_name) ";
		sql = sql + "VALUES ";
		sql = sql + "('" + user.getID();
		sql = sql + "', '" + user.getFirstName();
		sql = sql + "', '" + user.getLastName() + "');";
		System.out.println(sql);

		// execute the update to the database
		try {
			Statement statement = con.createStatement();

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load all of the users from the database
	 * 
	 * @return a Vector<User> containing all of the users from the database
	 */
	public Vector<User> loadUsers() {

		userLoad = new Vector<User>();

		String query = "SELECT * FROM Users";

		// Select all users from the database
		try {
			statement = con.createStatement();
			ResultSet rs;
			rs = statement.executeQuery(query);
			while (rs.next()) {
				// save each list item into output
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String userID = rs.getString("user_id");

				// turn output into a User
				user = new User(fName, lName, userID);

				// add the user to the vector of users
				userLoad.addElement(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userLoad;
	}

	/**
	 * Add a string item to the MySQL database
	 * 
	 * @param item
	 *            The String to be added to the database
	 */
	public void addItemToDatabase(String item) {

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
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an item from the model list and the database
	 * 
	 * @param description
	 *            The String that will be deleted from the list and the database
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
		} // end of for

		for (ListItem item : itemsToDelete) {
			// remove item from the model
			todoList.remove(item);

			// remove item from ToDoList
			String sql = "DELETE FROM ToDoList ";
			sql = sql + "WHERE UUID = " + "'" + item.getID() + "'; ";
			System.out.println(sql);
			//remove item from user_list
			String sql1 = "DELETE FROM user_list ";
			sql1 = sql1 + "WHERE list_id = " + "'" + item.getID() + "'; ";
			System.out.println(sql1);

			try {
				Statement statement = con.createStatement();
				statement.executeUpdate(sql);
				statement.executeUpdate(sql1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of for loop
	}

	/**
	 * Add to the user_list table in the database
	 * 
	 * @param user
	 *            the user id from the view
	 */
	public void addUserItem(String user) {

		//query to add a user to the database
		String sql = "INSERT INTO user_list (user_id, list_id)";
		sql = sql + "VALUES ";
		sql = sql + "('" + user + "'";
		sql = sql + ", '" + getListItem().getID() + "');";
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
				itemID = rs.getString("UUID");

				// turn output into a ListItem
				listItem = new ListItem(description, itemID);

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
	 * 
	 * @return The list from the model
	 */
	public Vector<ListItem> getList() {
		return this.todoList;
	}

	public HashMap<String, String> getUsersLists() {
		HashMap<String, String> usersLists = new HashMap<String, String>();

		try {
			con = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu:3306/zbl2is1017", "zbl2is1017",
					"zbl2@pitt.edu");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "USE zbl2is1017";
		query = "SELECT * FROM user_list";

		// Select all users from the database
		try {
			statement = con.createStatement();
			ResultSet rs;
			rs = statement.executeQuery(query);
			while (rs.next()) {
				// save each list item into output
				String userID = rs.getString("user_id");
				String listID = rs.getString("list_id");

				// turn output into a User
				usersLists.put(listID, userID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersLists;
	}

	public ListItem getListItem() {
		return listItem;
	}

	public void setListItem(ListItem listItem) {
		this.listItem = listItem;
	}

}
