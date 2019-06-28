package com.uca.capas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repository.AdminRepository;
import com.uca.capas.service.AdministradorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	AdministradorService adminService;
	
	Usuario usuario;
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		usuario = new Usuario();
		ModelAndView mv = new ModelAndView();
		String username = (String) session.getAttribute("username");
		String rol = (String) session.getAttribute("rol");
		if( rol == null || username == null) {
			mv.addObject("usuario",usuario);
			mv.setViewName("main");
		}
		else {
			adminService.logoutAdmin(username);
			mv.addObject("usuario",usuario);
			mv.setViewName("main");		
		}
		
		return mv;
		
	}
	
}
