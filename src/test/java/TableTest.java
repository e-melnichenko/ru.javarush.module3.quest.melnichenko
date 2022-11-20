import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quest.com.entity.User;
import quest.com.repository.UserTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class TableTest {
    UserTable userTable;

    @BeforeEach
    void init() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?> userTableConstructor = UserTable.getInstance().getClass().getDeclaredConstructor();
        userTableConstructor.setAccessible(true);
        userTable = (UserTable) userTableConstructor.newInstance();
    }

    @Test
    void addShouldAddEntityToTableMap() {
        User expectedUser = new User(anyString(), anyString());

        userTable.add(expectedUser);
        User user = userTable.findById(expectedUser.getId());

        assertEquals(expectedUser, user);
    }

    @Test
    void findByIdShouldReturnEntityWithSameId() {
        User user = new User(anyString(), anyString());
        UUID expectedId = user.getId();
        userTable.add(user);

        User userById = userTable.findById(expectedId);

        assertEquals(expectedId, userById.getId());
    }
}
