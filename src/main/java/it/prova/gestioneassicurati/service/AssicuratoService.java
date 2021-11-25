package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.prova.gestioneassicurati.model.Assicurati.Assicurato;


public interface AssicuratoService {

	List<Assicurato> listAll();

	Page<Assicurato> searchAndPaginate(Assicurato assicuratoExample, Integer pageNo, Integer pageSize, String sortBy);

	Assicurato get(Long idInput);

	Assicurato save(Assicurato input);

	void delete(Assicurato input);

}
