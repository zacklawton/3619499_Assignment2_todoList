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

import edu.pitt.controller.AddButton;
import edu.pitt.controller.Controller;
import edu.pitt.controller.DeleteButton;
import edu.pitt.model.ListItem;
import edu.pitt.model.Model;

public class View extends JFrame {

	private JFrame parentFrame;
	private JPanel panelRight;
	private JPanel mPanel;
	private JButton deleteButton;
	private TextField itemText;
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
	 * Main Window
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

	private void mainPanel() {
		// Create the Panel
		mPanel = new JPanel();
		mPanel.setBounds(10, 10, 375, 375);
		mPanel.setBorder(BorderFactory.createTitledBorder("Add an item to the list"));

		// Create the text field to enter a list item
		itemText = new TextField("Type Here To Enter An Item ");

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
	 * @return String text
	 */
	public TextField getItemText() {
		return itemText;
	}

	/**
	 * Set the text field to a String input
	 * @param itemText
	 */
	public void setItemText(TextField itemText) {
		this.itemText = itemText;
	}

	/**
	 * Get the saved item from the list
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
	 * setItem Method
	 * add text to the list
	 */
	public void setItem() {
		String item = itemText.getText();
		listModel.addElement(item);
		System.out.println(item);
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void deleteItem() {
		listModel.remove(list1.getSelectedIndex());
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public JList getList1() {
		return list1;
	}

	public void setList1(JList list1) {
		this.list1 = list1;
	}
}
