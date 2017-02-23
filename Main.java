package edu.pitt.assignment2;

import edu.pitt.controller.Controller;
import edu.pitt.model.Model;
import edu.pitt.view.View1;

public class Main {

	public static void main(String[] args) {
		View1 frame = new View1();
		Model model = new Model();
		Controller controller = new Controller(frame, model);
	}

}
