package com.migcoronel.firstAPI.empleado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class EmpleadoConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmpleadoRepository empleadoRepository){
        return args -> {
            System.out.println("RUNNING CONFIGURATION FILES");
            Empleado jose = new Empleado(
                    12123123,
                    "ramon",
                    "jose",
                    LocalDate.of(2000, Month.OCTOBER, 2),
                    "F",
                    123123,
                    95000123
            );

            Empleado alex = new Empleado(
                    12000987,
                    "alex",
                    "paredes",
                    LocalDate.of(1999, Month.NOVEMBER, 2),
                    "M",
                    123123,
                    95000123
            );

//           empleadoRepository.saveAll(List.of(jose,alex)
//            );
        };
    }
}
