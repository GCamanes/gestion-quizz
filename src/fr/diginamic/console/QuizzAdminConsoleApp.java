package fr.diginamic.console;

import java.util.Scanner;

import fr.diginamic.model.Question;

import java.util.ArrayList;

public class QuizzAdminConsoleApp {
	
	private String listOptions = new String(
			"\n1. Lister les questions\n" + 
			"2. Ajouter une nouvelle question\n" + 
			"3. Supprimer une question\n" + 
			"4. Exécuter le quizz\n" + 
			"99. Sortir");
	
	private ArrayList<Question> listQuestions = new ArrayList<Question>();
	
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
		
		this.listQuestions.add(q1);
		
		Question q2 = new Question("Qui a un problème avec les branches dans git ?", 3);
		q2.addProposition("Clément");
		q2.addProposition("Josselin");
		q2.addProposition("Kevyn");
		q2.setBonneReponse("Josselin");
		
		this.listQuestions.add(q2);
		
		
		System.out.println("***** Quizz Administration *****");
		
		System.out.println(listOptions);
				
		int choice = 1;
		do {
			choice = Integer.parseInt(questionUser.nextLine()) ;
			
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
					break;
			}
		} while (choice != 99);
		System.out.println("\nAu revoir");
	}
	
	public void showListQuestions() {
		System.out.println("\n*** Liste des questions : ***");
		for (int i = 0; i < this.listQuestions.size(); i++) {
			System.out.println((i+1) + ") "+ this.listQuestions.get(i).toString());
		}
	}
	
	public void addQuestion() {
		
		System.out.println("Veuillez saisir l’intitulé de la question :");
		String intitule = this.questionUser.nextLine();
		System.out.println("Veuillez saisir le nombre de propositions : (exemple : 3)");
		int nbReponses = Integer.parseInt(this.questionUser.nextLine());
		
		ArrayList<String> propositions = new ArrayList<String>(nbReponses);
		for (int i=0; i < nbReponses; i++) {
			System.out.println("Veuillez saisir la proposition n°"+(i+1)+" :");
			String rep = this.questionUser.nextLine();
			propositions.add(rep);
		}
		int indexBonneReponse = 1;
		do {
			System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+ nbReponses+") :");
			indexBonneReponse = Integer.parseInt(this.questionUser.nextLine());
		} while (indexBonneReponse < 1 || indexBonneReponse > nbReponses);
		
		Question q = new Question(intitule, nbReponses);
		for (int i=0; i < propositions.size(); i++) {
			q.addProposition(propositions.get(i));
		}
		q.setBonneReponse(propositions.get(indexBonneReponse-1));
		
		this.listQuestions.add(q);
	}
	
	public void deleteQuestion() {
		int indexQuestion = 0;
		do {
			System.out.println("Veuillez saisir le numéro de la question à supprimer (entre 1 et "+ this.listQuestions.size()+") :");
			indexQuestion = Integer.parseInt(this.questionUser.nextLine());
		} while (indexQuestion < 1 || indexQuestion > this.listQuestions.size());
		
		this.listQuestions.remove(indexQuestion-1);
		System.out.println("Question supprimée !");
	}
	
	public void runQuizz() {
		System.out.println("\n*** Début du quizz ! Bonne chance ! ***");
		int score = 0;
		for (int i = 0; i < this.listQuestions.size(); i++) {
			Question q = this.listQuestions.get(i);
			System.out.println("\n" + (i+1) + ") " + q.toString());
			System.out.print("votre réponse :");
			int reponse = Integer.parseInt(this.questionUser.nextLine());
			
			if (q.getPropositions().get(reponse-1).equals(q.getBonneReponse())) {
				score += 1;
			}
		}
		System.out.println("\n*** Fin du quizz ! ***");
		System.out.println("votre score : " + score + " / " + this.listQuestions.size());
	}

}
