<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<h3>Add a Review for ${movie.name }</h3>
	<p>
	<spring:url value="/review/add/{id}"  var="postAction" >
   		<spring:param name="id" value="${movie.id}" />
 	</spring:url>
	<form:form modelAttribute="review" method="Post" action="${postAction }">
		<form:label path="rating">Rating</form:label>
		<form:select path="rating" >
			<c:forEach var="i" begin="1" end="10">
				<option value="${i }">${i}</option>
			</c:forEach>  
		</form:select>
		<form:label path="comment">Comment</form:label>
		<form:textarea path="comment"/>
		<%-- <form:hidden path="movie.id" value="${movie.id}"/> --%>
		<form:input type="submit" path="" value="Add Comment"/>
	</form:form>
	</p>
