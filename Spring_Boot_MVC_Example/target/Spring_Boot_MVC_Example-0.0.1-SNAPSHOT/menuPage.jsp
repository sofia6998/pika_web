<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Underdog" rel="stylesheet"> 
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/menuStyle.css" media="(min-width: 890px)">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mobile/mMenuStyle.css" media="(max-width: 890px)" type="text/css" />
</head>
<body>
<div class="back"></div>
<spring:form method="post" modelAttribute="userJSP" action="game">
    <spring:button>Играть!</spring:button>
</spring:form>
<spring:form method="post" modelAttribute="userJSP" action="rules">
    <spring:button>правила игры</spring:button>
</spring:form>
<spring:form method="post" modelAttribute="userJSP" action="top">
    <spring:button>Топ тренеров</spring:button>
</spring:form>
<spring:form method="post" modelAttribute="userJSP" action="exit">
    <spring:button>выход</spring:button>
</spring:form>

</body>
</html>
