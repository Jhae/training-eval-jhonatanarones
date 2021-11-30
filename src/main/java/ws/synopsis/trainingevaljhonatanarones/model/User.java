package ws.synopsis.trainingevaljhonatanarones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long   id;
    private String name;
    private String lastName;
    private String cellPhone;
    private String password;
}
