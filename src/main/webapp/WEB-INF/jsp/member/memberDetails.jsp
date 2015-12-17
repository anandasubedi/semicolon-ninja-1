<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring]"%>

	<h3> ${member.firstName } ${member.lastName }</h3>
	<p> Birth Date: ${ member.birthDate} </p>
	<p> ${member.role }</p>
