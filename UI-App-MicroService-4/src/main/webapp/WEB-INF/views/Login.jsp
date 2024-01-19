<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<br>

<c:if test="${message ne null }">
	<c:out value="${message }" />
</c:if>
<br>
<hr>

<form action="login_customer" method="post">
	<table>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" name="phoneNo" />
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password" />
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="click"></td>
		</tr>

	</table>
</form>