package quest.com.controller;

import quest.com.entity.User;
import quest.com.repository.UserTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(name = "SignInServlet", value = Route.SIGN_IN)
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");
        User user = UserTable.getInstance().getUserByNameAndPassword(userName, userPassword);

        if(isNull(user)) {
            response.sendRedirect(Route.USER_NOT_FOUND);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect(Route.HOME);
    }
}
