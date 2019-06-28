package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Funcion;
import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Ticket;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repository.FuncionRepository;
import com.uca.capas.repository.UsuarioRepository;
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
	public UsuarioRepository usuarioRepo;
	
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
	public ModelAndView reserva(HttpServletRequest request, @RequestParam(value = "funcion") Integer idFuncion) {
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
		mv.addObject("idFuncion",idFuncion);
		mv.addObject("ticket", ticket);
		mv.setViewName("usuarioViews/reserva");
		return mv;
	}
	
	@RequestMapping("/saveReserva")
	public ModelAndView ejecutarReserva(HttpServletRequest request, @ModelAttribute("ticket") Ticket ticket) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		Integer id = Integer.parseInt((String) session.getAttribute("id"));
		if(id == null || id.toString().isEmpty()) {
			usuario = new Usuario();
			mv.addObject("usuario", usuario);
			mv.setViewName("main");
			return mv;
			
		}
		Integer numAsientos = ticket.getNumAsientos();
		if(numAsientos>15) {
			mv.addObject("tooMany",true);
			mv.addObject("idFuncion", ticket.getFuncion());
			mv.setViewName("usuarioViews/reserva");
			return mv;
		}
		HttpSession sesion = request.getSession();
		Integer usuarioId = (Integer) session.getAttribute("id");
		Usuario usuario = usuarioRepo.getOne(usuarioId);
		if(usuario.getSaldo()<(numAsientos*3.5)) {
			mv.addObject("noMoney",true);
			mv.addObject("idFuncion",ticket.getFuncion());
			mv.setViewName("usuarioViews/reserva");
			return mv;
		}
		Integer funcionId = ticket.getFuncion().getIdFuncion();
		Funcion funcion = funcionRepo.getOne(funcionId);
		if(funcion.getAsientosDisp()<numAsientos) {
			mv.addObject("noAsientos",true);
			mv.addObject("disponibles",funcion.getAsientosDisp());
			mv.addObject("idFuncion",ticket.getFuncion());
			mv.setViewName("usuarioViews/reserva");
			return mv;
		}
		usuario.setSaldo((float)(usuario.getSaldo()-(numAsientos*3.5)));
		usuarioService.editarUsuario(usuario);
		funcion.setAsientosDisp(funcion.getAsientosDisp()-numAsientos);
		funcionService.editarFuncion(funcion);
		
		Calendar fecha = Calendar.getInstance();		
		ticket.setUsuario(usuario);
		ticket.setFuncion(funcion);
		ticket.setNumAsientos(numAsientos);
		ticket.setfCreacion(fecha);
		mv.addObject("ticket", true);
		mv.setViewName("usuarioViews/dashboard");
		return mv;
		
		
	}
	
}
