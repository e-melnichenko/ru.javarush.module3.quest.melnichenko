package quest.com.entity;

import lombok.Getter;
import lombok.Setter;
import quest.com.entity.story.Story;

public class Game {
    @Getter
    @Setter
    private Question currentQuestion;

    public Game(Story story)  {
        currentQuestion = story.getStartQuestion();
    }
}
