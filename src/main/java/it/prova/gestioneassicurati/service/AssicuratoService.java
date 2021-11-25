package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati.Assicurato;

@Service
public interface AssicuratoService {

	List<Assicurato> listAll();

	Page<Assicurato> searchAndPaginate(Assicurato assicuratoExample, Integer pageNo, Integer pageSize, String sortBy);

	Assicurato get(Long idInput);

	Assicurato save(Assicurato input);

	void delete(Assicurato input);
	
	Assicurato cercaPerCodiceFiscale(String codice);

}
