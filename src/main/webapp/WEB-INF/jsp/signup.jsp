<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form commandName="newUser" action="addUser" method="POST" id="form-registration">

	<h3><legend>Sign Up</legend></h3>
	
	<form:errors path="*" cssClass="error" />
	<fieldset style="border-radius: 8px;">
		
		

		<label for="firstName"><spring:message code="user.name"
				text="some text" /> : </label>
		<form:input id="firstName" path="firstName" />
		<div style="text-align: center;">
			<form:errors path="firstName" cssStyle="color:red;" />
		</div>

		<p>
			<label for="lastName">Last Name: </label>
			<form:input id="lastName" path="lastName" />
		<div style="text-align: center;">
			<form:errors path="lastName" cssStyle="color : red;" />
		</div>
		</p>
		<p>
			<label for="email">Email: </label>
			<form:input id="email" path="email" />
		<div style="text-align: center;">
			<form:errors path="email" cssStyle="color : red;" />
		</div>
		</p>
		<p>
			<label for="username">Username</label>
			<form:input id="username" path="username" />
			<input type="button" id="checkValidity" value="check validity">
		<div style="text-align: center;">
			<span id="errors"></span>
			<form:errors path="username" cssStyle="color : red;" />
		</div>
		</p>
		<p>
			<label for="password">Password: </label>
			<form:password id="password" path="password" />
		<div style="text-align: center;">
			<form:errors path="password" cssStyle="color : red;" />
		</div>
		<form:hidden path="role" />
		<form:hidden path="enabled" />
		</p>
		<input type="reset"> <input type="submit" value="Sign Up">
	</fieldset>
</form:form>
<p>
	Language: <a href="?language=en">English</a> <a href="?language=es">Spanish</a>
</p>
