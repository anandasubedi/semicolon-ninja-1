<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

	
	<a href="<spring:url value="/movies/add"/>">Add new Movie</a>
	
	<c:forEach var="movie" items="${movies}">
   		<h3>Movie <a href="<spring:url value="movies/view/${movie.id }"></spring:url>">${movie.name }</a> </h3>
		<p>${movie.description } <img alt="banner" width="200" src="<spring:url value="/resources/images/${movie.imagePath}"/>"/> </p>
		<p>${movie.director.firstName }</p>
		<p>${movie.producer.lastName }</p>
	</c:forEach>
