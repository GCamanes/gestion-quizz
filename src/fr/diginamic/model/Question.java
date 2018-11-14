package fr.diginamic.model;

import java.util.ArrayList;

public class Question {
	private String intitule;
	private ArrayList<String> propositions;
	private String bonneReponse;
		
	public Question(String intitule, int nbReponses) {
		super();
		this.intitule = intitule;
		this.propositions = new ArrayList<String>(nbReponses);
	}
	
	public boolean verifierReponse(String reponse) {
		return this.bonneReponse != null && reponse != null && this.bonneReponse.equals(reponse);
	}
	
	public void addProposition(String proposition) {
		propositions.add(proposition);
	}
	

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public ArrayList<String> getPropositions() {
		return propositions;
	}

	public void setPropositions(ArrayList<String> propositions) {
		this.propositions = propositions;
	}

	public String getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}

	@Override
	public String toString() {
		String questionText = this.intitule + "\n";
		for (int i = 0; i < this.propositions.size(); i++) {
			questionText += "\t- " + propositions.get(i) + "\n";
		}
		return questionText;
	}
	
}
