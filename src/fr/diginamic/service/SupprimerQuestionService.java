package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.SupprimerQuestionException;
import fr.diginamic.model.*;

public class SupprimerQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDAO dao) throws SupprimerQuestionException {
		int indexQuestion = 0;
		
		try {
			System.out.println("Veuillez saisir le numéro de la question à supprimer (entre 1 et "+ dao.findAll().size()+") :");
			indexQuestion = Integer.parseInt(scanner.nextLine());
			if (indexQuestion < 1 || indexQuestion > dao.findAll().size()) {
				throw new AjouterQuestionException(" /!\\ Il faut entrer un nombre (entre 1 et "+ dao.findAll().size()+") pour numéro de question à supprimer ");
			}
		} catch (Exception e) {
			throw new SupprimerQuestionException(" /!\\ Il faut rentrer un nombre (entre 1 et "+ dao.findAll().size()+") pour le numéro de question à supprimer");
		}
		
		dao.delete(indexQuestion-1);
		System.out.println("Question supprimée !");
	}
}
