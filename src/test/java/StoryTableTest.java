import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quest.com.entity.story.Story;
import quest.com.entity.story.StoryCreator;
import quest.com.repository.StoryTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class StoryTableTest {
    StoryTable storyTable;

    @BeforeEach
    void init() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?> storyTableConstructor = StoryTable.getInstance().getClass().getDeclaredConstructor();
        storyTableConstructor.setAccessible(true);
        storyTable = (StoryTable) storyTableConstructor.newInstance();
    }

    @Test
    void getAllShouldReturnAllAddedStories() {
        Collection<Story> expectedCollection = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Story story = new StoryCreator()
                    .addQuestion(anyString())
                    .create(anyString());

            expectedCollection.add(story);
            storyTable.add(story);
        }

        assertEquals(expectedCollection.size(), storyTable.getAll().size());
        Assertions.assertTrue(storyTable.getAll().containsAll(expectedCollection));
    }
}
