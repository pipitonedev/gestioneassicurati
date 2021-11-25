package it.prova.gestioneassicurati.controller.api;

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
import it.prova.gestioneassicurati.xml.Assicurati;
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

		Assicurati assicurati = fileProcessingService.unmarshalling();

		processService.databaseProcessing(assicurati);

	}

}
