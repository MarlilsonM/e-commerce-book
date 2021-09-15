package lp2.model.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    
    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enable=true;
}
