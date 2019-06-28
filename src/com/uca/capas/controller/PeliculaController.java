package com.uca.capas.controller;


import java.util.List;

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

import com.uca.capas.domain.Funcion;
import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Ticket;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.FuncionService;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.TicketService;

@Controller
public class PeliculaController {
	
	
	@Autowired 
	public PeliculaService peliService;
	
	@Autowired 
	public FuncionService funcionService;
	
	@Autowired 
	public TicketService ticketService;
	
	
	
	@RequestMapping(value="/funciones",method = RequestMethod.GET)
	public ModelAndView funcionesCurrents(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Integer usr = (Integer)request.getSession().getAttribute("id");
		List<Pelicula> peliculas;
		List<Funcion> funciones;
		if(usr != null ) {
			
			peliculas = peliService.listAll();
			funciones = funcionService.CurrentsFunctions();			
			mv.addObject("peliculas", peliculas);
			mv.addObject("funciones", funciones);
			//agregar vista 
		}else {
			request.getSession().setAttribute("redirect", "funciones");
			return (new MainController()).main(request);
		}
		
		return mv;
	}
	
	
	@RequestMapping(value = "/Funcion", method = RequestMethod.POST)
	public ModelAndView funcion(@Valid @ModelAttribute("Funcion") Funcion funcion, HttpServletRequest request) {
		Ticket tic = new Ticket();
		ModelAndView mv = new ModelAndView();
		mv.addObject("ticket_to_make", tic);
		//addvista
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	public String tickets(@Valid @ModelAttribute("Ticket") Ticket ticket, HttpServletRequest request) {
		String resultado = "No se ha podido realizar el pago";
		if(ticketService.insert(ticket)) {
			resultado = "Succes";
		}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	

}
