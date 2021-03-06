package com.semicolon.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty
	@Size(min=5, max =20, message="Size must be between 5 and 20 characters")
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@Email
	private String email;
	
	@NotEmpty
	private String username;
	
	@Size(min=3, max =6, message="Size must be between 3 and 6 characters")
	private String password;
	private int enabled;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name="user_watchlist",
	        joinColumns=@JoinColumn(name="user_id"),
	        inverseJoinColumns=@JoinColumn(name="movie_id")
	    )
	private Set<Movie> watchList = new HashSet<Movie>();
	
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
	 * @return the watchList
	 */
	public Set<Movie> getWatchList() {
		return watchList;
	}

	/**
	 * @param watchList the watchList to set
	 */
	public void setWatchList(Set<Movie> watchList) {
		this.watchList = watchList;
	}
	
	
}
