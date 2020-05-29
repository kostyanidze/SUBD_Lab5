package SUBD.repository;

import SUBD.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Query("SELECT new SUBD.repository.TourCostSort(t.id,t.country,t.cost) FROM Tour t " +
            " ORDER BY t.cost ASC ")
    List<TourCostSort> getAllToursCostAsc();
}
