package lp2.model.services;

import lp2.model.entities.Client;
import lp2.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    
    public Client create(Client client){

        if(repository.existsByName(client.getName())){
            throw new RuntimeException("Name já existe");
        }
        return repository.save(client);
    }
        

    public Client update(String id, Client client){
        var clientDataBase = this.getById(id);

        var p = repository.findByName(client.getName());

            if(p != null && !p.getId().equals(id)){
                throw new RuntimeException("Nome já existe");
            }

            clientDataBase.setName(client.getName());
            clientDataBase.setName(client.getEmail());
            clientDataBase.setName(client.getPassword());

            return repository.save(clientDataBase);
    }

    public Page<Client> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public Client getById(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Client não existe"));
    }

    public void delete(String id){

        repository.deleteById(id);
    }
}
