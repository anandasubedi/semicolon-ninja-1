package com.semicolon.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.WeakReferenceMonitor.ReleaseListener;
import org.springframework.web.multipart.MultipartFile;

@Entity(name="movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@Transient
	private MultipartFile banner;
	
	private String imagePath;
	
	private Date releaseDate;
	
//	@ManyToMany(cascade = CascadeType.ALL )
//	@JoinTable(name="movie_genre")
//	private List<Genre> genres;
	
	@OneToOne
	@JoinColumn(name="director")
	private Member director;
	
	@OneToOne
	@JoinColumn(name="producer")
	private Member producer;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	        name="movie_members",
	        joinColumns=@JoinColumn(name="movie_id"),
	        inverseJoinColumns=@JoinColumn(name="member_id")
	    )
	private List<Member> stars = new ArrayList<Member>();
	
	@OneToMany(mappedBy="movie",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Review> reviews;
	
	public Movie() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Member getDirector() {
		return director;
	}

	public void setDirector(Member director) {
		this.director = director;
	}

	public Member getProducer() {
		return producer;
	}

	public void setProducer(Member producer) {
		this.producer = producer;
	}

	public List<Member> getStars() {
		return stars;
	}

	public void setStars(List<Member> stars) {
		this.stars = stars;
	}

	public MultipartFile getBanner() {
		return banner;
	}

	public void setBanner(MultipartFile banner) {
		this.banner = banner;
	}

//	public List<Genre> getGenres() {
//		return genres;
//	}
//
//	public void setGenres(List<Genre> genres) {
//		this.genres = genres;
//	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
