package SUBD.service.serviceInterfaces;

import SUBD.entity.Provider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProviderService {
    Provider addProvider(Provider provider);
    void delete(int id);
    Optional<Provider> getById(int id);
    Provider editProvider(Provider Provider);
    List<Provider> getAll();
}
