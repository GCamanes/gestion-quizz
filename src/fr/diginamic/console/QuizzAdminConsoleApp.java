package fr.diginamic.console;

import java.util.Scanner;

public class QuizzAdminConsoleApp {

	public static void main(String[] args) {
		
		String listQuestions = new String(
				"***** Quizz Administration *****\n" + 
				"1. Lister les questions\n" + 
				"2. Ajouter une nouvelle question\n" + 
				"3. Supprimer une question\n" + 
				"4. Exécuter le quizz\n" + 
				"99. Sortir");
		
		System.out.println(listQuestions);
		
		Scanner questionUser = new Scanner(System.in) ;
		
		int choice = 1;
		do {
			choice = questionUser.nextInt() ;
			
			switch (choice) {
				case 1:
					System.out.println(listQuestions);
					break;
				case 2:
					System.out.println("Ajout d’une nouvelle question");
					System.out.println(listQuestions);
					break;
				case 3:
					System.out.println("Suppression d’une question");
					System.out.println(listQuestions);
					break;
				case 4:
					System.out.println("Execution du quizz");
					break;
				default:
					break;
			}
		} while (choice != 99);
		System.out.println("\nAu revoir");
	}

}
