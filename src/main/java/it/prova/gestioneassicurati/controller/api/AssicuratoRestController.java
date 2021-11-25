package it.prova.gestioneassicurati.controller.api;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurati;
import it.prova.gestioneassicurati.model.Assicurati.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;

@RestController
@RequestMapping(value = "/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoRestController {

	@Autowired
	AssicuratoService assicuratoService;

	@GetMapping("/{idInput}")
	public Assicurato getAssicurato(@PathVariable(required = true) Long idInput) {
		return assicuratoService.get(idInput);
	}

	@GetMapping
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Assicurato createNewAssicurato(@RequestBody Assicurato assicuratoInput) {
		return assicuratoService.save(assicuratoInput);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Assicurato updateAssicurato(@RequestBody Assicurato assicuratoInput, @PathVariable Long id) {
		Assicurato assicuratoToUpdate = assicuratoService.get(id);
		assicuratoToUpdate.setNome(assicuratoInput.getNome());
		assicuratoToUpdate.setCognome(assicuratoInput.getCognome());
		assicuratoToUpdate.setDatadinascita(assicuratoInput.getDatadinascita());
		assicuratoToUpdate.setCodicefiscale(assicuratoInput.getCodicefiscale());
		assicuratoToUpdate.setNumerosinistri(assicuratoInput.getNumerosinistri());
		return assicuratoService.save(assicuratoToUpdate);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAssicurato(@PathVariable(required = true) Long id) {
		assicuratoService.delete(assicuratoService.get(id));
	}

	@GetMapping("/metodiBusiness")
	public void letturaFileXml() {


			try {

				File xmlFile = new File(
						"C:\\Corso\\ws_eclipse\\gestioneassicurati\\src\\main\\java\\it\\prova\\gestioneassicurati\\xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);

				System.out.println("Lista Assicurati:");
				List<Assicurato> list = que.getAssicurato();
				for (Assicurato ans : list)
					System.out.println(ans.getNome());

			} catch (JAXBException e) {
				e.printStackTrace();
			}

		}

	}

}