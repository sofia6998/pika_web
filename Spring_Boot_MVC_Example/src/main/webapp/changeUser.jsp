<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="changeUser">

  Имя: <spring:input path="name"/> (path="" - указывает путь, используемый в modelAttribute=''. в нашем случае User.name)  <br/>
  Старый пароль: <spring:input path="oldPass"/>   <br/>
  Новый пароль: <spring:input path="newPass"/>   <br/>
  Повторите новый пароль: <spring:input path="newPass2"/>   <br/>
  ${userJSP.loginEr} <br/>
  <spring:button>Сохранить</spring:button>

</spring:form>
<spring:form method="post" modelAttribute="userJSP" action="menu">
	<spring:button>Вернуться</spring:button>
</spring:form>
</body>

</html>
