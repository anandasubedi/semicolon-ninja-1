<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	<h3>Add a movie</h3>
	<spring:url value="movies/add" var="add_movie"/>
	<form:form modelAttribute="movie" method="POST"
		enctype="multipart/form-data">
		<p>
			<form:errors path="*" cssStyle="color:red"/>
		</p>
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="director.id">Director</form:label></td>
				<td><form:select path="director.id" items="${directors}" itemLabel="firstName" itemValue="id"/></td>
			</tr>
			<tr>
				<td><form:label path="producer.id">Producers</form:label></td>
				<td><form:select path="producer.id" items="${producers}" itemLabel="firstName" itemValue="id"/></td>
			</tr>
			<tr>
				<td><form:label path="stars">Stars</form:label></td>
				<td><form:select path="stars" items="${stars}" multiple="true" itemLabel="firstName" itemValue="id"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input id="productImage" path="banner" type="file"
						class="form:input-large" /></td>
			</tr>
			<tr>
		        <td><form:label path="releaseDate">id</form:label></td>
		        <td><form:input path="releaseDate" /></td>
			    </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
