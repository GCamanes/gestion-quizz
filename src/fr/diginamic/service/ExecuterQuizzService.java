package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDAO;

public class ExecuterQuizzService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) {
				
		System.out.println("\n*** Début du quizz ! Bonne chance ! ***");
		int score = 0;
		for (int i = 0; i < dao.findAll().size(); i++) {
			Question q = dao.findAll().get(i);
			System.out.println("\n" + (i+1) + ") " + q.toString());
			System.out.print("votre réponse :");
			int reponse = Integer.parseInt(scanner.nextLine());
			
			if (q.getPropositions().get(reponse-1).equals(q.getBonneReponse())) {
				score += 1;
			}
		}
		System.out.println("\n*** Fin du quizz ! ***");
		System.out.println("votre score : " + score + " / " + dao.findAll().size());
		
	}

}
