package quest.com.entity.answer;

import lombok.Getter;
import lombok.Setter;
import quest.com.entity.Question;

public class NextQuestionAnswer extends Answer {
    @Getter
    @Setter
    private Question nextQuestion;

    public NextQuestionAnswer(String text) {
        super(text);
    }
}
