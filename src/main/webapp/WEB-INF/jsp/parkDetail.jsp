<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<body>
<img src="img/parks/${ourPark.parkCode.toLowerCase()}.jpg"/>
<p><c:out value="${ourPark.parkName}"/></p>
<p><c:out value="${ourPark.state}"/></p>
<p><c:out value="${ourPark.acreage}"/></p>
<p><c:out value="${ourPark.elevationInFeet}"/></p>
<p><c:out value="${ourPark.milesOfTrail}"/></p>
<p><c:out value="${ourPark.numberOfCampsites}"/></p>
<p><c:out value="${ourPark.climate}"/></p>
<p><c:out value="${ourPark.yearFounded}"/></p>
<p><c:out value="${ourPark.annualVisitorCount}"/></p>
<p><c:out value="${ourPark.inspirationalQuote}"/></p>
<p><c:out value="${ourPark.inspirationalQuoteSource}"/></p>
<p><c:out value="${ourPark.parkDescription}"/></p>
<p><c:out value="${ourPark.entryFee}"/></p>
<p><c:out value="${ourPark.numberOfAnimalSpecies}"/></p>

<div>
	<form action="parkDetail" method=POST>
		<c:set var="isCheckedonF" value="checked"/>
		<c:set var="isCheckedonC" value=""/>
		<c:if test='${userTemp.equals("Celsius")}'>
			<c:set var="isCheckedonF" value=""/>
			<c:set var="isCheckedonC" value="checked"/>
		</c:if>
		<input type="radio" name="radios" value="Fahrenheit" <c:out value="${isCheckedonF}"/>>Fahrenheit
		<input type="radio" name="radios" value="Celsius" <c:out value="${isCheckedonC}"/>>Celsius
		<input type="hidden" name="parkCode" value="${ourPark.parkCode}">
		<input type="submit" value="Submit">
	</form>
</div>
<div class="weather">
		<c:forEach var="weather" items="${weatherList}">
			<img src='img/weather/${weather.forecast.toLowerCase()}.png' />
			<c:out value="${weather.fiveDayForecastValue}" />
			<c:if test='${userTemp.equals("Celsius")}'>
				<c:out value="${Math.round((weather.low - 32) * (5/9))}" />
			</c:if>
			<c:if test='${userTemp.equals("Fahrenheit")}'>
				<c:out value="${weather.low}" />
			</c:if>
			<c:if test='${userTemp.equals("Celsius")}'>
				<c:out value="${Math.round((weather.high - 32) * (5/9))}" />
			</c:if>
			<c:if test='${userTemp.equals("Fahrenheit")}'>
				<c:out value="${weather.high}" />
			</c:if>
			<c:choose>
				<c:when test="${weather.forecast.equals(snow)}">
					<c:out value="Pack snowshoes." />
				</c:when>

				<c:when test="${weather.forecast.equals(rain)}">
					<c:out value="Pack raingear and wear waterproof shoes." />
				</c:when>

				<c:when test="${weather.forecast.equals(thunderstorm)}">
					<c:out value="Seek shelter and avoid hiking on exposed ridges." />
				</c:when>

				<c:when test="${weather.forecast.equals(sun)}">
					<c:out value="Pack sunblock." />
				</c:when>

				<c:when test="${weather.high > 75}">
					<c:out value="Bring an extra gallon of water." />
				</c:when>

				<c:when test="${weather.high - weather.low > 20}">
					<c:out value="Wear breathable layers." />
				</c:when>

				<c:when test="${weather.low < 20}">
					<c:out value="Kill your horse and sleep in the stomach." />
				</c:when>

				<c:otherwise>
					<c:out value="Enjoy your day at the park." />
				</c:otherwise>

			</c:choose>
		</c:forEach>
	</div>


</body>



