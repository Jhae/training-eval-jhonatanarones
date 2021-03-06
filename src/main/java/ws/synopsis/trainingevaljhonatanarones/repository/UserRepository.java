package ws.synopsis.trainingevaljhonatanarones.repository;

import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.DuplicatedCellPhoneException;
import ws.synopsis.trainingevaljhonatanarones.model.User;

import java.util.List;

public interface UserRepository {

    public List<User> list();
    public void save(User user) throws DuplicatedCellPhoneException;
    public void update(User user);
    public void remove(Long userId);

}
