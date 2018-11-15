package fr.diginamic.model;

import java.util.List;

public interface QuestionDAO {
	List<Question> findAll();
	void save(Question question);
	void delete(int indexQuestion);
}
