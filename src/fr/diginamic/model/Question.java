package fr.diginamic.model;

import java.util.ArrayList;

public class Question {
	private String intitule;
	private ArrayList<String> propositions;
	private String bonneReponse;
	private TypeQuestion type;
		
	public Question(String intitule, int nbReponses, TypeQuestion type) {
		super();
		this.intitule = intitule;
		this.propositions = new ArrayList<String>(nbReponses);
		this.type = type;
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
	
	public TypeQuestion getType() {
		return type;
	}

	public void setType(TypeQuestion type) {
		this.type = type;
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
