package ws.synopsis.trainingevaljhonatanarones.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PostRequest;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PutRequest;
import ws.synopsis.trainingevaljhonatanarones.model.User;
import ws.synopsis.trainingevaljhonatanarones.repository.UserRepository;
import ws.synopsis.trainingevaljhonatanarones.service.UserService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.list();
    }

    @Override
    public void save(PostRequest postRequest) {
        User userToSave = User.builder()
                .name(postRequest.getName())
                .lastName(postRequest.getLastName())
                .cellPhone(postRequest.getCellPhone())
                .password(postRequest.getPassword())
                .build();
        this.userRepository.save(userToSave);
    }

    @Override
    public void update(PutRequest putRequest) {
        User userToUpdate = User.builder()
                .id(putRequest.getId())
                .name(putRequest.getName())
                .lastName(putRequest.getLastName())
                .cellPhone(putRequest.getCellPhone())
                .password(putRequest.getPassword())
                .build();
        this.userRepository.update(userToUpdate);
    }

    @Override
    public void remove(Long userId) {
        this.userRepository.remove(userId);
    }
}
