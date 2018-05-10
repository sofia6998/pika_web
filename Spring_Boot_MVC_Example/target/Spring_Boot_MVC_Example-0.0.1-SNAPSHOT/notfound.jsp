<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>...</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/default.css" media="(min-width: 890px)">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mobile/default.css" media="(max-width: 890px)" type="text/css" />
</head>
<body>
<h1><font face="Comic Sans MS, cursive"><b><font size="10">Вызывайте фиксиков!</font></b></font></h1>

<p>&nbsp;</p>

<spring:form method="post" modelAttribute="userJSP" action="menu">
    <spring:button>Я буду хорошо себя вести!</spring:button>
</spring:form>
</body>
</html>