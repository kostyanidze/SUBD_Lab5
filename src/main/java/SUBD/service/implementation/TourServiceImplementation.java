package SUBD.service.implementation;

import SUBD.entity.Tour;
import SUBD.repository.TourRepository;
import SUBD.service.serviceInterfaces.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImplementation implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour addTour(Tour tour) {
        Tour savedTour = tourRepository.saveAndFlush(tour);
        return savedTour;
    }

    @Override
    public void delete(int id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Optional<Tour> getById(int id) {
        return tourRepository.findById(id);
    }

    @Override
    public Tour editTour(Tour tour) {
        return tourRepository.saveAndFlush(tour);
    }

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }
}
