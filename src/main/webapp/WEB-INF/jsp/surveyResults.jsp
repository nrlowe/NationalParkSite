<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<body>
<h3>National Park Survey Results</h3>
<div>
	<c:forEach var="result" items="${resultMap}">
			<img src="img/parks/${result.key.toLowerCase()}.jpg">
			<c:choose>
			<c:when test='${result.key.toLowerCase().equals("cvnp")}'>
				<c:out value="Cuyahoga Valley National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("enp")}'>
				<c:out value="Everglades National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("gcnp")}'>
				<c:out value="Grand Canyon National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("gnp")}'>
				<c:out value="Glacier National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("gsmnp")}'>
				<c:out value="Great Smoky Mountains National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("gtnp")}'>
				<c:out value="Grand Teton National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("mrnp")}'>
				<c:out value="Mount Rainier National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("rmnp")}'>
				<c:out value="Rocky Mountain National Park" />
			</c:when>
			<c:when test='${result.key.toLowerCase().equals("ynp")}'>
				<c:out value="Yellowstone National Park" />
			</c:when>
			<c:otherwise>
				<c:out value="Yosemite National Park" />
			</c:otherwise>
			</c:choose>
			<p>${result.value}</p>
		</c:forEach>
</div>
</body>

