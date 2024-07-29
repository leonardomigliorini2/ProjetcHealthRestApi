package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.Patients;
import ProyectHealthRest.Repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientsRepository patientsRepository;

    @Transactional
    public String createPatient(Patients request) throws Exception {
        validation(request);
        Patients patients = new Patients();
        patients.setName(request.getName());
        patients.setLastName(request.getLastName());
        patients.setAddress(request.getAddress());
        patients.setNote(request.getNote());
        patients.setClinicHistory(request.getClinicHistory());
        patients.setComments(request.getComments());
        patients.setHealthInsurance(request.getHealthInsurance());
        patients.setEmail(request.getEmail());
        patients.setImagen(request.getImagen());
        patients.setNumberPhone(request.getNumberPhone());
        patientsRepository.save(patients);
        return "patient was created succesfull on data base";
    }

    @Transactional
    public String upDatePatient(Long id,Patients request) throws Exception {
        Optional<Patients> IsPresent = patientsRepository.findById(id);
        try {
        if (IsPresent.isPresent()) {

                validation(request);
                Patients patients = patientsRepository.getById(id);
                patients.setName(request.getName());
                patients.setLastName(request.getLastName());
                patients.setAddress(request.getAddress());
                patients.setNote(request.getNote());
                patients.setClinicHistory(request.getClinicHistory());
                patients.setComments(request.getComments());
                patients.setHealthInsurance(request.getHealthInsurance());
                patients.setEmail(request.getEmail());
                patients.setImagen(request.getImagen());
                patients.setNumberPhone(request.getNumberPhone());

                patientsRepository.save(patients);
                return "patients has been updated on data base";}
                else {
                    throw new Exception("the id does not correspond to a patient");
                }
            }catch (MethodArgumentTypeMismatchException e){
                  throw new Exception(e.getMessage());  }

    }
    @Transactional
    public String deletePatient(Long id)throws Exception{
        Optional<Patients>PatientsIsPresent=this.patientsRepository.findById(id);
        if (PatientsIsPresent.isPresent()){
        this.patientsRepository.deleteById(id);
        return "patient has been deleted from data base";
        } else if (id==null) {
            throw new NullPointerException("id is null");
        }else {
            throw new Exception("id is not exist on data base");
        }
    }
    public List<Patients> patientsList(){
        return this.patientsRepository.findAll();
    }
        public void validation (Patients request)throws Exception {
            if (request.getName().isEmpty() || request.getName() == null) {
                throw new Exception("name is empty or is null");
            }
            if (request.getLastName().isEmpty()||request.getLastName()==null){
                throw new Exception("last name is empty or is null");
            }
            if (request.getAddress().isEmpty()||request.getAddress()==null){
                throw new Exception("adress is empty or is null");
            }
            if (request.getEmail().isEmpty()||request.getEmail()==null){
                throw new Exception("email is empty or is null");
            }
            if (request.getClinicHistory().isEmpty()||request.getClinicHistory()==null){
                throw new Exception("clinicHistory is empty or is null");
            }
            if(request.getHealthInsurance().isEmpty()||request.getHealthInsurance()==null){
                throw new Exception("health insurance is empty or is null");
            }
            if (request.getComments()==null){
                throw new Exception("comment is null");
            }
            if ((request.getComments().isEmpty())){
                throw new Exception("comment is empty");
            }
            if (request.getNumberPhone()<=0 ){
                throw new Exception("the numer must be an integer greater than zero");
            }
            if (request.getNumberPhone()==null){
                throw new Exception("the number can not be null");
            }

        }

        }



