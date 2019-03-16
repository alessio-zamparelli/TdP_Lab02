package it.polito.tdp.alien;

public class Test {

	public static void main(String[] args) {
		AlienDictionary dict = new AlienDictionary();
		dict.addWord("allala", "fanculo");
		System.out.println("Cerco allala -> " + dict.translateWord("allala"));


		dict.addWord("allala", "fanculoPanzone");		
		System.out.println("Cerco allala -> " + dict.translateWord("allala"));
		System.out.println("Cerco fannanna -> " + dict.translateWord("fannanna"));

		Word w1 = new Word("alien", "ita");
		Word w2 = new Word("alien", "merd");
		System.out.println(w1.getTranslation());
		System.out.println(w2.getTranslation());
		
		System.out.println("Uguali? " + w1.equals(w2));
	}
}
