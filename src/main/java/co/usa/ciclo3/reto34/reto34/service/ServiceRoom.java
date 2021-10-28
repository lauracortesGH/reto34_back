/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Room;
import co.usa.ciclo3.reto34.reto34.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceRoom {
    @Autowired
    private RoomRepository roomService;
	
    public List<Room> getAll(){
	return roomService.getAll();
    }
	
    public Optional<Room> getRoom(int id) {
	return roomService.getRoom(id);
    }
	
    public Room save(Room room){
	if(room.getId()==null){
	    return roomService.save(room);
	}else{
	    Optional<Room> roomAux=roomService.getRoom(room.getId());
	    if(roomAux.isEmpty()){
	        return roomService.save(room);
	    }else{
	        return room;
                 }
            }
    }
	
    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> roomAux= roomService.getRoom(room.getId());
            if(!roomAux.isEmpty()){
                if(room.getName()!=null){
                    roomAux.get().setName(room.getName());     
                }
                if(room.getHotel()!=null){
                    roomAux.get().setHotel(room.getHotel());    
                }
                if(room.getStars()!=null){
                    roomAux.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    roomAux.get().setDescription(room.getDescription());
                }
                roomService.save(roomAux.get());
                return roomAux.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getRoom(id).map(room -> {
            roomService.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
