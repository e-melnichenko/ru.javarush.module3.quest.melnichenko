package quest.com.controller;

import quest.com.entity.User;
import quest.com.repository.StoryTable;
import quest.com.entity.Game;
import quest.com.entity.story.Story;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "NewGameServlet", value = Route.NEW_GAME)
public class NewGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UUID storyId = UUID.fromString(request.getParameter("storyId"));
        Story story = StoryTable.getInstance().findById(storyId);
        session.setAttribute("game", new Game(story));

        User user = (User) session.getAttribute("user");
        user.setGamesCount(user.getGamesCount() + 1);

        response.sendRedirect(Route.GAME);
    }
}
