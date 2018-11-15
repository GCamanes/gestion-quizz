package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.QuestionDAO;

public class ListerQuestionsService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) {
		System.out.println("\n*** Liste des questions : ***");
		for (int i = 0; i < dao.findAll().size(); i++) {
			System.out.println((i+1) + ") "+ dao.findAll().get(i).toString());
		}
	}
}
