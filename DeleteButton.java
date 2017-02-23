package edu.pitt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButton implements ActionListener {

	private Controller controller;

	public DeleteButton(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// get selected item from the list in the view
		//String selectedItem = controller.getView().getList1().getSelectedValue().toString();

		String selectedItem = controller.getView1().getSelectedNode();
		
		// Delete the item from the list in the view
		//controller.getView().deleteItem();
		
		controller.getView1().removeSelectedNode();

		// delete that item from the Vector in the model
		controller.getModel().deleteListItem(selectedItem);
		System.out.println("Delete Action Performed ");

	}

}
