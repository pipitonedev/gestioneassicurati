package it.prova.gestioneassicurati.controller.api;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.service.AssicuratoService;
import it.prova.gestioneassicurati.service.FileProcessingService;
import it.prova.gestioneassicurati.service.ProcessService;
import it.prova.gestioneassicurati.model.Assicurato;

@RestController
@RequestMapping(value = "/api/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoRestController {

	@Autowired
	AssicuratoService assicuratoService;

	@Autowired
	FileProcessingService fileProcessingService;

	@Autowired
	ProcessService processService;

	@GetMapping("/list")
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public void letturaEScritturaFileXML() {

		final File cartella = new File("E:\\Documenti\\eserciziotrigger\\");

		for (final File nuovoFile : cartella.listFiles()) {
			if (nuovoFile.getName().endsWith(".xml") || nuovoFile.getName().endsWith(".XML")) {
				String path = "E:\\Documenti\\eserciziotrigger\\" + nuovoFile.getName();
				fileProcessingService.unmarshalling(path);
			}

		}

	}

}
