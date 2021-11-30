package ws.synopsis.trainingevaljhonatanarones.repository.impl;

import org.springframework.stereotype.Repository;
import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.DuplicatedCellPhoneException;
import ws.synopsis.trainingevaljhonatanarones.model.User;
import ws.synopsis.trainingevaljhonatanarones.repository.UserRepository;

import javax.print.attribute.standard.PresentationDirection;
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
                        .id(1L)
                        .name("Jhonatan")
                        .lastName("Aronés")
                        .cellPhone("931542164")
                        .password("sessionT5")
                        .build()
        );
        USERS.put(2L,User.builder()
                        .id(2L)
                        .name("Kevin")
                        .lastName("Villanueva")
                        .cellPhone("954678149")
                        .password("micontra")
                        .build()
        );
        USERS.put(3L,User.builder()
                        .id(3L)
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
    public void save(User user) throws DuplicatedCellPhoneException {
        if (cellPhoneExists(user.getCellPhone())){
            throw new DuplicatedCellPhoneException("El celular ya ha sido registrado");
        }

        Long generatedUserId =(long)USERS.size()+1;
        user.setId(generatedUserId);
        USERS.put(generatedUserId, user);
    }

    @Override
    public void update(User user) {
        User retrivedUser = USERS.get(user.getId());
        retrivedUser.setName(user.getName());
        retrivedUser.setLastName(user.getLastName());
        retrivedUser.setCellPhone(user.getCellPhone());
        retrivedUser.setPassword(user.getPassword());
    }

    @Override
    public void remove(Long userId) {
        USERS.remove(userId);
    }

    private boolean cellPhoneExists(String userCellPhone){
        return !(USERS.entrySet().stream().filter(longUserEntry -> userCellPhone.equals(longUserEntry.getValue().getCellPhone())).collect(Collectors.toList()).isEmpty());
    }
}


