<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Game Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/gameStyle.css" media="(min-width: 890px)">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mobile/gameStyle.css" media="(max-width: 890px)" type="text/css" />
</head>

<body>
<spring:form method="post" modelAttribute="userJSP" action="hod" >
<div id="cards">
<ul id="ul1">
    <spring:hidden path="hisCard" id="hisCard"/>
    <div class="pageCard">
        <img id="10" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(0)[0]}"
             onclick="CardSelect(10)"/>
        <br>
        <b> <3: ${userJSP.cards.get(0)[1]} </b>
    </div>
    <div class="pageCard">
        <img id="11" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(1)[0]}"
             onclick="CardSelect(11)"/>
        <br>
        <b><3: ${userJSP.cards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="12" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(2)[0]}"
             onclick="CardSelect(12)"/>
        <br>
        <b><3: ${userJSP.cards.get(2)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="13" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(3)[0]}"
             onclick="CardSelect(13)"/>
        <br>
        <b><3: ${userJSP.cards.get(3)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="14" src="${pageContext.request.contextPath}/resources/${userJSP.cards.get(4)[0]}"
             onclick="CardSelect(14)"/>
        <br>
        <b><3: ${userJSP.cards.get(4)[1]}</b>
    </div>
    <div class="pageCard" id="user1div">
        <img id="user1" src="${pageContext.request.contextPath}/resources/me.PNG"/>
        <br>
        <b><3: ${userJSP.opponentHP}</b>
    </div>
</ul>


<ul id="ul2">
    <spring:hidden path="myCard" id="myCard"/>
    <div class="pageCard">
        <img id="20" src="${pageContext.request.contextPath}/resources/${userJSP.myCards.get(0)[0]}"
             onclick="myCardSelect(20)"/>
        <br>
        <b><3: ${userJSP.myCards.get(0)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="21" src="${pageContext.request.contextPath}/resources/${userJSP.myCards.get(1)[0]}"
             onclick="myCardSelect(21)"/>
        <br>
        <b><3: ${userJSP.myCards.get(1)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="22" src="${pageContext.request.contextPath}/resources/${userJSP.myCards.get(2)[0]}"
             onclick="myCardSelect(22)"/>
        <br>
        <b><3: ${userJSP.myCards.get(2)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="23" src="${pageContext.request.contextPath}/resources/${userJSP.myCards.get(3)[0]}"
             onclick="myCardSelect(23)"/>
        <br>
        <b><3: ${userJSP.myCards.get(3)[1]}</b>
    </div>
    <div class="pageCard">
        <img id="24" src="${pageContext.request.contextPath}/resources/${userJSP.myCards.get(4)[0]}"
             onclick="myCardSelect(24)"/>
        <br>
        <b><3: ${userJSP.myCards.get(4)[1]}</b>
    </div>
    <div class="pageCard" id="user2div">
        <img id="user2" src="${pageContext.request.contextPath}/resources/butt.png"/>
        <br>
        <b><3: ${userJSP.myHP} ${UserJSP.errorMsg}</b>
    </div>
</ul>
<label class="hide"  id="hC">${userJSP.myCard}</label>
<label class="hide" id="mC"> ${userJSP.hisCard}</label>
</div>
<br>
<spring:button id="bt">удар</spring:button>
</spring:form>
<script>

    function myCardSelect(a) {
        document.getElementById('20').style.boxShadow = "none";
        document.getElementById('21').style.boxShadow = "none";
        document.getElementById('22').style.boxShadow = "none";
        document.getElementById('23').style.boxShadow = "none";
        document.getElementById('24').style.boxShadow = "none";
        document.getElementById(a).style.boxShadow = "10px 10px 10px #FF1C87";
        document.getElementById("myCard").setAttribute('value', a);

    }

    function CardSelect(a) {
        document.getElementById('10').style.boxShadow = "none";
        document.getElementById('11').style.boxShadow = "none";
        document.getElementById('12').style.boxShadow = "none";
        document.getElementById('13').style.boxShadow = "none";
        document.getElementById('14').style.boxShadow = "none";
        document.getElementById(a).style.boxShadow = "10px 10px 10px #FF1C87";
        document.getElementById("hisCard").setAttribute('value', a);
    }
    
    	
    	document.getElementById('20').style.boxShadow = "none";
        document.getElementById('21').style.boxShadow = "none";
        document.getElementById('22').style.boxShadow = "none";
        document.getElementById('23').style.boxShadow = "none";
        document.getElementById('24').style.boxShadow = "none"; 
        var a = "2"+document.getElementById("mC").innerHTML;
        a = (a.replace(/\s/g, ''));
        document.getElementById(a).style.boxShadow = "10px 10px 10px #bada55";
        
        document.getElementById('10').style.boxShadow = "none";
        document.getElementById('11').style.boxShadow = "none";
        document.getElementById('12').style.boxShadow = "none";
        document.getElementById('13').style.boxShadow = "none";
        document.getElementById('14').style.boxShadow = "none";
        var b = "1"+document.getElementById("hC").innerHTML;
        b = (b.replace(/\s/g, ''));
        document.getElementById(b).style.boxShadow = "10px 10px 10px #bada55";
    	
</script>
</body>

</html>
