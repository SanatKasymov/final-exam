package kg.attractor.fexam.service;

import kg.attractor.fexam.DTO.PlaceDTO;
import kg.attractor.fexam.model.Place;
import kg.attractor.fexam.model.PlacePhoto;
import kg.attractor.fexam.repository.PlacePhotoRepository;
import kg.attractor.fexam.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {
    PlaceRepository placeRepository;
    PlacePhotoRepository placePhotoRepository;

    public List<PlaceDTO> findAllPLaces() {
        return placeRepository.findAll().stream()
                .map(PlaceDTO::from).collect(Collectors.toList());
    }

    public Integer addNewPlace(String p_name, String p_description, MultipartFile p_image) throws IOException {
        String path ="./src/main/resources/static/images";
        File imageFile = new File(path + "/" + p_image.getOriginalFilename());
        FileOutputStream os = new FileOutputStream(imageFile);
        os.write(p_image.getBytes());
        os.close();

        Place place = Place.builder()
                .name(p_name)
                .description(p_description)
                .image("/images/"+p_image.getOriginalFilename())
                .build();
        placeRepository.save(place);

        return place.getId();
    }

    public Integer addNewImage(MultipartFile p_image, Integer placeId) throws IOException{
        String path ="./src/main/resources/static/images";
        File imageFile = new File(path + "/" + p_image.getOriginalFilename());
        FileOutputStream os = new FileOutputStream(imageFile);
        os.write(p_image.getBytes());
        os.close();

        PlacePhoto placePhoto = PlacePhoto.builder()
                .image("/images/"+p_image.getOriginalFilename())
                .placeId(placeId)
                .build();

        placePhotoRepository.save(placePhoto);

        return placeId;
    }

    public List<Place> searchPlaces(String text, Pageable pageable){

         List<Place> places = placeRepository.findAll();
         List<Place> thisPlaces = new ArrayList<>();
         for(Place place: places){
             if(place.getName().contains(text)){
                 thisPlaces.add(place);
             }else if(place.getDescription().contains(text)){
                 thisPlaces.add(place);
             }
         }
         return thisPlaces;
    }

    public List<PlacePhoto> getThisPlaceImages(Integer placeId){
        return placePhotoRepository.findAllByPlaceId(placeId);
    }
}
