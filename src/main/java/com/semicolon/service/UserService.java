package com.semicolon.service;

import com.semicolon.domain.Movie;
import com.semicolon.domain.User;

public interface UserService{
	
	void addUser(User user);

	User getUserByUsername(String name);

	User addToWatchList(Long movieId, User user);

	public boolean isExisted(String username);
}
