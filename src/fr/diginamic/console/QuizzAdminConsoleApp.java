package fr.diginamic.console;

import java.util.Scanner;

import fr.diginamic.service.*;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionMemDAO;

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
		
		Question q1 = new Question("Quelle est la capitale de la france ?", 4);
		q1.addProposition("Paris");
		q1.addProposition("Rome");
		q1.addProposition("Madrid");
		q1.addProposition("Londres");
		q1.setBonneReponse("Paris");
		
		this.questionMemDAO.save(q1);
		
		Question q2 = new Question("Qui a un problème avec les branches dans git ?", 3);
		q2.addProposition("Clément");
		q2.addProposition("Josselin");
		q2.addProposition("Kevyn");
		q2.setBonneReponse("Josselin");
		
		this.questionMemDAO.save(q2);
		
		
		System.out.println("***** Quizz Administration *****");
		
		System.out.println(listOptions);
				
		int choice = 0;
		do {
			String tempChoice = questionUser.nextLine();
			if (tempChoice.equals("")) {
				choice = 0;
			} else {
				choice = Integer.parseInt(tempChoice);
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
					System.out.println("*** Attention : choix possibles 1, 2, 3, 4 et 99");
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
		aqService.executeUC(this.questionUser, this.questionMemDAO);
	}
	
	public void deleteQuestion() {
		SupprimerQuestionService sqService = new SupprimerQuestionService();
		sqService.executeUC(this.questionUser, this.questionMemDAO);
	}
	
	public void runQuizz() {
		ExecuterQuizzService eqService = new ExecuterQuizzService();
		eqService.executeUC(this.questionUser, this.questionMemDAO);
	}
}
