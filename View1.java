package edu.pitt.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import edu.pitt.controller.AddButton;
import edu.pitt.controller.AddNewUser;
import edu.pitt.controller.Controller;
import edu.pitt.controller.DeleteButton;
import edu.pitt.controller.SaveNewUserButton;

public class View1 extends JFrame {
	// Local Variables
	private JFrame parentFrame;
	private JFrame userFrame;
	private JPanel uPanel;
	private JPanel mPanel;
	private JButton deleteButton;
	private JTextField txtItem;
	private JComboBox<String> cbLogin;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JLabel lblUserLogin = new JLabel("User ID:");
	private JLabel lblItemDesc = new JLabel("Enter an item:");
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblID;
	private JButton btnMainSave = new JButton("Save");
	private JButton btnUserSave;
	private JButton btnOpenUserWindow = new JButton("New User");
	private JList list1 = new JList();
	private DefaultListModel listModel;
	private JTree theTree;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode parent;
	private DefaultMutableTreeNode child;
	private DefaultMutableTreeNode listRoot = new DefaultMutableTreeNode("To Do List");
	private JScrollPane scrollPane;

	Controller controller;
	AddButton save;
	DeleteButton delete;
	AddNewUser addNewUser;
	SaveNewUserButton sNUB;

	/**
	 * View Constructor
	 */
	public View1() {
		// Initialize the main frame of the GUI
		initParentFrame();
	}

	/**
	 * the main frame for the window
	 */
	public void initParentFrame() {
		// FRAME
		parentFrame = new JFrame("To-Do List");
		parentFrame.setBounds(100, 100, 500, 320);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.getContentPane().setLayout(null);

		mainPanel();

		// ADD PANELS TO FRAME //
		parentFrame.add(mPanel);
		parentFrame.setVisible(true);
		parentFrame.setResizable(false);
	}

	/**
	 * the main panel of the To Do List
	 */
	private void mainPanel() {
		// Create the Panel
		mPanel = new JPanel();
		mPanel.setBorder(BorderFactory.createTitledBorder("Add an item to the list"));
		mPanel.setSize(500, 315);
		FlowLayout layout = new FlowLayout();
		mPanel.setLayout(layout);

		// Create the text field to enter a list item
		txtItem = new JTextField(21);
		String[] logins = { "1", "2", "3", "4", "5" };

		cbLogin = new JComboBox<String>(logins);

		// Add the text field and a save button to the panel
		mPanel.add(lblUserLogin);
		mPanel.add(cbLogin);
		// mPanel.add(btnOpenUserWindow);
		mPanel.add(lblItemDesc);
		mPanel.add(txtItem);

		// JTree creation
		// createJTree();

		listRoot = new DefaultMutableTreeNode("To Do List");
		treeModel = new DefaultTreeModel(listRoot);
		// add a tree model listener here!!!!
		theTree = new JTree(treeModel);
		theTree.setEditable(false);
		theTree.setVisibleRowCount(10);
		theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		theTree.setShowsRootHandles(true);

		scrollPane = new JScrollPane(theTree);
		scrollPane.setPreferredSize(new Dimension(250, 200));

		// Create a list model and a list
		// listModel = new DefaultListModel();
		// list1 = new JList(listModel);
		// list1.setVisibleRowCount(15);
		// JScrollPane scrollPane = new JScrollPane(list1);
		// scrollPane.setVisible(true);
		// scrollPane.setBorder(BorderFactory.createTitledBorder("To-Do List"));

		// Creates a delete button
		deleteButton = new JButton("Delete Item");

		// Adds the list model, list, and delete button to the panel
		mPanel.add(scrollPane);
		mPanel.add(deleteButton);
		mPanel.add(btnMainSave);
	}

