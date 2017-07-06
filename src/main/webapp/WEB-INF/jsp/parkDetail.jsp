<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<body>
<p><c:out value="${ourPark.parkName}"/></p>
<p><c:out value="${ourPark.state}"/></p>
<p><c:out value="${ourPark.acreage}"/></p>
<p><c:out value="${ourPark.elevationInFeet}"/></p>
<p><c:out value="${ourPark.milesOfTrail}"/></p>
<p><c:out value="${ourPark.numberOfCampsites}"/></p>
<p><c:out value="${ourPark.climate}"/></p>
<p><c:out value="${ourPark.yearFounded}"/></p>
<p><c:out value="${ourPark.annialVisitorCount}"/></p>
<p><c:out value="${ourPark.inspirationalQuote}"/></p>
<p><c:out value="${ourPark.inspirationalQuoteSource}"/></p>
<p><c:out value="${ourPark.parkDescription}"/></p>
<p><c:out value="${ourPark.entryFee}"/></p>
<p><c:out value="${ourPark.numberOfAnimalSpecies}"/></p>
<p><c:out value="${ourPark.description}"/></p>
</body>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />