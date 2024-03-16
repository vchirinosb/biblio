package com.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author vchirinosb
 * @since 18/10/2016
 */
@Controller
@SessionAttributes("resultado")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model) {
		// model.addAttribute("resultado", "Resultado desde Session");
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}

}
