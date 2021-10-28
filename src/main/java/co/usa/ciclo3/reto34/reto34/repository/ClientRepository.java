/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.repository;

import co.usa.ciclo3.reto34.reto34.crud.ClientCrudRepository;
import co.usa.ciclo3.reto34.reto34.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pavilion
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<Client> getAll(){
        return(List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(Integer idClient){
        return clientCrudRepository.findById(idClient);
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
}
