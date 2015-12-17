package com.semicolon.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semicolon.domain.Movie;
import com.semicolon.domain.User;
import com.semicolon.repository.UserRepository;
import com.semicolon.service.MovieService;
import com.semicolon.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	MovieService movieService;
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String name) {
		return userRepository.getUserByUsername(name);
	}

	@Override
	public User addToWatchList(Long movieId, User user) {
		Movie movie = movieService.getMovieById(movieId);
		
		Set<Movie> watchlist = user.getWatchList();
		watchlist.add(movie);
		user.setWatchList(watchlist);
		userRepository.save(user);
		return user;
	}
	
	@Override
	public boolean isExisted(String username) {
		User user = userRepository.getUserByUsername(username);
		if(user == null){
			return false;
		} else {
			return true;
		}
	}

}
