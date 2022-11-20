package quest.com.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import quest.com.entity.answer.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    private final UUID id;
    @Getter
    private final String text;
    @Getter
    private final List<Answer> answerList = new ArrayList<>();

    public Question(String text) {
        this.id = Generators.randomBasedGenerator().generate();
        this.text = text;
    }

    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }
}
