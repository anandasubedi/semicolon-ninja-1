<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
<style type="text/css">@import url("<c:url value="/resources/css/navigation.css"/>");</style>
</head>
<body>
<div>
<ul class="nav nav-pills pull-right">
    <tiles:insertAttribute name="menu" />
   </ul>
   
   <h1>
    <tiles:insertAttribute name="header" />
   </h1>
   <p>
      <tiles:insertAttribute name="subHeader" />    
   </p>

   <div class="row container" >
     <tiles:insertAttribute name="body" />
   </div>
	<br>
   <div class="footer">
    <tiles:insertAttribute name="footer" />
   </div>
</div>
</body>
</html>