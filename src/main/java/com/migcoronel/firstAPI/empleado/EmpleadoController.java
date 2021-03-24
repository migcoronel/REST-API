package com.migcoronel.firstAPI.empleado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {


    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @GetMapping
    public List<Empleado> getEmpleados(){
        return empleadoService.getEmpleados();
    }

    @PostMapping
    public void registerNewEmpleado (@RequestBody Empleado empleado){
        empleadoService.addNewEmpleado(empleado);
    }

    @DeleteMapping(path = "{empleadoDni}")
    public void deleteEmpleado(@PathVariable("empleadoDni") Integer empleadoDni){
        empleadoService.deleteEmpleado(empleadoDni);
    }

    @PutMapping(path = "{empleadoDni}")
    public void updateEmpleado(@PathVariable ("empleadoDni") Integer empleadoDni,
                               @RequestParam (required = false) String nombre,
                               @RequestParam (required = false) String apellido,
                               @RequestParam (required = false) String fdn,
                               @RequestParam (required = false) String sexo,
                               @RequestParam (required = false) Integer salario,
                               @RequestParam (required = false) Integer dni_supervisor
                               ){
        empleadoService.updateEmpleado(empleadoDni,nombre,apellido,fdn,sexo,salario,dni_supervisor);
    }

}
