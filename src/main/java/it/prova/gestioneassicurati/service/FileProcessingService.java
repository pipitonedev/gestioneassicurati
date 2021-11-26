package it.prova.gestioneassicurati.service;

import it.prova.gestioneassicurati.xml.Assicurati;

public interface FileProcessingService {

	public void unmarshalling(String path);

	void scarta(String path);

	void processa(String path);

}
