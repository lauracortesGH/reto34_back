/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Pavilion
 */

@Entity
@Table(name="message")
@Data
public class Messages implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    //Room
    @ManyToOne
    @JoinColumn(name="room")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Room room;
    //client
    @ManyToOne
    @JoinColumn(name="client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;
    
    
}
