package it.prova.gestioneassicurati.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	@Autowired
	ProcessService processService;

	@Override
	public void unmarshalling(String path) {
		try {

			File xmlFile = new File(path);
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(Assicurati.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);

			processService.databaseProcessing(que, path);

		} catch (JAXBException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void scarta(String path) {
		File xmlFile = new File(path);
		xmlFile.renameTo(new File("E:\\Documenti\\eserciziotrigger\\scartato\\" + xmlFile.getName()));

	}

	@Override
	public void processa(String path) {
		File xmlFile = new File(path);
		xmlFile.renameTo(new File("E:\\Documenti\\eserciziotrigger\\processato\\" + xmlFile.getName()));

	}

}
