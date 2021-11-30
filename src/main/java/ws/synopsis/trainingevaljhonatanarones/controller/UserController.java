package ws.synopsis.trainingevaljhonatanarones.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PostRequest;
import ws.synopsis.trainingevaljhonatanarones.bean.request.PutRequest;
import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.DuplicatedCellPhoneException;
import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.InvalidFieldException;
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
    public ResponseEntity<?> add(@RequestBody PostRequest postRequest) throws InvalidFieldException, DuplicatedCellPhoneException {
        if (StringUtils.isBlank(postRequest.getName())){
            throw new InvalidFieldException("El nombre no puede estar vac\u00EDo");
        }
        if (StringUtils.isBlank(postRequest.getLastName())){
            throw new InvalidFieldException("Los apellidos no pueden estar vac\u00EDos");
        }
        if (StringUtils.isBlank(postRequest.getPassword())){
            throw new InvalidFieldException("La contrase\u00F1a no puede vac\u00EDa");
        }

        userService.save(postRequest);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody PutRequest putRequest) throws InvalidFieldException {
        if (StringUtils.isBlank(putRequest.getName())){
            throw new InvalidFieldException("El nombre no puede estar vac\u00EDo");
        }
        if (StringUtils.isBlank(putRequest.getLastName())){
            throw new InvalidFieldException("Los apellidos no pueden estar vac\u00EDos");
        }
        if (StringUtils.isBlank(putRequest.getPassword())){
            throw new InvalidFieldException("La contrase\u00F1a no puede vac\u00EDa");
        }

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
