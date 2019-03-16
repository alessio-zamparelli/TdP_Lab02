package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translation;

	// due costruttori a seconda del numero di variabili in ingresso
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
	}

	public WordEnhanced(String alienWord, String newTranslation) {
		this.alienWord = alienWord;
		this.translation = new ArrayList<String>();
		this.translation.add(newTranslation);
	}

	public void addTranslation(String newTranslation) {
		if (!this.translation.contains(newTranslation)) {
			this.translation.add(newTranslation);
		}
	}
	
	public List<String> getTranslation() {
		return translation;
	}



	@Override
	public boolean equals(Object obj) {
		// se sono lo stesso oggetto
		if (this == obj)
			return true;
		// se l'oggetto passato è vuoto
		if (obj == null)
			return false;
		// se sono di due classi diverse
		if (this.getClass() != obj.getClass())
			return false;
		// faccio il cast
		WordEnhanced other = (WordEnhanced) obj;
		// se non è stata inizializzata questa alienword
		if (this.alienWord == null) {
		// se l'altra alienword è stata inizializzata ma questa no
			if (other.alienWord != null)
				return false;
		}
		// se questa alienword è stata inizializzata ma l'altra è diversa
		else if (!this.alienWord.equals(other.alienWord))
			return false;
		// infine ritorna true
		return true;
	}

}
