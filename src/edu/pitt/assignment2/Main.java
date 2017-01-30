package edu.pitt.assignment2;

import edu.pitt.controller.Controller;
import edu.pitt.model.Model;
import edu.pitt.view.View;

public class Main {

	public static void main(String[] args) {
		View frame = new View();
		Model model = new Model();
		Controller controller = new Controller(frame, model);
	}

}
