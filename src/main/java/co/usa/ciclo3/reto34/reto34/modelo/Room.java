/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//MODELO ROOM
package co.usa.ciclo3.reto34.reto34.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Pavilion
 */

@Entity
@Table(name="room")
@Data
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String hotel;
    private Integer stars;
    private String description;
    //category
    
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("rooms")
    private Category category;
    //messages
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Messages>messages;
    //Reservation
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room" )
    @JsonIgnoreProperties({"room", "client","score"})
    private List<Reservation>reservations;
    
}
