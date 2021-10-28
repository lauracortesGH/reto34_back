/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.repository;

import co.usa.ciclo3.reto34.reto34.crud.MessagesCrudRepository;
import co.usa.ciclo3.reto34.reto34.modelo.Messages;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pavilion
 */
@Repository
public class MessagesRepository {
    @Autowired
    private MessagesCrudRepository messagesCrudRepository;
    public List<Messages> getAll(){
        return(List<Messages>) messagesCrudRepository.findAll();
    }
    public Optional<Messages> getMessage(Integer idMessage){
        return messagesCrudRepository.findById(idMessage);
    }
    public Messages save(Messages messages){
        return messagesCrudRepository.save(messages);
    }
    public void delete(Messages messages){
        messagesCrudRepository.delete(messages);
    }
    
}
