package com.semicolon.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semicolon.domain.Movie;
import com.semicolon.domain.User;
import com.semicolon.repository.MovieRepository;
import com.semicolon.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	MovieRepository movieService;

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
	public String addUser(@ModelAttribute("newUser") User user, Model model) {

		return "signup";
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("newUser") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "signup";
		} else {
			userService.addUser(user);

		}

		return "redirect:/login";
	}
	
	@RequestMapping(value="/addMovieToWatchList", method=RequestMethod.POST)
	public @ResponseBody Movie addToWatchList(@RequestBody Movie movie,Principal principal){
		
		User user = userService.getUserByUsername(principal.getName());
		
		userService.addToWatchList(movie.getId(),user);
		
		return movie;
	}
	
	@RequestMapping(value="/user/watchlist", method=RequestMethod.GET)
	public String addToWatchList(@RequestParam("username") String username,Model model){
		
		User user =  userService.getUserByUsername(username);
		model.addAttribute("user", user);
		System.out.println("Size : "+ user.getWatchList().size());
		for(Movie movie:user.getWatchList()){
			System.out.println(movie.getName());
		}
		return "user/watchlist";
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
		public @ResponseBody Object validate(String username) {
		return "" + userService.isExisted(username);
		}

}
