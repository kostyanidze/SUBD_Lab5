package SUBD.service.serviceInterfaces;

import SUBD.entity.TypeOfService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TypeOfServiceService {
    TypeOfService addTypeOfService(TypeOfService typeOfService);
    void delete(int id);
    Optional<TypeOfService> getById(int id);
    TypeOfService editTypeOfService(TypeOfService TypeOfService);
    List<TypeOfService> getAll();
}
