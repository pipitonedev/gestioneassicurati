package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	AssicuratoService assicuratoService;

	@Autowired
	FileProcessingService fileProcessingService;

	@Override
	public void databaseProcessing(Assicurati assicurati, String path) {

		List<Assicurati.Assicurato> listaAssicurati = assicurati.getAssicurato();

		for (Assicurati.Assicurato ass : listaAssicurati) {
			if (ass.getNumerosinistri() < 0 || ass.getNumerosinistri() > 10) {
				fileProcessingService.scarta(path);
				return;
			}
		}

		inserisciFile(listaAssicurati, path);

	}

	public void inserisciFile(List<Assicurati.Assicurato> lista, String path) {
		for (Assicurati.Assicurato ass : lista) {
			if (!StringUtils.isEmpty(assicuratoService.cercaPerCodiceFiscale(ass.getCodiceFiscale()))) {
				Assicurato assicurato = assicuratoService.cercaPerCodiceFiscale(ass.getCodiceFiscale());
				assicurato.setNumeroSinistri(assicurato.getNumeroSinistri() + ass.getNumerosinistri());
				assicuratoService.save(assicurato);
			} else {

				Assicurato assicurato = new Assicurato(ass.getNome(), ass.getCognome(),
						ass.getDatadinascita().toGregorianCalendar().getTime(), ass.getCodiceFiscale(),
						ass.getNumerosinistri());
				assicuratoService.save(assicurato);
			}
		}
		fileProcessingService.processa(path);
	}

}
