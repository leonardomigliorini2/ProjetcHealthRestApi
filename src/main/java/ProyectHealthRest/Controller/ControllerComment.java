package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Comment;
import ProyectHealthRest.Service.ServiceComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerComment {
    @Autowired
    private ServiceComments serviceComments;

    @GetMapping(value = "/commentsList")
    public List<Comment> listaComment(){
    return serviceComments.commentlist();
    }
    @PostMapping(value = "/createComment")
    public String CreateComments(@RequestBody Comment request)throws Exception{
        this.serviceComments.CreateComment(request);
        return "comment was created";
    }
    @PutMapping(value = "/updateComment/{id}")
    public String upDateComments(@PathVariable Long id,@RequestBody Comment request)throws Exception{
        this.serviceComments.upDate(id,request);
        return "comment was updated";
    }
    @DeleteMapping(value="/deleteComment/{id}")
    public String delete(@PathVariable Long id)throws Exception{
        this.serviceComments.deleteComment(id);
        return "comment was deleted";
    }



}
