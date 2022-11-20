import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import quest.com.entity.Question;
import quest.com.entity.answer.Answer;
import quest.com.entity.answer.LoseAnswer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    @Test
    void addAnswerShouldAddAnswerToAnswerList() {
        LoseAnswer expectedAnswer = new LoseAnswer(Mockito.anyString(), Mockito.anyString());
        Question question = new Question(Mockito.anyString());

        question.addAnswer(expectedAnswer);
        Answer resultAnswer = question.getAnswerList().stream()
                .filter(answer -> answer.equals(expectedAnswer))
                .findFirst()
                .orElseThrow();

        assertEquals(expectedAnswer, resultAnswer);
    }
}
