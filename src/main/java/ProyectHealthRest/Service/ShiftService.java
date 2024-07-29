package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.Shift;
import ProyectHealthRest.Exception.InvalidShiftException;
import ProyectHealthRest.Exception.ShiftOccupiedException;
import ProyectHealthRest.Repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;
    @Transactional
    public String createShift(Shift request)throws Exception{
    checkIfOccupied(request);
    validation(request);
        Shift shift=new Shift();
        shift.setiShift(request.getiShift());
        shift.setFinishShift(request.getFinishShift());
        shift.setComment(request.getComment());
        shift.setProfessional(request.getProfessional());
        shift.setPatient(request.getPatient());
        shiftRepository.save(shift);
        return "shift have been saved on data base";
    }
    public String upDate(Long id,Shift request)throws Exception{
        Optional<Shift>IsPresent=shiftRepository.findById(id);
        if (IsPresent.isPresent()){
            validation(request);
            Shift shift=shiftRepository.getById(id);
            shift.setiShift(request.getiShift());
            shift.setFinishShift(request.getFinishShift());
            shift.setComment(request.getComment());
            shift.setProfessional(request.getProfessional());
            shift.setPatient(request.getPatient());
            shiftRepository.save(shift);
        }else {
            throw new Exception("id is not exist on data base");
        }
        return "shift have been saved on data base";
    }
    public String deleteShift(Long id) throws Exception {
        Optional<Shift> shiftIsPresent=this.shiftRepository.findById(id);
        if (shiftIsPresent.isPresent()){
            this.shiftRepository.deleteById(id);
            return "shift have been deleted from data base";
        } else if (id==null) {
            throw new NullPointerException("id is null");
        } else {
            throw new Exception("id is not exist on data base");
        }
    }
    public List<Shift> shiftList(){
        return this.shiftRepository.findAll();
    }
    private void validation(Shift request) throws Exception {
        if (request.getiShift()==null){
            throw new InvalidShiftException("shift start can not be null");
        }
        if (request.getFinishShift()==null){
            throw new InvalidShiftException("shift finish can not be null");
        }
        if (request.getFinishShift().before(request.getiShift())){
            throw new Exception("Shift finish time cannot be before start time");
        }
        if (request.getProfessional()==null){
            throw new Exception("professional list can not be empty or null");
        }
        if (request.getPatient()==null){
            throw new Exception("patient can not be null");
        }

    }
    private void checkIfOccupied(Shift request) throws ShiftOccupiedException {
        Calendar Start=request.getiShift();
        Calendar Finish=request.getFinishShift();
        List<Shift> overlappingShifts=shiftRepository.findOverlappingShifts(Start, Finish);
        if (!overlappingShifts.isEmpty()) {
            throw new ShiftOccupiedException("The requested shift time is already occupied");
        }
    }
}
