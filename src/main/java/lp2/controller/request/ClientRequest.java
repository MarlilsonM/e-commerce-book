package lp2.controller.request;

import lp2.model.entities.Client;
import lombok.Setter;

@Setter
public class ClientRequest {

    private String name;
    private String email;
    private String password;

    public Client toClient() {

        var client = new Client();

        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);

        return client;

    }

}
