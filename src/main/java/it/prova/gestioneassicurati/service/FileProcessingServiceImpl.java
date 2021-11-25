package it.prova.gestioneassicurati.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	@Override
	public Assicurati unmarshalling() {
		try {

			File xmlFile = new File("E:\\Documenti\\eserciziotrigger\\assicurato.xml");
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(Assicurati.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);
			return que;

		} catch (JAXBException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void scarta() {
		File xmlFile = new File("E:\\Documenti\\eserciziotrigger\\assicurato.xml");
		xmlFile.renameTo(new File("E:\\Documenti\\eserciziotrigger\\scartato\\assicurato.xml"));

	}

	@Override
	public void processa() {
		File xmlFile = new File("E:\\Documenti\\eserciziotrigger\\assicurato.xml");
		xmlFile.renameTo(new File("E:\\Documenti\\eserciziotrigger\\processato\\assicurato.xml"));

	}

}
