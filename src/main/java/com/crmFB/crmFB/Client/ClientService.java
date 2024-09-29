package com.crmFB.crmFB.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Get all clients
     * @return list of clients
     */
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client){
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Email exist");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId){
        boolean exist = clientRepository.existsById(clientId);
        if(!exist){
            throw new IllegalStateException("Client id " + clientId + "does not exist");
        }
        clientRepository.deleteById(clientId);
    }

    public void updateStudent(Long clientId, String name, String email){
        Client client = clientRepository.findById(clientId).orElseThrow(()-> new IllegalStateException(
                "Client with id" + clientId + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(client.getName(), name)){
            client.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(client.getEmail(), email)){
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
            if(clientOptional.isPresent()){
                throw new IllegalStateException("Email exist");
            }
            client.setEmail(email);
        }
    }
}
