package com.uca.capas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
		
	@Autowired
	public UsuarioService usuarioService;
	
	
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		Usuario usuario = new Usuario();
		mv.addObject("usuario", usuario);
		return mv;
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult r) {
		ModelAndView mv = new ModelAndView();
		//Debe ir aquí Lógica de Login de Usuario y admin
		if(!r.hasErrors()) {
		String login = usuarioService.login(usuario.getUsername(), usuario.getPassword());
		if(login.equals("Valido")) {

			mv.addObject("usuario",usuario.getUsername());
			mv.setViewName("dashboard");
		}
		else {
			mv.setViewName("main");
			mv.addObject("res", "credenciales incorrectas");
		}}
		else {
			mv.setViewName("main");
		}

		return mv;
	}
}
	
