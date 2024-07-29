package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Note;
import ProyectHealthRest.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerNote {
    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/noteList")
    public List<Note> noteList(){
       return this.noteService.noteList();
    }
    @PostMapping(value = "/createNote")
    public String createNote(@RequestBody Note request)throws Exception{
        this.noteService.createNote(request);
        return "note have been created";
    }
    @PutMapping(value = "/writeNote/{id}")
    public String writeNote(@PathVariable Long id, @RequestBody Note request)throws Exception{
        this.noteService.writeAndUpDateNote(id,request);
        return "note have been written";
    }
    @DeleteMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable Long id){
        this.noteService.deleteNote(id);
        return "note have been deleted";
    }

}
