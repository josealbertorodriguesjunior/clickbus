package tech.juniorlima.clickbus.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.juniorlima.clickbus.exception.NotFoundException;
import tech.juniorlima.clickbus.model.PlaceModel;
import tech.juniorlima.clickbus.repository.PlaceRepository;

@RestController
@RequestMapping("/api")
public class PlaceController {

  private final PlaceRepository placeRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public PlaceController(PlaceRepository placeRepository) {
    this.placeRepository = placeRepository;
  }

  @GetMapping("/places")
  public List<PlaceModel> getAllPlaces(){
    logger.info("Getting all places...");
    return placeRepository.findAll();
  }

  @PostMapping("/create/place")
  public PlaceModel createPlace(@Valid @RequestBody final PlaceModel place){
    logger.info("Creating a new place with name {}...",place.getName());
    return placeRepository.save(place);
  }

  @GetMapping("/place/{name}")
  public List<PlaceModel> getPlacesFilteredByName(
      @PathVariable(value = "name") final String name){
    logger.info("Starting getPlacesByName process...");
    Optional<List<PlaceModel>> places = placeRepository.findByNameIgnoreCase(name);
    logger.info("Finishing getPlacesByName process...");
    return places
        .orElseThrow(() -> new NotFoundException("Place", "name" , name));
  }

  @PutMapping("/update/place/{id}")
  public PlaceModel updatePlace(
      @PathVariable(value = "id") final Long id,
      @Valid @RequestBody final PlaceModel placeDetails){
    logger.info("Starting update process for place with ID {}...",id);
    PlaceModel place = placeRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Place", "name", id));
    place.setName(placeDetails.getName());
    place.setSlug(placeDetails.getSlug());
    place.setCity(placeDetails.getCity());
    place.setState(placeDetails.getState());

    final PlaceModel save = placeRepository.save(place);
    logger.info("Finishing update process for place with ID{}...",id);
    return save;
  }
}
