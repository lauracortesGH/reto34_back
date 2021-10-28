/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Category;
import co.usa.ciclo3.reto34.reto34.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */

 
@Service
public class ServicesCategory {
    /**
 *
    @Autowired
    //Crear instancia del repository
    private CategoryRepository categoryService;
    //GET
    public List<Category> getall(){
        return categoryService.getall();
    }
    //GETID
    public Optional<Category> getCategory(Integer id){
        return categoryService.getCategory(id);
    }
    //POST
    public Category save(Category category){
        //si id es vacio
        if(category.getId()== null){
            //entonces guardelo
            return categoryService.save(category);
        }else{
            //sino cree auxiliar y guardar el id que tiene
            Optional<Category> categoryAux = categoryService.getCategory(category.getId());
            if(categoryAux.isEmpty()){
                //guarde la category
                return categoryService.save(category);
            }else{
                //devuelva la categoria
                return category;
            }
        }
    }
    * * @author Pavilion
 */
    @Autowired
    private CategoryRepository categoryRepository;
	
    public List<Category> getall(){
	return categoryRepository.getall();
    }
	
    public Optional<Category> getCategory(int id) {
	return categoryRepository.getCategory(id);
    }
	
    public Category save(Category category){
	if(category.getId()==null){
	    return categoryRepository.save(category);
	}else{
	    Optional<Category> categoryAux=categoryRepository.getCategory(category.getId());
	    if(categoryAux.isEmpty()){
	        return categoryRepository.save(category);
	    }else{
	        return category;
                 }
            }
    }
	
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> categoryAux= categoryRepository.getCategory(category.getId());
            if(!categoryAux.isEmpty()){
                if(category.getName()!=null){
                    categoryAux.get().setName(category.getName());     
                }
                if(category.getDescription()!=null){
                    categoryAux.get().setDescription(category.getDescription());
                }
                categoryRepository.save(categoryAux.get());
                return categoryAux.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
/**
    public List<Category> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    *  */
}

