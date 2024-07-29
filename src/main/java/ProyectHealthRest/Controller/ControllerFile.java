package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.File;
import ProyectHealthRest.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ControllerFile {
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/fileList")
    public List<File> fileList(){
        return this.fileService.fileList();
    }
    @PostMapping(value = "/createFile")
    public String creatFile(@RequestParam("File") MultipartFile request)throws Exception{
        this.fileService.creatFile(request);
        return "file have been created";
    }
    @PutMapping(value = "/upDateFile/{id}")
    public String upDateMapping(@PathVariable Long id, @RequestParam("File") MultipartFile request)throws Exception{
        this.fileService.upDateFile(request, id);
        return "file have been upDate";
    }
    @DeleteMapping(value = "/deleteFile/{id}")
    public String deleteFile(@PathVariable Long id)throws Exception{
        this.fileService.deleteFile(id);
        return "id have been deleted";
    }
}
