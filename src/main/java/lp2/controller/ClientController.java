package lp2.controller;


import lp2.controller.request.ClientRequest;
import lp2.controller.response.ClientResponse;
import lp2.model.entities.Client;
import lp2.model.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ClientResponse post(@RequestBody ClientRequest request){
        var client = request.toClient();
        return new ClientResponse().fromClient(service.create(client));
    }

    @GetMapping
    public Page<ClientResponse> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int linesPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy
    ) {

        var pageable = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);

        return service.getAll(pageable)
                .map(p -> new ClientResponse().fromClient(p));
    }

    @GetMapping("{id}")
    public Client getById(@PathVariable String id){
        return service.getById(id);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){service.delete(id);}


}
