package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Dizionario model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField inserimentoId;

	@FXML
	private Button pulisciId;

	@FXML
	private TextArea risultatoId;

	@FXML
	private Button traduciId;

	@FXML
	void clearHandle(ActionEvent event) {
		inserimentoId.clear();
		risultatoId.clear();
	}

	@FXML
    void traduzioneHandle(ActionEvent event) {
    	String inserito = inserimentoId.getText().toLowerCase();
    	boolean ok = model.inputAccettabile(inserito);
    	
    	if(ok == true && inserito.compareTo("") != 0) {
    		String input[] = model.input(inserito);	
    		if(input.length == 2) {
    			model.aggiungiTraduzione(input[0], input[1]);
    			risultatoId.setText("Parola aggiunta al dizionario");
        		inserimentoId.clear();
    		}
    		else {
    			String ris = model.restituisciTraduzione(input[0]);
    			if(ris.compareTo("") == 0) {
    				risultatoId.setText("Parola non ancora inserita");
    				inserimentoId.clear();
    				}
    			else {
    				risultatoId.setText(ris);
    		        inserimentoId.clear();
    			}    			
    		}
    	}
    	else {
    		risultatoId.setText("Inserimento non valido, inserire solo lettere dell'alfabeto e al più UNO spazio");
    		inserimentoId.clear();    		
    	} 	
    }
	
	public void setModel(Dizionario model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert inserimentoId != null : "fx:id=\"inserimentoId\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pulisciId != null : "fx:id=\"pulisciId\" was not injected: check your FXML file 'Scene.fxml'.";
		assert risultatoId != null : "fx:id=\"risultatoId\" was not injected: check your FXML file 'Scene.fxml'.";
		assert traduciId != null : "fx:id=\"traduciId\" was not injected: check your FXML file 'Scene.fxml'.";

	}

}
