<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ruleStyle.css" >
</head>
<body>
<div class="back"></div>
<div class="content">

<h1><font face="Comic Sans MS, cursive"><b><font size="4">Это правила!</font></b></font></h1>
<div id="text">
	<p><font face="Comic Sans MS, cursive"><font size="4">Приветствуем вас на нашей базе покемонов! Сейчас у нас тренируется три команды покемонов: &quot;пип1&quot;, &quot;пип2&quot;,&nbsp; &quot;пип3&quot;. В начале игры мы, на свое усмотрение мы направим к вам одну из команд и вы сможете сразить с нашим ботом по имени ПИП!</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">В игре:</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">У каждого на руках есть 5 карт из колоды.</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">За ход вы должны выбрать атакующего покемона и цель для него.</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">Покемон наносит урон и использует свою суперспособноть, написанную на карточке.</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">Суммарный урон, нанесенный покемонам наносится и их владельцу.</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4"></font>Когда у покемона заканчиваются жизни, они считаются убитыми и им на смену приходит новый покемон из колоды.</font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">После хода соперника, выбранные им карточки выделяются.</font></font></p>
	<p><font face="Comic Sans MS, cursive"><font size="4">Игра заканчивается, когда кончаются жизни у одного из игроков.</font></font></p>
	<p>&nbsp;</p>
</div>
<spring:form method="post" modelAttribute="userJSP" action="menu">
    <spring:button>Вернуться</spring:button>
</spring:form>
</div>
</body>
</html>
