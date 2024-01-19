<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="count" value="1" />
<table border="1">
	<tr>
		<th>plan Id</th>
		<th>validity</th>
		<th>description</th>
	</tr>
	<c:forEach items="${plansList}" var="pdto">
		<c:if test="${count%2 !=0 }">
			<tr style="background: grey; color: white;">
				<td><c:out value="${pdto.planId }" /></td>
				<td><c:out value="${pdto.validity }" /></td>
				<td><c:out value="${pdto.description }" /></td>
			</tr>
		</c:if>
		<c:if test="${count%2 ==0 }">
			<tr style="background: blue; color: yellow;">
				<td><c:out value="${pdto.planId }" /></td>
				<td><c:out value="${pdto.validity }" /></td>
				<td><c:out value="${pdto.description }" /></td>
			</tr>
		</c:if>
		<c:set var="count" value="${count+1 }" />
	</c:forEach>
</table>
<br>
<a href="dash_board">GoTo Dashboard</a>
