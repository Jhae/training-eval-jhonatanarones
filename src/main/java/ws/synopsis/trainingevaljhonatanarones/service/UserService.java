package ws.synopsis.trainingevaljhonatanarones.service;

import ws.synopsis.trainingevaljhonatanarones.bean.request.PostRequest;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PutRequest;
import ws.synopsis.trainingevaljhonatanarones.model.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public void save(PostRequest postRequest);
    public void update(PutRequest putRequest);
    public void remove(Long userId);
}
