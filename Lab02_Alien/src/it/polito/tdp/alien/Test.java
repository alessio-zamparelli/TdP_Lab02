package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		AlienDictionary dict = new AlienDictionary();
//		dict.addWord("parolaaliena", "traduzioneuno");
//		System.out.println(dict.translateWord("parolaaliena"));
//		
//	
//		dict.addWord("parolaaliena", "traduzionedue");
//		System.out.println(dict.translateWord("parolaaliena"));
//		
//		dict.addWord("parolaaliena", "traduzionetre");
//		System.out.println(dict.translateWord("parolaaliena"));
//
//		dict.addWord("parolaaliena", "traduzionequattro");
//		System.out.println(dict.translateWord("parolaaliena"));
//
//		dict.addWord("parolaaliena", "traduzionecinque");
//		System.out.println(dict.translateWord("parolaaliena"));

		dict.addWord("alieno", "ita");
		dict.addWord("alizno", "bravo");
		dict.addWord("alifno", "trovata");
		
		String alienWord = "ALI?NO";
		alienWord = alienWord.toLowerCase();
		
		
		System.out.println(dict.translateWord(alienWord));
		
//		List<String> buffer ;
//		List<String> res = new LinkedList<String>();
//		if (alienWord.contains("?")) {
//			for(int i =0 ; i<26;i++) {
//				String newWord = alienWord.replaceAll("\\?", Character.toString((char) (97+i)));
////				System.out.println(newWord);
//				
//				if((buffer=dict.translateWord(newWord))!=null) {
//					res.addAll(buffer);
//				}	
//			}
//		}
	}
}
