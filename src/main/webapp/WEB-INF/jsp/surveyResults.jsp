<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<body>
<h3>National Park Survey Results</h3>
<div>
	<c:forEach var="result" items="${resultMap}">
			<img src="/img/parks/${result.key.toLowerCase()}.jpg">
			<p>${result.value}</p>
		</c:forEach>
</div>
</body>

