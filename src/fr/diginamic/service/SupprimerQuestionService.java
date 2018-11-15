package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.*;

public class SupprimerQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) {
		int indexQuestion = 0;
		do {
			System.out.println("Veuillez saisir le numéro de la question à supprimer (entre 1 et "+ dao.findAll().size()+") :");
			indexQuestion = Integer.parseInt(scanner.nextLine());
		} while (!((QuestionMemDAO) dao).checkIndex(indexQuestion-1));
		
		dao.delete(indexQuestion-1);
		System.out.println("Question supprimée !");
	}
}
