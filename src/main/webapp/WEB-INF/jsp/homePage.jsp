<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<body>

<c:forEach var="park" items="${parkList}">
<div class="homePage">
	<a href="parkDetail?parkCode=${park.parkCode.toUpperCase()}">
		<c:url var="imageLink" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
		<img class="homeParkImg" src="${imageLink}"/></a>
	<img src="${imgUrl}">
	<h3>${park.parkName}</h3>
		<p>${park.parkDescription}</p>
		</div>
</c:forEach>
</body>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />