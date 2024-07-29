package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.Image;
import ProyectHealthRest.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ControllerImage {

    @Autowired
    private ImageService imageService;
    @GetMapping(value = "/imageList")
    public List<Image> imageList(){
        return this.imageService.imageList();
    }
    @PostMapping(value = "/createImage")
    public String createImage(@RequestParam("Image") MultipartFile request)throws Exception{
        this.imageService.createImage(request);
        return "image have beeen created succesfull";
    }
    @PutMapping(value = "/upDateImage/{id}")
    public String upDateImage(@PathVariable Long id,@RequestParam("Image") MultipartFile request)throws Exception{
        this.imageService.upDateImage(id, request);
        return "image have been update succesfull";
    }
    @DeleteMapping(value = "/deleteImage/{id}")
    public String delete(@PathVariable Long id)throws Exception{
        this.imageService.deleteImage(id);
        return "image have been deleted succesfull";
    }
}
