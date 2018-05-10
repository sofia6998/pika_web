<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Game Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/gameStyle.css">
</head>

<body>
<spring:form method="post" modelAttribute="userJSP" action="wait">
<ul id="ul1">
    <spring:hidden path="hisCard" id="hisCard"/>
    <div class="pageCard">
        <img id="10" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}"/>
        <br>
        <b> <3: ${userJSP.cards.get(1)[1]} </b>
    </div>
    <div class="pageCard">
        <img id="11" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}""/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="12" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="13" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="14" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="user1" src="${pageContext.request.contextPath}/resources/me.PNG"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
</ul>

<ul id="ul2">
    <spring:hidden path="myCard" id="myCard"/>
    <div class="pageCard">
        <img id="20" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="21" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="22" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"
             onclick="myCardSelect(22)"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="23" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="24" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard" id="user2div">
        <img id="user2" src="${pageContext.request.contextPath}/resources/butt.png"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
</ul>
<label for="bt">осталось</label>
<spring:button id="bt">удар</spring:button>
<div id="end">
    </spring:form>
    <spring:form method="post" modelAttribute="userJSP" action="wait">
        <spring:button>Завершить ход</spring:button>
    </spring:form>
</div>
<div id="toMenu">
<spring:form method="post" modelAttribute="userJSP" action="menu">
    <spring:button>Вернуться</spring:button>
</spring:form>
</div>
<div id="footer">&copy; Богданова Ксения, Нагавкина София</div>
</body>

</html>
