package fr.diginamic.model;

import java.util.ArrayList;

public class QuestionMemDAO implements QuestionDAO {
	
	private ArrayList<Question> listQuestions = new ArrayList<Question>();

	@Override
	public ArrayList<Question> findAll() {
		// TODO Auto-generated method stub
		return this.listQuestions;
	}

	@Override
	public void save(Question question) {
		// TODO Auto-generated method stub
		this.listQuestions.add(question);
	}
	
	public boolean checkIndex(int index) {
		if (index >= 0 && index < this.listQuestions.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void delete(int indexQuestion) {
		// TODO Auto-generated method stub
		this.listQuestions.remove(indexQuestion);
	}
	
}