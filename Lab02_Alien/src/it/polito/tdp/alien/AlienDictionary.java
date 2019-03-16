package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	// key -> alien, value -> trans
	private List<WordEnhanced> alienDict;

	public AlienDictionary() {
		this.alienDict = new LinkedList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {

		WordEnhanced w = new WordEnhanced(alienWord, translation);
		if (this.alienDict.contains(w)) {
			this.alienDict.get(this.alienDict.indexOf(w)).addTranslation(translation);
		} else {
			alienDict.add(w);
		}
	}

	public void reset() {
		this.alienDict.clear();
	}

	public List<String> translateWord(String alienWord) {

		// implemento la wildcard "?"
		if (alienWord.contains("?")) {
			List<String> buffer;
			List<String> res = new LinkedList<String>();

			for (int i = 0; i < 26; i++) {
				String newWord = alienWord.replaceAll("\\?", Character.toString((char) (97 + i)));
				WordEnhanced w = new WordEnhanced(newWord);
				if (alienDict.contains(w)) {
					if ((buffer = alienDict.get(alienDict.indexOf(w)).getTranslation()) != null) {
						res.addAll(buffer);
						System.out.println(res);
					}
				}
			}
			return res;
		} else {

		WordEnhanced w = new WordEnhanced(alienWord);
		if (alienDict.contains(w)) {
			return alienDict.get(alienDict.indexOf(w)).getTranslation();
		}
		return null;
		}
	}
}
