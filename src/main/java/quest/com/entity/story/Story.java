package quest.com.entity.story;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import quest.com.repository.TableEntity;
import quest.com.entity.Question;

import java.util.UUID;

public class Story implements TableEntity {
    @Getter
    private UUID id = Generators.randomBasedGenerator().generate();
    @Getter
    private String name;
    @Getter
    private Question startQuestion;

    public Story(String name, Question startQuestion) {
        this.name = name;
        this.startQuestion = startQuestion;
    }
}
