package com.migcoronel.firstAPI.empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado , Integer> {

}
