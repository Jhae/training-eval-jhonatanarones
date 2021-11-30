package ws.synopsis.trainingevaljhonatanarones.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PostRequest;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PutRequest;
import ws.synopsis.trainingevaljhonatanarones.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> list(){
        return  ResponseEntity.ok(userService.list());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody PostRequest postRequest){
        userService.save(postRequest);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody PutRequest putRequest){
        putRequest.setId(Long.parseLong(userId));
        userService.update(putRequest);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId){
        userService.remove(Long.parseLong(userId));
        return ResponseEntity.ok().build();
    }

}
