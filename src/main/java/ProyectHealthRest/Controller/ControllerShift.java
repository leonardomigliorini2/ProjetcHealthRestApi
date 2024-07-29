package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Shift;
import ProyectHealthRest.Service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ControllerShift {

    @Autowired
    private ShiftService shiftService;

    @GetMapping(value = "/shiftService")
    public List<Shift> shiftList(){
        return this.shiftService.shiftList();
    }
    @PostMapping("/createShift")
    public String createShift(@RequestBody Shift request)throws Exception{
        this.shiftService.createShift(request);
        return "shift was created succesfull";
    }
    @PutMapping("/upDateShift/{id}")
    public String upDateShift(@PathVariable Long id,@RequestBody Shift request )throws Exception{
        this.shiftService.upDate(id, request);
        return "shift have been updated sucessfull";
    }
    @DeleteMapping(value = "/deleteShift/{id}")
    public String deleteShift(@PathVariable Long id)throws Exception{
        this.shiftService.deleteShift(id);
        return "shift have been deleted succesfull";
    }
}
