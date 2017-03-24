package edu.pitt.view;

import java.awt.List;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.pitt.controller.AddButton;
import edu.pitt.controller.Controller;
import edu.pitt.controller.DeleteButton;
import edu.pitt.model.ListItem;
import edu.pitt.model.Model;

public class View extends JFrame {
	// Local Variables
	private JFrame parentFrame;
	private JPanel panelRight;
	private JPanel mPanel;
	private JButton deleteButton;
	private JTextField itemText;
	private JButton saveButton = new JButton("Save");
	private JList list1 = new JList();
	private DefaultListModel listModel;

	Controller controller;
	AddButton save;
	DeleteButton delete;

	/**
	 * View Constructor
	 */
	public View() {
		// Initialize the main frame of the GUI
		initParentFrame();
	}

	/**
	 * the main frame for the window
	 */
	private void initParentFrame() {
		// FRAME
		parentFrame = new JFrame("To-Do List");
		parentFrame.setBounds(100, 100, 400, 420);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.getContentPane().setLayout(null);

		mainPanel();

		// ADD PANELS TO FRAME //
		parentFrame.add(mPanel);
		parentFrame.setVisible(true);
		parentFrame.setResizable(false);
		;
	}

	/**
	 * the main panel of the To Do List, this is where everything is held
	 */
	private void mainPanel() {
		// Create the Panel
		mPanel = new JPanel();
		mPanel.setBounds(10, 10, 375, 375);
		mPanel.setBorder(BorderFactory.createTitledBorder("Add an item to the list"));

		// Create the text field to enter a list item
		itemText = new JTextField(15);

		// Add the text field and a save button to the panel
		mPanel.add(itemText);
		mPanel.add(saveButton);

		// Create a list model and a list
		listModel = new DefaultListModel();
		list1 = new JList(listModel);
		list1.setVisibleRowCount(15);
		JScrollPane scrollPane = new JScrollPane(list1);
		scrollPane.setVisible(true);
		scrollPane.setBorder(BorderFactory.createTitledBorder("To-Do List"));

		// Creates a delete button
		deleteButton = new JButton("Delete Item From List");
		deleteButton.setBounds(list1.getX(), list1.getY() + 50, 75, 25);

		// Adds the list model, list, and delete button to the panel
		mPanel.add(scrollPane);
		mPanel.add(deleteButton);

	}

	/**
	 * Grabs the string value of the text field
	 * 
	 * @return text the text that is currently in the text field
	 */
	public JTextField getItemText() {
		return itemText;
	}

	/**
	 * Set the text field to a String input
	 * 
	 * @param itemText
	 */
	public void setItemText(JTextField itemText) {
		this.itemText = itemText;
	}

	/**
	 * Get the saved item from the list
	 * 
	 * @return String item
	 */
	public String getItem() {

		if (list1.getSelectedValue() != null) {
			return list1.getSelectedValue().toString();
		} else {
			return itemText.getText();
		}

	}

	/**
	 * add text to the list
	 */
	public void setItem() {
		String item = itemText.getText();
		listModel.addElement(item);
		System.out.println(item);
	}

	/**
	 * add an item to the list model(the visible list)
	 * 
	 * @param itemToAdd
	 *            a String of what needs to be added to the list
	 */
	public void addToList(String itemToAdd) {
		listModel.addElement(itemToAdd);
	}

	/**
	 * clear the list
	 */
	public void deleteAll() {
		listModel.clear();
	}

	/**
	 * get the save button
	 * 
	 * @return the save button
	 */
	public JButton getSaveButton() {
		return saveButton;
	}

	/**
	 * get the delete button
	 * 
	 * @return the delete button
	 */
	public JButton getDeleteButton() {
		return deleteButton;
	}

	/**
	 * delete an item from the list model (the visible list)
	 */
	public void deleteItem() {
		listModel.remove(list1.getSelectedIndex());
	}

	/**
	 * get the list model for the view
	 * 
	 * @return the list model for the view
	 */
	public DefaultListModel getListModel() {
		return listModel;
	}

	/**
	 * get the JList from the view
	 * 
	 * @return the JList list1
	 */
	public JList getList1() {
		return list1;
	}

}
