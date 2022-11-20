import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import quest.com.entity.Game;
import quest.com.entity.Question;
import quest.com.entity.story.Story;
import quest.com.entity.story.StoryCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void getCurrentQuestionShouldReturnStoryFirstQuestionAfterCreate() {
        String expectedText = "text";

        Story story = new StoryCreator()
                .addQuestion(expectedText)
                .addNextQuestionAnswer(Mockito.anyString())
                .addQuestion(Mockito.anyString())
                .create(Mockito.anyString());
        Question firstQuestion = new Game(story).getCurrentQuestion();

        assertEquals(expectedText, firstQuestion.getText());
    }
}
