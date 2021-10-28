/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.repository;

import co.usa.ciclo3.reto34.reto34.crud.CategoryCrudRepository;
import co.usa.ciclo3.reto34.reto34.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pavilion
 * 
 */
@Repository
public class CategoryRepository {
    @Autowired
    // Inyectar dependencias
    //Crear instancia
    private CategoryCrudRepository categoryCrudRepository;
    //Crear primer metodo
    //GET
    public List<Category> getall(){
        return(List<Category>) categoryCrudRepository.findAll();
    }
    //GETID
    public Optional<Category> getCategory(Integer id){
        return categoryCrudRepository.findById(id);
    }
    //POST
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
    
}
