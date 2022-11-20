import org.junit.jupiter.api.Test;
import quest.com.entity.answer.LoseAnswer;
import quest.com.entity.answer.WinAnswer;
import quest.com.entity.story.Story;
import quest.com.entity.story.StoryCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

public class StoryCreatorTest {
    @Test
    void addLoseAnswerShouldAddLoseAnswerWithGivenText() {
        String expectedText = "text";
        String expectedLoseText = "lose text";

        Story story = new StoryCreator()
                .addQuestion(anyString())
                .addLoseAnswer(expectedText, expectedLoseText)
                .create(anyString());

        LoseAnswer answer = (LoseAnswer) story.getStartQuestion().getAnswerList().get(0);
        assertEquals(expectedText, answer.getText());
        assertEquals(expectedLoseText, answer.getLoseText());
    }

    @Test
    void addWinAnswerShouldAddWinAnswerWithGivenText() {
        String expectedText = "text";
        String expectedLoseText = "win text";

        Story story = new StoryCreator()
                .addQuestion(anyString())
                .addWinAnswer(expectedText, expectedLoseText)
                .create(anyString());

        WinAnswer answer = (WinAnswer) story.getStartQuestion().getAnswerList().get(0);
        assertEquals(expectedText, answer.getText());
        assertEquals(expectedLoseText, answer.getWinText());
    }

    @Test
    void addAnswerWithoutQuestionShouldThrowRuntimeException() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new StoryCreator().addLoseAnswer(anyString(), anyString())
        );

        assertEquals("There isn't question for answer in Story", thrown.getMessage());
    }

    @Test
    void addNextQuestionAnswerShouldThrowRuntimeExceptionIfAlreadyExistInQuestion() {
        String questionText = "text";
        String expectedMessage = "AnswerType.NEXT_QUESTION already exist in question: " + questionText;

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new StoryCreator()
                        .addQuestion(questionText)
                        .addNextQuestionAnswer(anyString())
                        .addNextQuestionAnswer(anyString())
        );

        assertEquals(expectedMessage, thrown.getMessage());
    }
}
