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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblio.pojo.Libro;
import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;
import com.biblio.service.AutorService;
import com.biblio.service.EditorialService;
import com.biblio.service.LibroService;
import com.biblio.service.dto.LibroDTO;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	@Autowired
	private EditorialService editorialService;
	

	@RequestMapping("/libro")
	public String showLibro(Model model, 
			@ModelAttribute("resultado") String resultado) {

		Libro libro = new Libro();
		
		model.addAttribute("libro", libro);
		model.addAttribute("autores", autorService.findAll());
		model.addAttribute("editoriales", editorialService.findAll());
		
		model.addAttribute("AutorSel", -1);
		model.addAttribute("EditorialSel", -1);
		
		model.addAttribute("resultado", resultado);

		return "mtnlibro/libro";
	}

	@RequestMapping(value = "/libro/save", method = RequestMethod.POST)
	public String handleLibro(
			@ModelAttribute("libro") @Validated(value = { PersistenceGroup.class, SpringFormGroup.class }) Libro libroForm,
			BindingResult result, Model model, RedirectAttributes ra, 
			@ModelAttribute("resultado") String resultado,
			@RequestParam("tautor") int idAutor, @RequestParam("teditorial") int idEditorial) {
		
		// Evaluado desde Client Side (libro.jsp) 
		// (1) idAutor, idEditorial = -1 
		//     tal que -1 = SeleccionarAutor, SeleccionarEditorial
		
		if (result.hasErrors()) {
			model.addAttribute("autores", autorService.findAll());
			model.addAttribute("AutorSel", idAutor);
			
			model.addAttribute("editoriales", editorialService.findAll());
			model.addAttribute("EditorialSel", idEditorial);
			
			return "mtnlibro/libro";
		}
		
		// Autor
		libroForm.setAutor(autorService.findById(idAutor));

		// Editorial
		libroForm.setEditorial(editorialService.findById(idEditorial));
		
		libroService.saveOrUpdate(libroForm);
		
		ra.addFlashAttribute("resultado", "CAMBIOS REALIZADOS CON ÉXITO");
		return "redirect:/libro";
		
	}

	@RequestMapping("/libro/{idLibro}/update")
	public String showUpdate(Model model, @PathVariable("idLibro") int idLibro,
			@ModelAttribute("resultado") String resultado) {
		
		Libro libro = libroService.findById(idLibro);
		model.addAttribute("libro", libro);
		
		model.addAttribute("autores", autorService.findAll());
		model.addAttribute("editoriales", editorialService.findAll());
		
		model.addAttribute("AutorSel", libro.getAutor().getIdAutor());
		model.addAttribute("EditorialSel", libro.getEditorial().getIdEditorial());

		return "mtnlibro/libro";
	}
	
	@RequestMapping("/libro/{idLibro}/delete")
	public String delete(Model model, @PathVariable("idLibro") int idLibro, RedirectAttributes ra) {
		
		try {
			libroService.delete(idLibro);
			ra.addFlashAttribute("resultado", "LIBRO ELIMINADO CON ÉXITO");

			return "redirect:/libro/listar";
		} catch (Exception e) {
			ra.addFlashAttribute("resultado",
					"EL LIBRO NO FUE ELIMINADO, FAVOR ELIMINAR PRIMERO LOS REGISTROS ASOCIADOS AL LIBRO");
			return "redirect:/libro/listar";
		}
		
	}
	
	@RequestMapping("/libro/listar")	
	public String listLibros(
			Model model, 
			Integer offset, Integer maxResults,
			@ModelAttribute("resultado") String resultado) {
		
		LibroDTO libroDTO = new LibroDTO();
		
		if (libroDTO.getAutor() == null) {
			libroDTO.setAutor("");
		}
		if (libroDTO.getEditorial() == null) {
			libroDTO.setEditorial("");
		}
		
		List<LibroDTO> librosDTO = libroService.findAll(libroDTO, offset, maxResults);

		model.addAttribute("resultado", resultado);

		// Paginacion
		model.addAttribute("libroDTO", libroDTO);
		model.addAttribute("librosDTO", librosDTO);
		model.addAttribute("count", libroService.count(libroDTO));
		model.addAttribute("offset", offset);

		return "mtnlibro/lstLibro";
	}
	
	
	@RequestMapping("/libro/buscar")	
	public String listLibros(
			Model model, @ModelAttribute("libroDTO") LibroDTO libroDTOForm,
			Integer offset, Integer maxResults,
			@ModelAttribute("resultado") String resultado) {
		
		if (libroDTOForm.getAutor() == null) {
			libroDTOForm.setAutor("");
		}
		if (libroDTOForm.getEditorial() == null) {
			libroDTOForm.setEditorial("");
		}
		
		List<LibroDTO> librosDTO = libroService.findAll(libroDTOForm, offset, maxResults);

		model.addAttribute("resultado", resultado);

		// Paginacion
		model.addAttribute("libroDTO", libroDTOForm);
		model.addAttribute("librosDTO", librosDTO);
		model.addAttribute("count", libroService.count(libroDTOForm));
		model.addAttribute("offset", offset);

		return "mtnlibro/lstLibro";
	}
	
}
