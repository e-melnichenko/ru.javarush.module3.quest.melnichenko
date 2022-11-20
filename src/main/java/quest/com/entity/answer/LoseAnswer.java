package quest.com.entity.answer;

import lombok.Getter;

public class LoseAnswer extends Answer {
    @Getter
    private final String loseText;

    public LoseAnswer(String text, String loseText) {
        super(text);
        this.loseText = loseText;
    }
}
