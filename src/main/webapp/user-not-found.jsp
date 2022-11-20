<%@ page import="quest.com.controller.Route" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="templates/head.jsp"/>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <div class="pt-3 pb-3">
        <h1>Пользователь не найден!</h1>
        <a href="<%=Route.AUTH%>" class="btn btn-primary">Регистрация</a>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>
