package it.prova.gestioneassicurati.service;

import it.prova.gestioneassicurati.xml.Assicurati;

public interface FileProcessingService {

	Assicurati unmarshalling();

	void scarta();

	void processa();

}
