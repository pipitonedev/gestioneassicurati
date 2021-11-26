package it.prova.gestioneassicurati.service;

import java.util.List;

import it.prova.gestioneassicurati.xml.Assicurati;

public interface ProcessService {

	void databaseProcessing(Assicurati assicurati, String path);

	void inserisciFile(List<Assicurati.Assicurato> lista, String path);

}
