package kg.attractor.fexam.service;

import kg.attractor.fexam.DTO.PlaceDTO;
import kg.attractor.fexam.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {
    PlaceRepository placeRepository;

    public List<PlaceDTO> findAllPLaces() {
        return placeRepository.findAll().stream()
                .map(PlaceDTO::from).collect(Collectors.toList());
    }
}
