import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import quest.com.entity.User;
import quest.com.repository.UserTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTableTest {
    UserTable userTable;

    @BeforeEach
    void init() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?> userTableConstructor = UserTable.getInstance().getClass().getDeclaredConstructor();
        userTableConstructor.setAccessible(true);
        userTable = (UserTable) userTableConstructor.newInstance();
    }

    @Test
    void getUserByNameAndPasswordShouldReturnUserWithGivenParams() {
        String name = "name";
        String password = "password";
        User expectedUser = new User(name, password);

        userTable.add(expectedUser);
        User actualUser = userTable.getUserByNameAndPassword(name, password);

        assertEquals(expectedUser, actualUser);
    }

    @ParameterizedTest
    @CsvSource({"wrong,password", "name,wrong", "wrong,wrong"})
    void getUserByNameAndPasswordShouldReturnNullIfUserDoesNotExist(String name, String password) {
        String userName = "name";
        String userPassword = "password";
        User expectedUser = new User(userName, userPassword);

        userTable.add(expectedUser);

        User actualUser = userTable.getUserByNameAndPassword(name, password);
        Assertions.assertNull(actualUser);
    }
}
