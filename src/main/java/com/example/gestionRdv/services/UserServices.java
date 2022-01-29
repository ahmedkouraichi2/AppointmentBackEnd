package com.example.gestionRdv.services;

import com.example.gestionRdv.entities.User;
import com.example.gestionRdv.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServices {
    @Autowired
    UserRepositories repositories;

    public List<User> getAll(){
         System.out.println("getAll");
          return repositories.findAll(Sort.by("username"));
    }
     public Optional<User>findByUsername(String name){
        return  repositories.findByUsername(name);
     }

     public List<User>findByRole(String role){
         return repositories.retrieveUsersByRole(role) ;
     }




    public Optional<User> findById(long id){
        return repositories.findById(id);
    }

    public long save(User User){
        System.out.println("save all user");
           User user = new User();
          user.setUsername(User.getUsername());
          user.setEmail(User.getEmail());
          user.setPassword(User.getPassword());
          user.setRole(User.getRole());
          user.setActive(user.isActive());

          return repositories.save(user).getId();
    }

    public void update(long id,User User){
        Optional<User> userr = repositories.findById(id);
         if(userr.isPresent()){
             User user = userr.get();
             user.setUsername(User.getUsername());
             user.setEmail(User.getEmail());
             user.setPassword(User.getPassword());
             user.setRole((User.getRole()));
             user.setActive((User.isActive()));
             user.setActive(User.isActive());
             repositories.save(user);

         }

    }
    public Optional<User> login(String name){
        return repositories.findByUsername(name);
    }
    public void delete(Long id){
        Optional<User> user = repositories.findById(id);
        user.ifPresent(repositories::delete);
    }


}
