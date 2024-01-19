<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<form:form action="auth" method="post" modelAttribute="userLogin">
		<table>
			<tr>
				<td>User name</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>

		</table>
		<input type=submit value="submit" />
	</form:form>

</body>

</html>