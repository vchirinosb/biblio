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

import com.biblio.pojo.Editorial;
import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;
import com.biblio.service.EditorialService;
import com.biblio.service.LibroService;

/**
* @author vchirinosb
* @since 24/10/2016
*/
@Controller
public class EditorialController {

	@Autowired
	private EditorialService editorialService;
	
	@Autowired
	private LibroService libroService;

	@RequestMapping("/editorial")
	public String showEditorial(Model model, Integer offset, Integer maxResults,
			@ModelAttribute("resultado") String resultado) {

		List<Editorial> editoriales = editorialService.findAll(offset, maxResults);

		Editorial editorial = new Editorial();
		model.addAttribute("editorial", editorial);
		model.addAttribute("resultado", resultado);

		// Paginacion
		model.addAttribute("editoriales", editoriales);
		model.addAttribute("count", editorialService.count());
		model.addAttribute("offset", offset);

		return "mtneditorial/editorial";
	}

	@RequestMapping(value = "/editorial/save", method = RequestMethod.POST)
	public String handleEditorial(
			@ModelAttribute("editorial") @Validated(value = { PersistenceGroup.class, SpringFormGroup.class }) Editorial editorialForm,
			BindingResult result, Model model, RedirectAttributes ra,
			@ModelAttribute("resultado") String resultado,
			Integer offset, Integer maxResults) {

		if (result.hasErrors()) {
			List<Editorial> editoriales = editorialService.findAll(offset, maxResults);
			// Paginacion
			model.addAttribute("editoriales", editoriales);
			model.addAttribute("count", editorialService.count());
			model.addAttribute("offset", offset);
			return "mtneditorial/editorial";
		}

		editorialService.saveOrUpdate(editorialForm);
		ra.addFlashAttribute("resultado", "CAMBIOS REALIZADOS CON ÉXITO");

		return "redirect:/editorial";
	}

	@RequestMapping("/editorial/{idEditorial}/update")
	public String showUpdate(Model model, @PathVariable("idEditorial") int idEditorial,
			@ModelAttribute("resultado") String resultado) {
		Editorial editorial = editorialService.findById(idEditorial);
		model.addAttribute("editorial", editorial);

		return "mtneditorial/editorial";
	}

	@RequestMapping("/editorial/{idEditorial}/delete")
	public String delete(Model model, @PathVariable("idEditorial") int idEditorial, RedirectAttributes ra) {
		
		if(!libroService.findAllByEditorial(idEditorial).isEmpty()){
			ra.addFlashAttribute("resultado",
					"LA EDITORIAL NO FUE ELIMINADA, FAVOR ELIMINAR PRIMERO LOS LIBROS ASOCIADOS A LA EDITORIAL");
			return "redirect:/editorial";
		}
		
		editorialService.delete(idEditorial);
		ra.addFlashAttribute("resultado", "EDITORIAL ELIMINADA CON ÉXITO");

		return "redirect:/editorial";

	}

}
