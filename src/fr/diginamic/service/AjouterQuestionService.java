package fr.diginamic.service;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDAO;

public class AjouterQuestionService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) {
		System.out.println("Veuillez saisir l’intitulé de la question :");
		String intitule = scanner.nextLine();
		System.out.println("Veuillez saisir le nombre de propositions : (exemple : 3)");
		int nbReponses = Integer.parseInt(scanner.nextLine());
		
		ArrayList<String> propositions = new ArrayList<String>(nbReponses);
		for (int i=0; i < nbReponses; i++) {
			System.out.println("Veuillez saisir la proposition n°"+(i+1)+" :");
			String rep = scanner.nextLine();
			propositions.add(rep);
		}
		int indexBonneReponse = 1;
		do {
			System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+ nbReponses+") :");
			indexBonneReponse = Integer.parseInt(scanner.nextLine());
		} while (indexBonneReponse < 1 || indexBonneReponse > nbReponses);
		
		Question q = new Question(intitule, nbReponses);
		for (int i=0; i < propositions.size(); i++) {
			q.addProposition(propositions.get(i));
		}
		q.setBonneReponse(propositions.get(indexBonneReponse-1));
		
		dao.save(q);
	}
}
