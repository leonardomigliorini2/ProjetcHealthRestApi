package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.Professional;
import ProyectHealthRest.Repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @Transactional
    public String createProfessional(Professional request)throws Exception{
       validation(request);
        Professional professional=new Professional();
        professional.setName(request.getName());
        professional.setLastName(request.getLastName());
        professional.setPatients(request.getPatients());
        professional.setConsultationPrice(request.getConsultationPrice());
        professional.setSpecialty(request.getSpecialty());
        professional.setFile(request.getFile());
        professional.setImage(request.getImage());
        professionalRepository.save(professional);
        return "the professional has been create on data base";
    }

    @Transactional
    public String updateProfessional(Long id,Professional request) throws Exception {
        Optional<Professional>IsPresent=this.professionalRepository.findById(id);
        if (IsPresent.isPresent()){
            Professional professional=this.professionalRepository.getById(id);
            professional.setName(request.getName());
            professional.setLastName(request.getLastName());
            professional.setPatients(request.getPatients());
            professional.setConsultationPrice(request.getConsultationPrice());
            professional.setSpecialty(request.getSpecialty());
            professional.setImage(request.getImage());
            professional.setFile(request.getFile());
            professionalRepository.save(professional);
            return "the changes were saved on data base";
        }else {throw new Exception("id is not exist");}
    }

    public List<Professional>professionalList(){
        return this.professionalRepository.findAll();
    }
    @Transactional
    public String deleteProfessional(Long id)throws Exception{
       Optional<Professional>professionalIsPresent=this.professionalRepository.findById(id);
       if (professionalIsPresent.isPresent()){
        this.professionalRepository.deleteById(id);
        return "the professional has been deleted";
       } else if (id==null) {
           throw new NullPointerException("id is null");
       }else {
           throw new Exception("id is not exist on data base");
       }
    }
    public void validation(Professional request) throws Exception {
        if (request.getName().isEmpty()||request.getName()==null){
            throw new Exception("name is empty or is null");
        }
        if (request.getLastName().isEmpty()||request.getLastName()==null){
            throw new Exception("last name is empty or is null");
        }
        if (request.getPatients().isEmpty()||request.getPatients()==null){
            throw new Exception("patient is empty or is null");
        }
        if (request.getSpecialty().isEmpty()||request.getSpecialty()==null){
            throw new Exception("specialty is empty or is null");
        }
        if (request.getConsultationPrice().isNaN()||request.getConsultationPrice().isInfinite()|| request.getConsultationPrice()==null){
            throw new Exception("value is not a number, or is infinite, or is null");
        }

    }
}
