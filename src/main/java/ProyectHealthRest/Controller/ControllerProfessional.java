package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Professional;
import ProyectHealthRest.Service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProfessional {
    @Autowired
    private ProfessionalService professionalService;

    @GetMapping(value = "/professionalList")
    public List<Professional> professionalList(){
       return this.professionalService.professionalList();
    }
    @PostMapping(value = "/creatProfessional")
    public String createProfessional(@RequestBody Professional request)throws Exception{
        this.professionalService.createProfessional(request);
        return "professional has been saved";
    }
    @PutMapping(value = "/upDateProfessional/{id}")
    public String updateProfessional(@PathVariable Long id,@RequestBody Professional request)throws Exception{
        this.professionalService.updateProfessional(id,request);
        return "professional has been updated";
    }
    @DeleteMapping(value = "/deleteProfessional/{id}")
    public String deleteProfessional(@PathVariable Long id) throws Exception{
        this.professionalService.deleteProfessional(id);
        return "professional has been deleted";
    }
}
