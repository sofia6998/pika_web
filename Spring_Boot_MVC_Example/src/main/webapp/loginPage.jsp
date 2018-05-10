<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,700,900' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" media="(min-width: 890px)">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mobile/style.css" media="(max-width: 890px)" type="text/css" />
</head>

<body>
<div class="back"></div>


<spring:form method="post" modelAttribute="userJSP" action="loginCapa" class="registration-form">
	<header>
		<h1>Sign Up</h1>
		<p>Fill in all informations</p>
		${userJSP.loginEr}
	</header>
	<form>
		<div class="input-section email-section">
			<spring:input path="name" id="myName" class="email" placeholder="USERNAME" autocomplete="off" width="80%"/>
	    	<div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span><span class="next-button email"><i class="fa fa-arrow-up"></i></span></div>
	    </div>
	    
	    <div class="input-section password-section folded">
	    	<spring:password path="password" id="myPass" class="password" placeholder="PASSWORD"/>
	        <div class="animated-button"><span class="icon-lock"><i class="fa fa-lock"></i></span><span class="next-button password"><i class="fa fa-arrow-up"></i></span></div>
	    </div>
	    	    
	    <div class="input-section repeat-password-section folded">
	    	<img id="captcha" src="${pageContext.request.contextPath}/resources/${userJSP.captchaImg}"/>
	    	<spring:input path="myCaptcha" id="myCap" class="capcha" placeholder="???" autocomplete="off"/>
	    	<div class="animated-button"><span class="icon-repeat-lock"><i class="fa fa-lock"></i></span><span class="next-button repeat-password"><i class="fa fa-paper-plane"></i></span></div>
	    </div>
	    
	    <div class="success"> 
	    	Create:<spring:checkbox path="tryToReg"/>
	    	<spring:button id="bt">Login</spring:button> 
    	</div>
	    
	    </form>
	    
	    
    
</spring:form>


<script src='${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js'></script>

    <script  src="${pageContext.request.contextPath}/resources/login.js"></script>

</body>
</html>
