<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<body>

<c:forEach var="park" items="${parkList}">
	<a href="parkDetail?parkCode=${park.parkCode.toUpperCase()}">
		<c:url var="imageLink" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
		<img src="${imageLink}"/></a>
	<img src="${imgUrl}">
	<h3>${park.parkName}</h3>
		<p>${park.parkDescription}</p>
</c:forEach>
</body>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />