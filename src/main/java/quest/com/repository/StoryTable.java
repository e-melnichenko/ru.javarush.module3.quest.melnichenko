package quest.com.repository;

import quest.com.entity.story.Story;

import java.util.Collection;

public class StoryTable extends Table<Story> {
    private static StoryTable instance = new StoryTable();

    public static StoryTable getInstance() {
        return instance;
    }

    private StoryTable() {}

    public Collection<Story> getAll() {
        return tableMap.values();
    }
}
