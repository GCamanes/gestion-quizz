package fr.diginamic.exception;

public class AjouterQuestionException extends StockageException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AjouterQuestionException() {}
	
	public AjouterQuestionException(String msg) {
		super(msg);
	}
}
