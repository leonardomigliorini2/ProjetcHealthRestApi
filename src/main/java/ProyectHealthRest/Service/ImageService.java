package ProyectHealthRest.Service;

import ProyectHealthRest.Entities.Image;
import ProyectHealthRest.Repository.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public String createImage(MultipartFile request) throws Exception {
        if (request!=null){
            this.Valitations(request);

            Image image=new Image();
            image.setName(request.getName());
            image.setType(request.getContentType());
            image.setContent(request.getBytes());
            this.imageRepository.save(image);
            return "image have been created on data base";

        }else {
            throw new NullPointerException("imagen is null");
        }

    }

@Transactional
public String upDateImage(Long id,MultipartFile request)throws Exception{
    Optional<Image>imageIsPresent=this.imageRepository.findById(id);
    if (imageIsPresent.isPresent()){
        this.Valitations(request);

            Image image=this.imageRepository.getById(id);
            image.setName(request.getName());
            image.setType(request.getContentType());
            image.getContent(request.getBytes());
            this.imageRepository.save(image);
            return "image have been update";

    } else if (id==null) {
        throw new NullPointerException("id is null");
    }else {
        throw new EntityNotFoundException("id is not exist on data base");
    }
}
@Transactional
public String deleteImage(Long id) throws Exception{
        Optional<Image>imageIsPresent=this.imageRepository.findById(id);
        if (imageIsPresent.isPresent()){
            this.imageRepository.deleteById(id);
            return "image have been deleted";
        } else if (id==null) {
            throw new NullPointerException("id is null");
        }else {
            throw new EntityNotFoundException("id is not on data base");
        }

}
public List<Image> imageList(){
        return this.imageRepository.findAll();
}
public void Valitations(MultipartFile request) throws NullPointerException, IllegalArgumentException, IOException {
        if (request.getName()==null){
            throw new NullPointerException("name is null");
        }
        if (request.getName().isEmpty()){
            throw new IllegalArgumentException("name is empty");
        }
        if (request.getContentType()==null){
            throw new NullPointerException("content type is null");
        }
        if (request.getContentType().isEmpty()){
            throw new IllegalArgumentException("content type is empty");
        }
        if (request.getBytes()==null){
            throw new NullPointerException("content is null");

        }
    }
}
