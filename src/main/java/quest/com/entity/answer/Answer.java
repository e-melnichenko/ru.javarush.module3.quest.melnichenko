package quest.com.entity.answer;

import com.fasterxml.uuid.Generators;
import lombok.Getter;

import java.util.UUID;

public abstract class Answer {
    @Getter
    final private UUID id;
    @Getter
    final private String text;

    public Answer(String text) {
        this.id = Generators.randomBasedGenerator().generate();
        this.text = text;
    }
}
