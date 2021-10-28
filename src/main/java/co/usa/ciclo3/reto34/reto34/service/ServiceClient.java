/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Client;
import co.usa.ciclo3.reto34.reto34.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceClient {
    @Autowired
    private ClientRepository clientService;
	
    public List<Client> getAll(){
	return clientService.getAll();
    }
	
    public Optional<Client> getClient(int idClient) {
	return clientService.getClient(idClient);
    }
	
    public Client save(Client client){
	if(client.getIdClient()==null){
	    return clientService.save(client);
	}else{
	    Optional<Client> clientAux=clientService.getClient(client.getIdClient());
	    if(clientAux.isEmpty()){
	        return clientService.save(client);
	    }else{
	        return client;
                 }
            }
    }
	
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientAux= clientService.getClient(client.getIdClient());
            if(!clientAux.isEmpty()){
                if(client.getEmail()!=null){
                    clientAux.get().setEmail(client.getEmail());     
                }
                if(client.getPassword()!=null){
                    clientAux.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    clientAux.get().setName(client.getName());       
                }
                if(client.getAge()!=null){
                    clientAux.get().setAge(client.getAge());
                }
                clientService.save(clientAux.get());
                return clientAux.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int idClient) {
        Boolean aBoolean = getClient(idClient).map(client -> {
            clientService.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
