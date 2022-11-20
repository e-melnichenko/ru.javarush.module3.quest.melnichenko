package quest.com.repository;

import quest.com.entity.User;

public class UserTable extends Table<User> {
    private static UserTable instance = new UserTable();

    public static UserTable getInstance() {
        return instance;
    }

    private UserTable() {}

    public User getUserByNameAndPassword(String name, String password) {
        return tableMap.values().stream()
                .filter(user -> name.equals(user.getName()) && password.equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }
}
