package com.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblio.pojo.Autor;
import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;
import com.biblio.service.AutorService;
import com.biblio.service.LibroService;

/**
* @author vchirinosb
* @since 18/10/2016
*/
@Controller
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LibroService libroService;

	@RequestMapping("/autor")
	public String showAutor(Model model, Integer offset, Integer maxResults,
			@ModelAttribute("resultado") String resultado) {

		List<Autor> autores = autorService.findAll(offset, maxResults);

		Autor autor = new Autor();
		model.addAttribute("autor", autor);
		model.addAttribute("resultado", resultado);

		// Paginacion
		model.addAttribute("autores", autores);
		model.addAttribute("count", autorService.count());
		model.addAttribute("offset", offset);

		return "mtnautor/autor";
	}

	@RequestMapping(value = "/autor/save", method = RequestMethod.POST)
	public String handleAutor(
			@ModelAttribute("autor") @Validated(value = { PersistenceGroup.class, SpringFormGroup.class }) Autor autorForm,
			BindingResult result, Model model, RedirectAttributes ra,
			@ModelAttribute("resultado") String resultado,
			Integer offset, Integer maxResults) {

		if (result.hasErrors()) {
			List<Autor> autores = autorService.findAll(offset, maxResults);
			// Paginacion
			model.addAttribute("autores", autores);
			model.addAttribute("count", autorService.count());
			model.addAttribute("offset", offset);
			return "mtnautor/autor";
		}

		autorService.saveOrUpdate(autorForm);
		ra.addFlashAttribute("resultado", "CAMBIOS REALIZADOS CON ÉXITO");

		return "redirect:/autor";
	}

	@RequestMapping("/autor/{idAutor}/update")
	public String showUpdate(Model model, @PathVariable("idAutor") int idAutor,
			@ModelAttribute("resultado") String resultado) {
		Autor autor = autorService.findById(idAutor);
		model.addAttribute("autor", autor);

		return "mtnautor/autor";
	}

	@RequestMapping("/autor/{idAutor}/delete")
	public String delete(Model model, @PathVariable("idAutor") int idAutor, RedirectAttributes ra) {
		
		if(!libroService.findAllByAutor(idAutor).isEmpty()){
			ra.addFlashAttribute("resultado",
					"EL AUTOR NO FUE ELIMINADO, FAVOR ELIMINAR PRIMERO LOS LIBROS ASOCIADOS AL AUTOR");
			return "redirect:/autor";
		}
		
		autorService.delete(idAutor);
		ra.addFlashAttribute("resultado", "AUTOR ELIMINADO CON ÉXITO");

		return "redirect:/autor";

	}

}
