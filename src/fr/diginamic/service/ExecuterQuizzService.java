package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.QuizzException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDAO;
import fr.diginamic.model.QuestionMemDAO;

public class ExecuterQuizzService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) throws QuizzException {
				
		System.out.println("\n*** Début du quizz ! Bonne chance ! ***");
		int score = 0;
		for (int i = 0; i < dao.findAll().size(); i++) {
			Question q = dao.findAll().get(i);
			System.out.println("\n" + (i+1) + ") " + q.toString());
			
			int reponse = 0;
			try {
				do {
					System.out.println("Veuillez saisir votre réponse (entre 1 et "+ q.getPropositions().size() + ") :");
					reponse = Integer.parseInt(scanner.nextLine());
				} while (reponse < 1 || reponse > q.getPropositions().size());
			} catch (NumberFormatException e) {
				throw new QuizzException(" /!\\ Il faut entrer un nombre (ici entre 1 et "+ q.getPropositions().size()+") pour répondre aux questions");
			}

			if (q.getPropositions().get(reponse-1).equals(q.getBonneReponse())) {
				score += q.getType().getScore();
			}
		}
		System.out.println("\n*** Fin du quizz ! ***");
		System.out.println("votre score : " + score + " / " + ((QuestionMemDAO) dao).getScoreMax());
		
	}

}
