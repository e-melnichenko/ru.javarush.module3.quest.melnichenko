<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="quest.com.entity.Game" %>
<%@ page import="quest.com.entity.Question" %>
<%@ page import="quest.com.controller.Route" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Game game = (Game) session.getAttribute("game"); %>
<% Question question = game.getCurrentQuestion(); %>

<jsp:include page="templates/head.jsp"/>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <form action="<%=Route.GAME_ANSWER%>" method="post" class="mt-5">
        <p><%= question.getText() %></p>
        <div class="mb-3">
            <c:forEach items="${game.getCurrentQuestion().getAnswerList()}" var="answer">
                <div class="form-check">
                    <input type="radio" name="answerId" class="form-check-input" id="${answer.getId()}" value="${answer.getId()}" required>
                    <label for="${answer.getId()}" class="form-check-label">${answer.getText()}</label>
                </div>
            </c:forEach>
        </div>
        <button type="submit" class="btn btn-primary">Ответить</button>
    </form>
</div>

<jsp:include page="templates/stats.jsp"/>
<jsp:include page="templates/footer.jsp"/>