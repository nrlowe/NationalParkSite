<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<body>
<h3>National Park Survey</h3>
<c:url var="formAction" value="/surveyInput"/>
<form:form method="POST" action="${formAction}" modelAttribute="survey">
	<label for="parkCode">Choose a Favorite Park:</label>
	<form:select path="parkCode">
		<c:forEach var="park" items="${parkList}">
			<option value="${park.parkCode}">${park.parkName}</option>
		</c:forEach>
	</form:select><br>
	<form:errors path="parkCode" cssClass="error"/>
	<br>
	<label for="email">Enter your Email Address:</label>
	<form:input type="text" path="email" /> <br>
	<form:errors path="email" cssClass="error"/>
	<br>
	<label for="state"> Enter State of Residence:</label>
	<form:input type="text" path="state" /><br>
	<form:errors path="state" cssClass="error"/>
	<br>
	<label for="activity">Select your activity level:</label>
	<form:select path="activity">
		<option value="inactive">Inactive</option>
		<option value="sedentary">Sedentary</option>
		<option value="active">Active</option>
		<option value="extremelyActive">Extremely Active</option>
	</form:select>
	<br>
	<form:errors path="activity" cssClass="error"/>
	<br>
	<input type="submit" value="Submit!"/>
	</form:form>
</body>

