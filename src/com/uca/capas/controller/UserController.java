package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Ticket;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repository.FuncionRepository;
import com.uca.capas.service.FuncionService;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public FuncionService funcionService;
	
	@Autowired
	public PeliculaService peliService;
	
	public Usuario usuario;
	
	@Autowired
	public FuncionRepository funcionRepo;
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		session.removeAttribute("user");
		usuarioService.logout(id);
		ModelAndView mv = new ModelAndView();
		usuario = new Usuario();
		mv.addObject("usuario", usuario);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		if(id == null || id.toString().isEmpty()) {
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
			mv.setViewName("main");
			return mv;
			
		}
		List <Pelicula> peliculas = peliService.listAll();
		mv.addObject("peliculas", peliculas);
		mv.setViewName("usuarioViews/dashboard");
		return mv;
	}
	
	@RequestMapping("/funcion")
	public ModelAndView funcion(HttpServletRequest request , @RequestParam(value = "pelicula") String pelicula, @RequestParam(value = "idPelicula") Integer idPelicula) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		if(id == null || id.toString().isEmpty()) {
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
			mv.setViewName("main");
			return mv;
			
		}
		if(pelicula == null || idPelicula== null) {
			mv.addObject("peliculas",peliService.listAll());
			mv.setViewName("dashboard");
			return mv;
		}
		mv.addObject("pelicula", pelicula);
		mv.addObject("funciones", funcionService.findFuncionesPelicula(idPelicula));
		mv.setViewName("usuarioViews/funcionesDisplay");
		return mv;
	}
	
	@RequestMapping("/reserva")
	public ModelAndView reserva(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		if(id == null || id.toString().isEmpty()) {
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
			mv.setViewName("main");
			return mv;
			
		}
		Ticket ticket = new Ticket();
		mv.addObject("ticket", ticket);
		return mv;
	}
	
}
