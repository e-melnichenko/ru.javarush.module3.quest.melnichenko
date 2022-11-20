package quest.com.controller;

import quest.com.repository.StoryTable;
import quest.com.entity.story.Story;
import quest.com.entity.story.StoryCreator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class InitListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public InitListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        StoryTable.getInstance().add(createUfoStory());
        StoryTable.getInstance().add(createMorningStory());
    }

    private Story createUfoStory() {
        return new StoryCreator()
                .addQuestion("Ты потерял память. Принять вызов НЛО?")
                .addLoseAnswer("Отклонить вызов", "Ты отклонил вызов")
                .addNextQuestionAnswer("Принять вызов")
                .addQuestion("Ты принял вызов. Поднимаешься на мостик к капитану?")
                .addLoseAnswer("Отказаться подниматься на мостик", "Ты не пошел на переговоры")
                .addNextQuestionAnswer("Подняться на мостик")
                .addQuestion("Ты поднялся на мостик. Ты кто?")
                .addLoseAnswer("Солгать о себе", "Твою ложь разоблачили")
                .addWinAnswer("Рассказать правду о себе", "Тебя вернули домой")
                .create("НЛО");
    }

    private Story createMorningStory() {
        return new StoryCreator()
                .addQuestion("Ты проснулся. Будешь спать дальше?")
                .addLoseAnswer("Поспать еще", "Ты выспался, но не успел сделать ФЗМ3.")
                .addWinAnswer("Не буду", "Ты встал, написал тесты и успешно сдал ФЗМ3")
                .create("Утренняя история");
    }
}
