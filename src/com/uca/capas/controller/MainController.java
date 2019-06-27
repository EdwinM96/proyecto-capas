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
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = (Usuario)request.getSession().getAttribute("user");
		if(usr != null ) {
			mv.addObject("usuario",usr.getUsername());
		
			mv.setViewName("usuarioViews/dashboard");
			return mv;
		}
		
		
		mv.setViewName("main");
		usuario = new Usuario();
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView Login(HttpServletRequest request) {
		
		Usuario usr = (Usuario)request.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(usr != null ) {
			mv.addObject("usuario",usr.getUsername());
			mv.setViewName("usuarioViews/dashboard");
		}else {
			mv.setViewName("main");
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
				
		}
		return mv;
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult r,HttpServletRequest request) 
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		String login = usuarioService.login(usuario.getUsername(), usuario.getPassword());
		if(!r.hasErrors()) {
		String loginAdmin = adminService.loginAdmin(usuario.getUsername(), usuario.getPassword());
		if(login.contains("Valido")) {
			mv.addObject("usuario",usuario.getUsername());
			mv.setViewName("usuarioViews/dashboard");
			request.getSession().setAttribute("id", login.replaceFirst("Valido",""));
			request.getSession().setAttribute("rol", "usuario");
		}
		else if (loginAdmin.contains("Valido")) {
			mv.addObject("usuario",usuario.getUsername());
			mv.setViewName("adminViews/dashboard");
			request.getSession().setAttribute("user", usuario);
			request.getSession().setAttribute("rol", "admin");
		}
		else if(loginAdmin.equals("Already logged in") || login.contentEquals("Already logged in")) {
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
	
