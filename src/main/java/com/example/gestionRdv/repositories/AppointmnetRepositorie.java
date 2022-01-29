package com.example.gestionRdv.repositories;

import com.example.gestionRdv.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AppointmnetRepositorie  extends JpaRepository<Appointment,Integer> {


  boolean findAppointmentByDate(Date date );
}
