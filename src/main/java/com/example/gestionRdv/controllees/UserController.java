package com.example.gestionRdv.controllees;

import com.example.gestionRdv.entities.User;
import com.example.gestionRdv.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/usersAll")
     public List<User> list(){
        return  userServices.getAll();


    }
    @GetMapping("Users/{id}")
    public ResponseEntity<User> find(@PathVariable long id){
        Optional<User> cat = userServices.findById(id);
        return cat.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }
    @GetMapping("roles/{role}")
      public ResponseEntity<User>findByRole(@PathVariable String role){
        return (ResponseEntity<User>) userServices.findByRole(role);
    }

    @GetMapping("Users/7/{name}")
    public ResponseEntity<User> login(@PathVariable String name){
        Optional<User> cat = userServices.findByUsername(name);
        return cat.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }

    @PostMapping("/save")
    public Long save (@RequestBody User user){
         return this.userServices.save((user));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        userServices.delete(id);



    }






}
