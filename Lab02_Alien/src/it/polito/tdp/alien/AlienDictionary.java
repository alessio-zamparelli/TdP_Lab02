package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	// key -> alien, value -> trans
	private List<Word> alienDict;

	public AlienDictionary() {
		this.alienDict = new LinkedList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		
		Word w = new Word(alienWord, translation);
		alienDict.remove(w);
		alienDict.add(w);

	}
	
	public void reset() {
		this.alienDict.clear();
	}

	public String translateWord(String alienWord) {
		
		Word w = new Word(alienWord);
		if (alienDict.contains(w)) {
			return alienDict.get(alienDict.indexOf(w)).getTranslation();
		}
		return null;
	}
}
