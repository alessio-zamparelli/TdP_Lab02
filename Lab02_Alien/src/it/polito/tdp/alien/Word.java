package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translation;

	// due costruttori a seconda del numero di variabili in ingresso
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
	}

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String trans) {
		translation = trans;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		// se non è stata inizializzata la alienword
		if (this.alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!this.alienWord.equals(other.alienWord))
			return false;
		return true;
	}

}
