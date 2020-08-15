package kg.attractor.fexam.repository;

import kg.attractor.fexam.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Page<Place> findAll(Pageable pageable);
}
