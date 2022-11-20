package quest.com.entity.story;

import quest.com.entity.Question;
import quest.com.entity.answer.LoseAnswer;
import quest.com.entity.answer.NextQuestionAnswer;
import quest.com.entity.answer.WinAnswer;

import static java.util.Objects.isNull;

public class StoryCreator {
    private Question constructedQuestion;
    private Question startQuestion;

    public StoryCreator() {}

    public StoryCreator addQuestion(String text) {
        Question addedQuestion = new Question(text);

        if(!isNull(constructedQuestion)) {
            NextQuestionAnswer nextQuestionAnswer = (NextQuestionAnswer) constructedQuestion.getAnswerList().stream()
                    .filter(answer -> answer instanceof NextQuestionAnswer)
                    .findFirst()
                    .orElseThrow();

            nextQuestionAnswer.setNextQuestion(addedQuestion);
        } else {
            startQuestion = addedQuestion;
        }

        constructedQuestion = addedQuestion;
        return this;
    }

    public StoryCreator addNextQuestionAnswer(String text) {
        checkConstructedQuestion();
        checkIfAlreadyExist();

        constructedQuestion.addAnswer(new NextQuestionAnswer(text));

        return this;
    }

    public StoryCreator addLoseAnswer(String text, String loseText) {
        checkConstructedQuestion();

        constructedQuestion.addAnswer(new LoseAnswer(text, loseText));

        return this;
    }

    public StoryCreator addWinAnswer(String text, String winText) {
        checkConstructedQuestion();

        constructedQuestion.addAnswer(new WinAnswer(text, winText));
        return this;
    }

    public Story create(String storyName) {
        return new Story(storyName, startQuestion);
    }

    private void checkConstructedQuestion() {
        if(isNull(constructedQuestion)) {
            throw new RuntimeException("There isn't question for answer in Story");
        }
    }

    private void checkIfAlreadyExist() {
        Boolean isExist = constructedQuestion.getAnswerList().stream()
                .anyMatch(answer -> answer instanceof NextQuestionAnswer);

        if(isExist) {
            throw new RuntimeException("AnswerType.NEXT_QUESTION already exist in question: " + constructedQuestion.getText());
        }
    }
}
