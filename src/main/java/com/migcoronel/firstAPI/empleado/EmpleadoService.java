package com.migcoronel.firstAPI.empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    public void addNewEmpleado(Empleado empleado) {
    if (empleadoRepository.existsById(empleado.getDni())) throw new IllegalStateException("DNI Registrado previamente");
    empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Integer empleadoDni) {
        if (!(empleadoRepository.existsById(empleadoDni))) throw new IllegalStateException("El Empleado con el DNI: "+empleadoDni+", no existe!");
        empleadoRepository.deleteById(empleadoDni);
    }

    @Transactional
    public void updateEmpleado(Integer empleadoDni,
                               String nombre,
                               String apellido,
                               String fdn,
                               String sexo,
                               Integer salario,
                               Integer dni_supervisor) {
        Empleado empleado = empleadoRepository.findById(empleadoDni)
                .orElseThrow(() -> new IllegalStateException("No existe ningun Empleado con ese DNI"));

        if(nombre != null && nombre.length()>0 && !Objects.equals(empleado.getNombre(),nombre)){
            empleado.setNombre(nombre);
        }

        if(apellido != null && apellido.length()>0 && !Objects.equals(empleado.getApellido(),apellido)){
            empleado.setApellido(apellido);
        }

        if(fdn != null && !fdn.equals("") && !Objects.equals(fdn,empleado.getFdn().toString())){
            empleado.setFdn(LocalDate.parse(fdn));
        }

        if(sexo != null && sexo.length()==1 && !Objects.equals(empleado.getSexo(),sexo)){
            empleado.setSexo(sexo);
        }

        if(salario != null && salario>0 && !Objects.equals(empleado.getSalario(),salario)){
            empleado.setSalario(salario);
        }

        if(dni_supervisor!=null && !Objects.equals(empleado.getDni_supervisor(),dni_supervisor)){
            empleado.setDni_supervisor(dni_supervisor);
        }
    }
}
