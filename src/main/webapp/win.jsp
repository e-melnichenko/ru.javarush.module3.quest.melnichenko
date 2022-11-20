<%@ page import="quest.com.controller.Route" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="templates/head.jsp"/>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <div class="pt-3 pb-3">
        <h1>Победа!</h1>
        <h2><%=session.getAttribute("winText")%></h2>

        <a href="<%=Route.HOME%>" class="btn btn-primary">Новая игра</a>
    </div>
</div>

<jsp:include page="templates/stats.jsp"/>
<jsp:include page="templates/footer.jsp"/>
