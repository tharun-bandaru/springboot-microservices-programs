<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 style="background: yellow;">Customer Details</h2>

<hr>
Phone Number:
<c:out value="${customer_profile.phoneNumber}" />
<br>
First Name:
<c:out value="${customer_profile.firstName}" />
<br>
Last Name:
<c:out value="${customer_profile.lastName}" />
<br>
email:
<c:out value="${customer_profile.email}" />
<br>
<br>
<hr>
<h2 style="background: cyan;">Current Plan Details</h2>
<hr>
Plan Id:
<c:out value="${customer_profile.planData.planId}" />
</br>
validity:
<c:out value="${customer_profile.planData.validity}" />
</br>
Description:
<c:out value="${customer_profile.planData.description}" />
</br>
planName:
<c:out value="${customer_profile.planData.planName}" />
</br>
<br>
<h2 style="background: grey;">Friend Contact Numbers</h2>
<c:forEach items="${customer_profile.friendContacts }" var="friendNo">
	<c:out value="${friendNo}" />
</c:forEach>
<br>
<a href="dash_board">Goto DashBoard</a>
<hr>



