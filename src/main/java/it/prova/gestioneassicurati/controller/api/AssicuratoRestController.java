package it.prova.gestioneassicurati.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.service.AssicuratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoRestController {
	
	@Autowired
	AssicuratoService assicuratoService;

}
