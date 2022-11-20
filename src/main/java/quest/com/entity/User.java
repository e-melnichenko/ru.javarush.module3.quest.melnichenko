package quest.com.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import lombok.Setter;
import quest.com.repository.TableEntity;

import java.util.UUID;

public class User implements TableEntity {
    @Getter
    private final String name;
    @Getter
    private final String password;
    @Getter
    private final UUID id = Generators.randomBasedGenerator().generate();
    @Getter
    @Setter
    private int gamesCount = 0;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
