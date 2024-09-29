package com.crmFB.crmFB.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Client")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public List<Client> getClient(){
        return clientService.getAllClients();
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
         clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("cliendId")Long clientId,
            @PathVariable(required = false) String name,
            @PathVariable(required = false) String email){
        clientService.updateStudent(clientId, name, email);
    }



}
