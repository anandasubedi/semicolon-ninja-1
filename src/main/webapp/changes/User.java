package com.semicolon.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int enabled;
	
//	@ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name="user_movies", 
//                joinColumns={@JoinColumn(name="user_id")}, 
//                inverseJoinColumns={@JoinColumn(name="movie_id")})
//    private Set<Movie> watchlist = new HashSet<Movie>();

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return userRole;
	}

	public void setRole(UserRole userRole) {
		this.userRole = UserRole.ROLE_USER;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = 1;
	}

	/**
	 * @return the watchlist
	 */
//	public Set<Movie> getWatchlist() {
//		return watchlist;
//	}
//
//	/**
//	 * @param watchlist the watchlist to set
//	 */
//	public void setWatchlist(Set<Movie> watchlist) {
//		this.watchlist = watchlist;
//	}

	/**
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	
}
