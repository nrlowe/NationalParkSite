<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/CSS/CSS.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        		<img src="${logoSrc}" alt="National Park Geek logo" />
        </a>
        
    </header>
    <nav>
        <h2>Explore The National Parks!</h2>
        <ul>
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="surveyInput">Survey</a></li>              
        </ul>
    </nav>