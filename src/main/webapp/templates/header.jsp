<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static java.util.Objects.isNull" %>
<%@ page import="quest.com.controller.Route" %>

<header class="p-3 text-bg-light">
  <div class="container">
    <div class="row align-items-center">
      <div class="col">
        <h1>awesome quest</h1>
      </div>
      <% if(!isNull(session.getAttribute("user"))) {%>
      <div class="col-auto ms-auto">
        <a href="<%=Route.LOGOUT%>" class="btn btn-primary">Выйти</a>
      </div>
      <% } %>
    </div>
  </div>
</header>

