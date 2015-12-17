

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav">
<li><img src="<spring:url value="/resources/images/logo.jpg"/>"/></li>
<li><a href="<spring:url value="#"/>">Home</a></li>
<li><a href="<spring:url value="#"/>">Popular</a></li>
<%-- <sec:authorize access="isAnonymous()"> --%>
<li class= "right"><a href="<spring:url value="/addUser"/>">Register <security:authentication property="principal.username"/></a></li>
<li class= "right"><a href="<spring:url value="/login"/>">Login</a></li>
<%-- </sec:authorize> --%>
<%-- <sec:authorize access="isAnonymous()">
<li class= "right">Welcome </li>
<li class= "right"><a href="<spring:url value="/logout"/>">Login</a></li>
</sec:authorize> --%>

</ul>