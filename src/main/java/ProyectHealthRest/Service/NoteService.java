package ProyectHealthRest.Service;


import ProyectHealthRest.Entities.Note;
import ProyectHealthRest.Repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> noteList(){
       return this.noteRepository.findAll();
    }

    @Transactional
    public String createNote(Note request)throws Exception{
        validation(request);
      File nombre=new File(request.getNombre());
      File tipo=new File(request.getTipo());
      try{
          PrintWriter exit=new PrintWriter(nombre);
          PrintWriter exitType=new PrintWriter(tipo);
          exit.close();

      }catch (FileNotFoundException e){
          throw new FileNotFoundException("file haven`t been create, file not found");
      }
    Note note=new Note();
      note.setNombre(nombre.getName());
      note.setTipo(tipo.getName());
      this.noteRepository.save(note);
      return "note have been created on data base";
    }
    @Transactional
    public String writeAndUpDateNote(Long id,Note request)throws Exception{
        Optional<Note>NoteIsPresent=this.noteRepository.findById(id);
        if (NoteIsPresent.isPresent()) {
            validation(request);
            File contenido = new File(request.getContenido());
            try {
                PrintWriter exit=new PrintWriter(contenido);
                exit.close();
            }catch (FileNotFoundException f){
                throw new FileNotFoundException("file isn`t create");
            }catch (IOException i){
                throw new IOException("no data exit");
            }
            Note note=this.noteRepository.getById(id);
            note.setContenido(request.getContenido());
            this.noteRepository.save(note);
            return "note have been saved on data base";
        } else if (id==null) {
            throw new NullPointerException("id is null");
        }else {throw new EntityNotFoundException("note is not exist on data base");}

        }
        @Transactional
        public String deleteNote(Long id){
        Optional<Note>NoteIsPresent=this.noteRepository.findById(id);
        if (NoteIsPresent.isPresent()){
            this.noteRepository.deleteById(id);
            return "note have been deleted on data base";
        } else if (id==null) {throw new NullPointerException("id is null");
        }else {
            throw new EntityNotFoundException("note isn´t exist on data base");
        }
        }

    public void validation(Note request){
        if (request.getNombre().isEmpty()){
            throw new IllegalArgumentException("nombre is empty");
        }
        if (request.getNombre()==null){
            throw new NullPointerException("nombre is null");
        }
        if (request.getTipo().isEmpty()){
            throw new IllegalArgumentException("tipo is empty");
        }
        if (request.getTipo()==null){
            throw new NullPointerException("nombre is null");
        }
        if (request.getContenido().isEmpty()){
            throw new IllegalArgumentException("contenido is empty");
        }
        if (request.getContenido()==null){
            throw new NullPointerException("contenido is null");
        }
    }
}
