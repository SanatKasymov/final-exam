package kg.attractor.fexam.repository;

import kg.attractor.fexam.model.PlacePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacePhotoRepository extends JpaRepository<PlacePhoto, Integer> {
    List<PlacePhoto> findAllByPlaceId(Integer placeId);
}
