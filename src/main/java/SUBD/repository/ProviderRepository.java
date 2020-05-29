package SUBD.repository;

import SUBD.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    @Query("SELECT new SUBD.repository.ProviderNameWithCount" +
            "(p.name, COUNT(p)) FROM Provider p" +
            " GROUP BY p.name")
    List<ProviderNameWithCount> getNameProviderCount();
}
