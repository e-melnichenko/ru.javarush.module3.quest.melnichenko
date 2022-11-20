package quest.com.entity.answer;

import lombok.Getter;

public class WinAnswer extends Answer{
    @Getter
    private final String winText;

    public WinAnswer(String text, String winText) {
        super(text);
        this.winText = winText;
    }
}
