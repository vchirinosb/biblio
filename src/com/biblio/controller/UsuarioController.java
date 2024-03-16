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

import com.biblio.pojo.Usuario;
import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;
import com.biblio.service.UsuarioService;

/**
* @author vchirinosb
* @since 22/10/2016
*/
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	
	@RequestMapping("/usuario")
	public String showUsuario(Model model, Integer offset, Integer maxResults,
			@ModelAttribute("resultado") String resultado) {

		List<Usuario> usuarios = usuarioService.findAll(offset, maxResults);

		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("resultado", resultado);

		// Paginacion
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("count", usuarioService.count());
		model.addAttribute("offset", offset);

		return "mtnusuario/usuario";
	}

	@RequestMapping(value = "/usuario/save", method = RequestMethod.POST)
	public String handleUsuario(
			@ModelAttribute("usuario") @Validated(value = { PersistenceGroup.class, SpringFormGroup.class }) Usuario usuarioForm,
			BindingResult result, Model model, RedirectAttributes ra,
			@ModelAttribute("resultado") String resultado,
			Integer offset, Integer maxResults) {

		if (result.hasErrors()) {
			List<Usuario> usuarios = usuarioService.findAll(offset, maxResults);
			// Paginacion
			model.addAttribute("usuarios", usuarios);
			model.addAttribute("count", usuarioService.count());
			model.addAttribute("offset", offset);
			return "mtnusuario/usuario";
		}

		usuarioService.saveOrUpdate(usuarioForm);
		ra.addFlashAttribute("resultado", "CAMBIOS REALIZADOS CON ÉXITO");

		return "redirect:/usuario";
	}

	@RequestMapping("/usuario/{idUsuario}/update")
	public String showUpdate(Model model, @PathVariable("idUsuario") int idUsuario,
			@ModelAttribute("resultado") String resultado) {
		Usuario usuario = usuarioService.findById(idUsuario);
		model.addAttribute("usuario", usuario);

		return "mtnusuario/usuario";
	}

	@RequestMapping("/usuario/{idUsuario}/delete")
	public String delete(Model model, @PathVariable("idUsuario") int idUsuario, RedirectAttributes ra) {
		
		usuarioService.delete(idUsuario);
		ra.addFlashAttribute("resultado", "USUARIO ELIMINADO CON ÉXITO");

		return "redirect:/usuario";

	}

}
