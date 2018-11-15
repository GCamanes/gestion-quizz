package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.StockageException;
import fr.diginamic.model.QuestionDAO;

public abstract class MenuService {

	public abstract void executeUC(Scanner scanner, QuestionDAO dao) throws StockageException;
	
}
