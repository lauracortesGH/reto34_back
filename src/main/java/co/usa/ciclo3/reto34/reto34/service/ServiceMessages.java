/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Messages;
import co.usa.ciclo3.reto34.reto34.repository.MessagesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceMessages {
    @Autowired
    private MessagesRepository messagesService;
	
    public List<Messages> getAll(){
	return messagesService.getAll();
    }
    public Optional<Messages> getMessage(int idMessage) {
	return messagesService.getMessage(idMessage);
    }
	
    public Messages save(Messages messages){
	if(messages.getIdMessage()==null){
	    return messagesService.save(messages);
	}else{
	    Optional<Messages> messagesAux=messagesService.getMessage(messages.getIdMessage());
	    if(messagesAux.isEmpty()){
	        return messagesService.save(messages);
	    }else{
	        return messages;
                 }
            }
    }
	
    public Messages update(Messages messages){
        if(messages.getIdMessage()!=null){
            Optional<Messages> messagesAux= messagesService.getMessage(messages.getIdMessage());
            if(!messagesAux.isEmpty()){
                if(messages.getMessageText()!=null){
                    messagesAux.get().setMessageText(messages.getMessageText());    
                }
                messagesService.save(messagesAux.get());
                return messagesAux.get();
            }else{
                return messages;
            }
        }else{
            return messages;
        }
    }

    public boolean delete(int idMessage) {
        Boolean aBoolean = getMessage(idMessage).map(messages -> {
            messagesService.delete(messages);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
