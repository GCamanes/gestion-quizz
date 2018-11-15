package fr.diginamic.service;

import fr.diginamic.exception.*;
import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDAO;

public class AjouterQuestionService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) throws AjouterQuestionException {
		System.out.println("Veuillez saisir l’intitulé de la question :");
		String intitule = scanner.nextLine();
		
		// Gestion nombre de réponses
		int nbReponses = 0;
		try {
			System.out.println("Veuillez saisir le nombre de propositions : (exemple : 3)");
			nbReponses = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			throw new AjouterQuestionException(" /!\\ Il faut entrer un nombre pour le nombre de réponses ");
		}
		
		if (nbReponses < 2) {
			throw new AjouterQuestionException(" /!\\ Il faut au moins 2 propositions de réponses");
		}
		
		// Gestion proposition de réponses
		ArrayList<String> propositions = new ArrayList<String>(nbReponses);
		for (int i=0; i < nbReponses; i++) {
			System.out.println("Veuillez saisir la proposition n°"+(i+1)+" :");
			String rep = scanner.nextLine();
			propositions.add(rep);
		}
		
		// Gestion de la bonne réponse
		int indexBonneReponse = 1;
		try {
			System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+ nbReponses+") :");
			indexBonneReponse = Integer.parseInt(scanner.nextLine());
			
			if (indexBonneReponse < 1 || indexBonneReponse > nbReponses) {
				throw new AjouterQuestionException(" /!\\ Il faut entrer un nombre (entre 1 et "+ nbReponses+") pour le numéro de bonne réponse ");
			}
					
		} catch (Exception e) {
			throw new AjouterQuestionException(" /!\\ Il faut entrer un nombre (entre 1 et "+ nbReponses+") pour le numéro de bonne réponse ");
		}
				
		// Création et sauvegarde de la question
		Question q = new Question(intitule, nbReponses);
		for (int i=0; i < propositions.size(); i++) {
			q.addProposition(propositions.get(i));
		}
		q.setBonneReponse(propositions.get(indexBonneReponse-1));
		dao.save(q);
	}
}
