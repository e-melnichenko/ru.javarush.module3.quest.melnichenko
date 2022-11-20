import org.junit.jupiter.api.Test;
import quest.com.entity.answer.WinAnswer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinAnswerTest {
    @Test
    void constructorShouldCreateAnswerWithWinText() {
        String expected = "win text";

        WinAnswer answer = new WinAnswer("text", expected);

        assertEquals(expected, answer.getWinText());
    }
}
