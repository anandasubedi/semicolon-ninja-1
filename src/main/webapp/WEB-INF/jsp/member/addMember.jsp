<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<h3>Add a Movie Character</h3>
	<form:form modelAttribute="member" method="POST"
		enctype="multipart/form-data">
		<p>
			<form:errors path="*" cssStyle="color:red"/>
		</p>
		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color:red"/></td>
			</tr>
			
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:select path="role" items="${roles}"/></td>
				<td><form:errors path="role" cssStyle="color:red"/></td>
			</tr>
			<tr>
		        <td><form:label path="birthDate">Birth date</form:label></td>
		        <td><form:input path="birthDate" /></td>
		        <td><form:errors path="birthDate" cssStyle="color:red"/></td>
			    </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
