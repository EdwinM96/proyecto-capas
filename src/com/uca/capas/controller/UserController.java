package com.uca.capas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UsuarioService usuarioService;
	
	public Usuario usuario;
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		usuarioService.logout(id);
		ModelAndView mv = new ModelAndView();
		usuario = new Usuario();
		mv.addObject("usuario", usuario);
		mv.setViewName("main");
		return mv;
	}
	
}
