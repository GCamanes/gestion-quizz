package fr.diginamic.exception;

public class QuizzException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuizzException() {}
	
	public QuizzException(String msg) {
		super(msg);
	}

}
