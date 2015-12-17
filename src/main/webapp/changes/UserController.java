package com.semicolon.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semicolon.domain.Movie;
import com.semicolon.domain.User;
import com.semicolon.repository.MovieRepository;
import com.semicolon.service.UserService;
@RequestMapping("/user")
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
	public String addUser(@ModelAttribute("newUser") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "signup";
		} else {
			userService.addUser(user);

		}

		return "dashboard";
	}

	@RequestMapping(value="/addMovieToWatchList", method=RequestMethod.POST)
	public @ResponseBody Movie addToWatchList(@RequestBody Movie movie,Principal principal){
		movie = movieService.findOne(movie.getId());
		User user = userService.getUserByUsername(principal.getName());
		//Set<Movie> watchlist = user.getWatchlist();
		//watchlist.add(movie);
		//user.setWatchlist(watchlist);
		userService.addUser(user);
		
		return movie;
	}
}
