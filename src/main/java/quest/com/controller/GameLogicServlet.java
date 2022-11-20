package quest.com.controller;

import quest.com.entity.Game;
import quest.com.entity.answer.Answer;
import quest.com.entity.answer.LoseAnswer;
import quest.com.entity.answer.NextQuestionAnswer;
import quest.com.entity.answer.WinAnswer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

import static java.util.Objects.isNull;

@WebServlet(name = "GameLogicServlet", value = Route.GAME_ANSWER)
public class GameLogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");
        UUID answerId = UUID.fromString(request.getParameter("answerId"));

        Answer answer = game.getCurrentQuestion().getAnswerList().stream()
                .filter(answerItem -> answerId.equals(answerItem.getId()))
                .findFirst()
                .orElse(null);

        if(isNull(answer)) {
            throw new RuntimeException("Answer can't be null");
        }

        if(answer instanceof NextQuestionAnswer) {
            NextQuestionAnswer nextQuestionAnswer = (NextQuestionAnswer) answer;
            game.setCurrentQuestion(nextQuestionAnswer.getNextQuestion());
            response.sendRedirect(Route.GAME);
        } else if(answer instanceof LoseAnswer) {
            LoseAnswer loseAnswer = (LoseAnswer) answer;
            session.setAttribute("loseText", loseAnswer.getLoseText());
            response.sendRedirect(Route.LOSE);
        } else if(answer instanceof WinAnswer) {
            WinAnswer winAnswer = (WinAnswer) answer;
            session.setAttribute("winText", winAnswer.getWinText());
            response.sendRedirect(Route.WIN);
        }
    }
}
