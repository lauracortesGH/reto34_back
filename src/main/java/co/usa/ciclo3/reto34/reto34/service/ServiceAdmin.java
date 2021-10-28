/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Admin;
import co.usa.ciclo3.reto34.reto34.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceAdmin {
    @Autowired
    private AdminRepository adminService;
	
    public List<Admin> getAll(){
	return adminService.getAll();
    }
	
    public Optional<Admin> getAdmin(int id) {
	return adminService.getAdmin(id);
    }
	
    public Admin save(Admin admin){
	if(admin.getId()==null){
	    return adminService.save(admin);
	}else{
	    Optional<Admin> adminAux=adminService.getAdmin(admin.getId());
	    if(adminAux.isEmpty()){
	        return adminService.save(admin);
	    }else{
	        return admin;
                 }
            }
    }
	
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> adminAux= adminService.getAdmin(admin.getId());
            if(!adminAux.isEmpty()){
                if(admin.getName()!=null){
                    adminAux.get().setName(admin.getName());   
                }
                if(admin.getEmail()!=null){
                    adminAux.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    adminAux.get().setPassword(admin.getPassword());
                }
                adminService.save(adminAux.get());
                return adminAux.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getAdmin(id).map(admin -> {
            adminService.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