	/**
	 * secondary window that shows when "Add New User" is clicked on the main
	 * window
	 */
	public void userInfoWindow() {
		// FRAME
		userFrame = new JFrame("User Information");
		userFrame.setBounds(150, 150, 250, 250);

		/**
		 * ADD PANELS TO FRAME
		 */
		uPanel = new JPanel();
		uPanel.setSize(410, 410);
		FlowLayout layout = new FlowLayout();
		uPanel.setLayout(layout);

		/**
		 * create buttons and text boxes
		 */
		lblFirstName = new JLabel("First Name: ");
		lblLastName = new JLabel("Last Name: ");
		lblID = new JLabel("User ID: ");

		txtFirstName = new JTextField(15);
		txtLastName = new JTextField(15);
		this.btnUserSave = new JButton("Save User");

		/**
		 * Add buttons and text boxes
		 */
		uPanel.add(lblFirstName);
		uPanel.add(txtFirstName);

		uPanel.add(lblLastName);
		uPanel.add(txtLastName);

		uPanel.add(lblID);

		uPanel.add(btnUserSave);

		// Add panel to frame
		userFrame.add(uPanel);
		userFrame.setVisible(true);
		userFrame.setResizable(false);

	}

	public JFrame getUserFrame() {
		return userFrame;
	}

	public void setUserFrame(JFrame userFrame) {
		this.userFrame = userFrame;
	}

	public String getTxtFirstName() {
		String firstName = txtFirstName.getText();
		return firstName;
	}

	public String getTxtLastName() {
		String lastName = txtLastName.getText();
		return lastName;
	}

	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JButton getBtnOpenUserWindow() {
		return btnOpenUserWindow;
	}

	public JButton getBtnUserSave() {
		System.out.println("in btnUserSave");
		return btnUserSave;
	}

	public AddNewUser getNewUser() {
		return addNewUser;
	}

	public String getTxtUserLogin() {
		String user = cbLogin.getSelectedItem().toString();
		return user;
	}

	/**
	 * Grabs the string value of the text field
	 * 
	 * @return text the text that is currently in the text field
	 */
	public JTextField getItemText() {
		return txtItem;
	}

	/**
	 * Set the text field to a String input
	 * 
	 * @param itemText
	 */
	public void setItemText(JTextField itemText) {
		this.txtItem = itemText;
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
			return txtItem.getText();
		}

	}

	/**
	 * set the text to be displayed in the list
	 * 
	 * @param userID
	 *            a String of the entered user ID
	 */
	public void setItem(String userID) {
		String item = txtItem.getText();
		listModel.addElement(item);
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
		return btnMainSave;
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

	private void createJTree() {
		listRoot = new DefaultMutableTreeNode("To Do List");
		treeModel = new DefaultTreeModel(listRoot);
		// add a tree model listener here!!!!
		theTree = new JTree(treeModel);
		theTree.setEditable(false);
		theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		theTree.setShowsRootHandles(true);

		scrollPane = new JScrollPane(theTree);
		
	}

	/**
	 * Clear all of the nodes from the tree except for the root node
	 */
	public void clearTree() {
		listRoot.removeAllChildren();
		treeModel.reload();
	}

	/**
	 * get the selected node in the from the JTree
	 * @return r  the selected node as a string
	 */
	public String getSelectedNode() {
		TreePath selected = theTree.getSelectionPath();
		String r = selected.getLastPathComponent().toString();
		return r;
	}

	/**
	 * remove a node from the JTree
	 */
	public void removeSelectedNode() {
		//get the selected node
		TreePath selected = theTree.getSelectionPath();
		
		//if not blank, set currentNode to the selected item and save its parent.
		if (selected != null) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (selected.getLastPathComponent());
			MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			//if the parent is not blank, remove the node
			if (parent != null) {
				treeModel.removeNodeFromParent(currentNode);
				return;
			}
		}
	}

	/**
	 * add a node to the tree
	 * @param child
	 * @return 
	 */
	public DefaultMutableTreeNode addNode(Object child) {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = theTree.getSelectionPath();

		// if the parent path is empty, then parentNode is the root
		if (parentPath == null) {
			parentNode = listRoot;
		} else {
			// otherwise parentNode is the selected node
			parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
		}

		return addNode(parentNode, child, true);
	}

	public DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent, Object child) {
		return addNode(parent, child, false);
	}

	public DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = listRoot;
		}

		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

		if (shouldBeVisible) {
			theTree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}

}
