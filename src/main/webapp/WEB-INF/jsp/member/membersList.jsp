<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

	<h3>Movie Character List</h3>
	
	<a href="<spring:url value="members/add"/>">Add new Character</a>
	
	<c:forEach var="member" items="${members}">
   		<h4>${member.firstName} ${member.lastName}</h4>
   		
		<p>${member.role}</p>
	</c:forEach>
