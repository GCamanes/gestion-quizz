package fr.diginamic.console;


import java.util.Scanner;

import fr.diginamic.service.*;
import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.QuizzException;
import fr.diginamic.exception.SupprimerQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionMemDAO;
import fr.diginamic.model.TypeQuestion;

public class QuizzAdminConsoleApp {
	
	private String listOptions = new String(
			"\n1. Lister les questions\n" + 
			"2. Ajouter une nouvelle question\n" + 
			"3. Supprimer une question\n" + 
			"4. Exécuter le quizz\n" + 
			"99. Sortir");
	
	//private ArrayList<Question> listQuestions = new ArrayList<Question>();
	private QuestionMemDAO questionMemDAO = new QuestionMemDAO();
	
	private Scanner questionUser = new Scanner(System.in) ;

	public static void main(String[] args) {
				
		QuizzAdminConsoleApp quizzApp = new QuizzAdminConsoleApp();
		quizzApp.run();

	}
	
	public void run() {
		
		Question q1 = new Question("Quelle est la capitale de la france ?", 4, TypeQuestion.SIMPLE);
		q1.addProposition("Paris");
		q1.addProposition("Rome");
		q1.addProposition("Madrid");
		q1.addProposition("Londres");
		q1.setBonneReponse("Paris");
		
		this.questionMemDAO.save(q1);
		
		Question q2 = new Question("Qui a un problème avec les branches dans git ?", 3, TypeQuestion.BONUS);
		q2.addProposition("Clément");
		q2.addProposition("Josselin");
		q2.addProposition("Kevyn");
		q2.setBonneReponse("Josselin");
		
		this.questionMemDAO.save(q2);
		
		
		System.out.println("***** Quizz Administration *****");
		
		System.out.println(listOptions);
				
		int choice = 0;
		do {
			try {
				choice = Integer.parseInt(questionUser.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\n /!\\ Il faut rentrer un nombre (entre 1 et 4, ou 99) pour interagir avec le menu\n");
			}
			
			switch (choice) {
				case 1:
					showListQuestions();
					System.out.println(this.listOptions);
					break;
				case 2:
					System.out.println("Ajout d’une nouvelle question");
					addQuestion();
					System.out.println(this.listOptions);
					break;
				case 3:
					System.out.println("Suppression d’une question");
					deleteQuestion();
					System.out.println(this.listOptions);
					break;
				case 4:
					runQuizz();
					System.out.println(this.listOptions);
					break;
				default:
					System.out.println(this.listOptions);
					break;
			}
		} while (choice != 99);
		System.out.println("\nAu revoir");
	}
	
	public void showListQuestions() {
		ListerQuestionsService lqService = new ListerQuestionsService();
		lqService.executeUC(this.questionUser, this.questionMemDAO);
	}
	
	public void addQuestion() {
		AjouterQuestionService aqService = new AjouterQuestionService();
		try {
			aqService.executeUC(this.questionUser, this.questionMemDAO);
		} catch (AjouterQuestionException e) {
			System.out.println("\n"+e.getMessage());
		}
	}
	
	public void deleteQuestion() {
		SupprimerQuestionService sqService = new SupprimerQuestionService();
		try {
			sqService.executeUC(this.questionUser, this.questionMemDAO);
		} catch (SupprimerQuestionException e) {
			System.out.println("\n"+e.getMessage());
		}
	}
	
	public void runQuizz() {
		ExecuterQuizzService eqService = new ExecuterQuizzService();
		try {
			eqService.executeUC(this.questionUser, this.questionMemDAO);
		} catch (QuizzException e) {
			System.out.println("\n"+e.getMessage());
		}
	}
}
