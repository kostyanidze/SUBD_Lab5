package SUBD.service.serviceInterfaces;

import SUBD.entity.Tour;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TourService {
    Tour addTour(Tour tour);
    void delete(int id);
    Optional<Tour> getById(int id);
    Tour editTour(Tour name);
    List<Tour> getAll();
}
