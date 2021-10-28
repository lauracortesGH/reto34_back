/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.controller;

import co.usa.ciclo3.reto34.reto34.modelo.Category;
import co.usa.ciclo3.reto34.reto34.service.ServicesCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pavilion
 */
@RestController
@RequestMapping("/api/Category")
//Evitar el error de curs del simbolo
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerCategory {
    /**
    @Autowired
    private ServicesCategory servicesCategory;
    //Primer metodo
    @GetMapping("/all")
    //GET
    public List<Category> getall(){
        return(List<Category>) servicesCategory.getall();
    }
    @GetMapping("{id}")
    //GETID - el path variable maneja las peticiones
    public Optional<Category> getCategory(@PathVariable("id") Integer id){
        return servicesCategory.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //POST - Request bva a trnasformar el JSON en un objeto
    public Category save(@RequestBody Category category){
        return servicesCategory.save(category);
    }
    */
    @Autowired
    private ServicesCategory categoryService;
    @GetMapping("/all")
    public List<Category> getCategorys(){
        return categoryService.getall();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return categoryService.delete(id);
    } 
}
