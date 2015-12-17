package com.semicolon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semicolon.domain.Movie;
import com.semicolon.domain.Review;
import com.semicolon.service.MovieService;
import com.semicolon.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value="review/add/{movieId}", method=RequestMethod.GET)
	public String addReviewForm(@ModelAttribute("review") Review review,@PathVariable("movieId") Long id,Model model){
		 
		 Movie movie = movieService.getMovieById(id);
		 
		 model.addAttribute("movie",movie);
		 return "movie/addReview";
	}
	
	@RequestMapping(value="review/add/{id}", method=RequestMethod.POST)
	public String addReview(@ModelAttribute("review") Review review,@PathVariable("id") Long id){
		System.out.println("Review Id: "+review.getId());
		 Movie movie = movieService.getMovieById(id);
		 review.setMovie(movie);
		// System.out.println(review.getId());
		 //To Do : Add authenticated user to review  
		 reviewService.addReview(review);
		 return "redirect:/movies/view/"+review.getMovie().getId();
	}
}
