package ws.synopsis.trainingevaljhonatanarones.repository.impl;

import ch.qos.logback.core.net.server.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ws.synopsis.trainingevaljhonatanarones.model.User;
import ws.synopsis.trainingevaljhonatanarones.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public static Map<Long,User> USERS;

    static {
        USERS = new HashMap<>();
        USERS.put(1L,User.builder()
                        .name("Jhonatan")
                        .lastName("Aronés")
                        .cellPhone("931542164")
                        .password("sessionT5")
                        .build()
        );
        USERS.put(2L,User.builder()
                        .name("Kevin")
                        .lastName("Villanueva")
                        .cellPhone("954678149")
                        .password("micontra")
                        .build()
        );
        USERS.put(2L,User.builder()
                        .name("Kevin")
                        .lastName("Villanueva")
                        .cellPhone("954678149")
                        .password("micontra")
                        .build()
        );
    }

    @Override
    public List<User> list() {
        return USERS.entrySet().stream()
                .map(longUserEntry -> longUserEntry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        USERS.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        User retrivedUser = USERS.get();
    }

    @Override
    public void remove(Long id) {

    }
}


