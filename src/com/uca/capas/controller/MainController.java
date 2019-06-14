package com.uca.capas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import com.uca.capas.service.AdministradorService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
		
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public AdministradorService adminService;
	
	Usuario usuario;
	
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		usuario = new Usuario();
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult r) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		//Debe ir aquí Lógica de Login de Usuario y admin
		if(!r.hasErrors()) {
		String login = usuarioService.login(usuario.getUsername(), usuario.getPassword());
		String loginAdmin = adminService.loginAdmin(usuario.getUsername(), usuario.getPassword());
		if(login.equals("Valido")) {
			mv.addObject("usuario",usuario.getUsername());
			mv.setViewName("usuarioViews/dashboard");
		}
		else if (loginAdmin.equals("Valido")) {
			mv.addObject("usuario",usuario.getUsername());
			mv.setViewName("adminViews/dashboard");
		}
		else if(loginAdmin.equals("Already logged in")) {
			mv.addObject("loggedIn",true);
			usuario = new Usuario();
			mv.addObject("usuario",usuario);
			mv.setViewName("main");
		}
		else {
			mv.addObject("fallido",true);
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
			mv.setViewName("main");
		}}

		return mv;
	}
}
	
