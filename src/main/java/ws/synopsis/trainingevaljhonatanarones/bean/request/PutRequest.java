package ws.synopsis.trainingevaljhonatanarones.bean.request;

import lombok.Data;

@Data
public class PutRequest {
    private Long id;
    private String name;
    private String lastName;
    private String cellPhone;
    private String password;
}
