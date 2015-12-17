package com.semicolon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.semicolon.domain.Movie;
import com.semicolon.service.MovieService;

@Controller
public class WelcomeController {

	@Autowired
	MovieService movieService;
	
	@RequestMapping(value="/dashboard")
	public String welcome(Model model){
		List<Movie> movies = movieService.geAllMovies();
		model.addAttribute("movies",movies);
		return "dashboard";
	}
}
