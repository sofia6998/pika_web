<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/infoStyle.css" >
</head>
<body>
<div class="back"></div>
<spring:form method="post" modelAttribute="train" action="menu">
	<div class="panel panel-default">
	              <!-- Default panel contents -->
	            <div class="panel-heading"><span class="lead">Рейтинг игроков </span></div>
	            <div STYLE=" height: 80%; font-size: 12px; overflow: auto;">
		            <table id="table" class="table table-hover" >
		                <thead>
		                    <tr>
		                    	<th>№</th>
		                        <th>Имя</th>
		                        <th>очки</th>
		                    </tr>
		                </thead>
		                <tbody>
		                <% int num = 0; %>
		                <c:forEach items="${train.trainlist}" var="user">
		                    <tr>
		                        <td><%=++num%></td>
		                        <td>${user.name}</td>
		                        <td>${user.exp}</td>
		                    </tr>
		                </c:forEach>
		                </tbody>
		        	</table>
	        	</div>
	  </div>
    <spring:button>Вернуться</spring:button>
</spring:form>
</body>
</html>
