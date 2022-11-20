<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="quest.com.entity.User" %>
<% User user = (User) session.getAttribute("user");%>

<div class="container">
    <table class="table mt-5" style="width: 500px;">
        <tr>
            <td>Имя</td>
            <td><%=user.getName()%></td>
        </tr>
        <tr>
            <td>Количество игр</td>
            <td><%=user.getGamesCount()%></td>
        </tr>
        <tr>
            <td>IP адрес</td>
            <td><%=request.getRemoteAddr()%></td>
        </tr>
    </table>
</div>
