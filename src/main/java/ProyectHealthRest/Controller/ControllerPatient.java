package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Patients;
import ProyectHealthRest.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPatient {
    @Autowired
    private PatientService patientService;
    @GetMapping(value = "/patientsList")
    public List<Patients>patientsList(){
         return this.patientService.patientsList();
    }

    @PostMapping(value ="/createPatient")
    public String createPatient(@RequestBody Patients request)throws Exception{
        this.patientService.createPatient(request);
        return "patient has been created";
    }
   @PutMapping(value = "/upDatePatient/{id}")
    public String upDatePatient(@PathVariable Long id, @RequestBody Patients request)throws Exception{
        this.patientService.upDatePatient(id, request);
        return "the patient has been updated";
    }
    @DeleteMapping(value = "/deletePatient/{id}")
    public String delete(@PathVariable Long id)throws Exception{
        this.patientService.deletePatient(id);
        return "the patient has been deleted";
    }
}
