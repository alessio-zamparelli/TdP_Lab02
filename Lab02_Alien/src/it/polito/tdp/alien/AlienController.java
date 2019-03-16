package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	AlienDictionary dict = new AlienDictionary();
	private String pattern = "^(\\w+(\\ \\w+)*)$";

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

	}

	@FXML
	void doTranslate(ActionEvent event) {

		// la parola in ingresso è nel formato:
		// <parola aliena> <traduzione> per inserirne una nuova
		// <parola aliena> per cercarne solo la traduzione

		String newTranslation = txtWord.getText().toLowerCase();

		// controllo la validità in ingresso
		if (!newTranslation.matches(pattern) || newTranslation == null || newTranslation.length() == 0) {
			txtResult.appendText("Testo in ingresso non valido, controllare la formattazione\n");
			txtResult.appendText("Le possibilità sono:\n");
			txtResult.appendText("<parola aliena> <traduzione>  	per inserirne una nuova\n");
			txtResult.appendText("<parola aliena> 					per cercarne solo la traduzione\n");
			return;
		}

		
		StringTokenizer st = new StringTokenizer(newTranslation, " ");
		
		if (!st.hasMoreElements()) {
			txtResult.appendText("Inserire una o due parole.\n");
			return;
		}
		
		//controllo che si abbiano al piu 2 elementi
		if (st.countTokens()>2) {
			txtResult.appendText("Inserire al piu 2 termini\n");
			return;
		}

		String alienWord = st.nextToken();

		//se devo inserire la traduzione
		if(st.hasMoreElements()) {
			String translation = st.nextToken();
			
			//controllo formattazione
			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.appendText("Inserire solo caratteri alfabetici.\n");
				return;
			}
			
			dict.addWord(alienWord, translation);
			txtResult.appendText(String.format("Aggiunto al dizionario %s che significa %s\n", alienWord, translation));
		} else {
			
			// se devo tradurre una parola
			if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.appendText("Inserire solo caratteri alfabetici.\n");
				return;
			}
			
			String translation = dict.translateWord(alienWord);
			if (translation == null) {
				txtResult.appendText(String.format("La parola %s non è ancora stata inserita!\n", alienWord));
			} else {
				txtResult.appendText(String.format("La parola %s significa %s\n", alienWord, translation));
			}
		}
		
		txtWord.clear();
		
		
	}

	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear();
		txtWord.clear();
		dict.reset();
	}

}
