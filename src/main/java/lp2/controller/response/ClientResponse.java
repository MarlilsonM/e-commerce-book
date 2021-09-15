package lp2.controller.response;

import lombok.Getter;
import lp2.model.entities.Client;

@Getter
public class ClientResponse {
    
    private String id;
    private String name;
    private String email;

    public ClientResponse fromClient(Client client){

        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        return this;
    }
}
