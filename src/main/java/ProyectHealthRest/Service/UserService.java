package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.User;

import ProyectHealthRest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    protected UserRepository userRepository;

    @Transactional
    public String CreateUser(User request) throws Exception {
        System.out.println("UserName: "+request.getUserName()+" address: "+request.getAddress()
                +" email: "+request.getEmail()+" address: "+request.getAddress()+
                " comments: "+request.getComents()+" Image: "+request.getImage());
        validation(request);
        User user=new User();
        user.setUserName(request.getUserName());
        user.setAddress(request.getAddress());
        user.setComents(request.getComents());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setContact(request.getContact());
        user.setImage(request.getImage());
        userRepository.save(user);
        return "user has been saved on Data Base";
    }
    @Transactional
    public String updateUser(Long id,User request) throws Exception {
        Optional<User>IsPresent=userRepository.findById(id);
        if (IsPresent.isPresent()){
           User user=userRepository.getById(id);
            user.setUserName(request.getUserName());
            user.setAddress(request.getAddress());
            user.setComents(request.getComents());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setContact(request.getContact());
            user.setImage(request.getImage());
            userRepository.save(user);
            return "Update successfull";
        }else{throw new Exception("id is not exist on the data base");

        }}

    public List<User> userList(){
        return this.userRepository.findAll();
    }
    @Transactional
    public String deleteById(Long id)throws Exception{
        Optional<User>userIsPresent=this.userRepository.findById(id);
        if (userIsPresent.isPresent()) {
            this.userRepository.deleteById(id);
            return "user has been delete";
        } else if (id==null) {
            throw new NullPointerException("id is null");
        }else {
            throw new Exception("id is not exist on data base");
        }
    }

    public void validation(User request) throws Exception {
        if (request.getUserName().isEmpty()||request.getUserName()==null){
            throw new Exception("user name is empty or it is null");
        }
        if (request.getAddress().isEmpty()||request.getAddress()==null){
            throw new Exception("adress is empty or it is null");
        }
        if (request.getComents().isEmpty()||request.getComents()==null){
            throw new Exception("comment is empty or it is null");
        }
        if (request.getContact().isEmpty()||request.getContact()==null){
            throw new Exception("Contact is empty or it is null");
        }
        if (request.getEmail().isEmpty()||request.getEmail()==null){
            throw new Exception("email is empty ot it is null");
        }
        if (request.getPassword().isEmpty()|| request.getPassword()==null){
            throw new Exception("password is empty or it is null");
        }
    }

}
