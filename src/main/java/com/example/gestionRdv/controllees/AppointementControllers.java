package com.example.gestionRdv.controllees;

import com.example.gestionRdv.entities.Appointment;
import com.example.gestionRdv.repositories.AppointmnetRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("*")
@RestController

@RequestMapping("/appointements")
public class AppointementControllers {

    @Autowired
    AppointmnetRepositorie appointmnetRepositorie;

    @GetMapping("/findAll")
    public List<Appointment> fetchAll() {
        return appointmnetRepositorie.findAll( Sort.by("date").ascending());

    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        if(this.appointmnetRepositorie.findById(id).isPresent()) {

            return new ResponseEntity<>(this.appointmnetRepositorie.findById(id),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment) {
       // if(!this.appointmnetRepositorie.findAppointmentByDate(appointment.getDate())) {
            return new ResponseEntity<>(this.appointmnetRepositorie.save(appointment), HttpStatus.CREATED);

        //}else {
           // return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      //  }




    }






    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Integer id) {
       if(this.appointmnetRepositorie.findById(id).isPresent()){

           this.appointmnetRepositorie.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
    }else{
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);


       }
   }
   
   @PutMapping("update/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Integer id,@RequestBody Appointment appointment){
        if(this.appointmnetRepositorie.findById(id).isPresent()){
            appointment.setId(id);
            return new ResponseEntity<>(this.appointmnetRepositorie.save(appointment),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }




}
