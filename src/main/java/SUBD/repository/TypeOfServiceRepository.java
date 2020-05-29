package SUBD.repository;

import SUBD.entity.TypeOfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfServiceRepository extends JpaRepository<TypeOfService, Integer> {
}
