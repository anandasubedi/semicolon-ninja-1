package com.semicolon.controller;

import java.io.File;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.semicolon.domain.Member;
import com.semicolon.domain.Movie;
import com.semicolon.domain.Review;
import com.semicolon.domain.Role;
import com.semicolon.service.MemberService;
import com.semicolon.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value={"/movies","/"})
	public String addMovies(Model model){
		
		List<Movie> movies = movieService.geAllMovies();
		model.addAttribute("movies",movies);
		System.out.println(movies.size());
		return "movie/moviesList";
	}
	
	@RequestMapping(value="movies/add", method=RequestMethod.GET)
	public String addMovieForm(@ModelAttribute("movie") Movie movie, Model model){
		
		List<Member> directors =  memberService.getAllDirectors();
		List<Member> producers = memberService.getAllProducers();
		List<Member> stars = memberService.getAllStars();
		
		model.addAttribute("directors",directors);
		model.addAttribute("producers",producers);
		model.addAttribute("stars",stars);
		return "movie/addMovie";
	}
	
	
	@RequestMapping(value="movies/add", method=RequestMethod.POST)
	public String addMovie(@Valid @ModelAttribute("movie") Movie movie,BindingResult result, RedirectAttributes redirectAttribute, HttpServletRequest request,Model model){
		
		if(result.hasErrors()){
			List<Member> directors =  memberService.getAllDirectors();
			List<Member> producers = memberService.getAllProducers();
			List<Member> stars = memberService.getAllStars();
			
			model.addAttribute("directors",directors);
			model.addAttribute("producers",producers);
			model.addAttribute("stars",stars);
			return "movie/addMovie";
		}
		Member director = memberService.getMemberById(movie.getDirector().getId());
		Member producer = memberService.getMemberById(movie.getProducer().getId());
		
		movie.setDirector(director);
		movie.setProducer(producer);
		
//		for (Member member : movie.getStars()) {
//			System.out.println(member.getFirstName());
//		}
		
		uploadBanner(movie, request);
		movieService.addMovie(movie);
		redirectAttribute.addFlashAttribute(movie);
		return "redirect:/movie/details";
	}
	
	@RequestMapping(value="movie/details")
	public String viewMovie(Model model){
		return "movie/movieDetails";
	}
	
	@RequestMapping(value="movies/view/{id}", method=RequestMethod.GET)
	public String viewMovieDetails(@ModelAttribute("review") Review review,@PathVariable("id") Long id,Model model){
		
		Movie movie = movieService.getMovieById(id);
		if(movie==null){
			throw new MovieNotFoundException(id);
		}
		model.addAttribute("movie",movie);
		//System.out.println(movie.getReviews().size());
		return "movie/details";
	}
	
	private Movie uploadBanner(Movie movie, HttpServletRequest request){
		MultipartFile banner = movie.getBanner();
		String rootDirectory =  request.getSession().getServletContext().getRealPath("/");
		if (banner!=null && !banner.isEmpty()) {
		  try {
			  
			  String imageName =  movie.getName()+"_"+banner.getOriginalFilename()+".png";
			  String imagePath = rootDirectory+"resources\\images\\"+ imageName;
			  banner.transferTo(new File(imagePath));
			  movie.setImagePath(imageName);
		  } catch (Exception e) {
		  throw new RuntimeException("Movie banner image saving failed", e);
		  }
		}
		return movie;
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,EntityNotFoundException exception, ModelAndView mav) {

	    mav.addObject("exception", exception.getMessage());
	    mav.setViewName("error/entityNotFound");
	     return mav;
	}
}
