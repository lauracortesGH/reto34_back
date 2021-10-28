/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.repository;

import co.usa.ciclo3.reto34.reto34.crud.RoomCrudRepository;
import co.usa.ciclo3.reto34.reto34.modelo.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pavilion
 */
@Repository
public class RoomRepository {
    @Autowired
    private RoomCrudRepository roomCrudRepository;
    public List<Room> getAll(){
        return(List<Room>) roomCrudRepository.findAll();
    }
    public Optional<Room> getRoom(Integer id){
        return roomCrudRepository.findById(id);
    }
    public Room save(Room room){
        return roomCrudRepository.save(room);
    }
    public void delete(Room room){
        roomCrudRepository.delete(room);
    }
}
