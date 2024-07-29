package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.Comment;
import ProyectHealthRest.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceComments {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> commentlist(){
        return this.commentRepository.findAll();
    }
    @Transactional
    public String CreateComment(Comment request)throws Exception{
        Validation(request);
        Comment comment=new Comment();
        comment.setDescription(request.getDescription());
        comment.setNote(request.getNote());
        commentRepository.save(comment);
        return "comment was succesfull saved on data base";
    }
    @Transactional
    public String upDate(Long id,Comment request)throws Exception{
        Validation(request);
        Optional<Comment>IsExist=this.commentRepository.findById(id);
        if (IsExist.isPresent()){
            Comment comment=this.commentRepository.getById(id);
            comment.setDescription(request.getDescription());
            comment.setNote(request.getNote());
            this.commentRepository.save(comment);
            return "comment was updated succesfull on data base";
        }else {
            throw new Exception("comments is not exist on data base");
        }

    }
    @Transactional
    public String deleteComment(Long id )throws Exception{
        Optional<Comment>commentIsPresent=this.commentRepository.findById(id);
        if (commentIsPresent.isPresent()){
        this.commentRepository.deleteById(id);
        return "comment was succesfull deleted on data base";
        } else if (id==null) {throw new NullPointerException("id is null");
        }else {
            throw new Exception("id is not exist on data base");
        }
    }
    public void Validation(Comment request) throws Exception {
        if (request.getDescription().isEmpty()||request.getDescription()==null){
            throw new Exception("description is empty or is null");
        }
        if (request.getNote()==null){
            throw new Exception("note is empty or is null");
        }
        }
}
