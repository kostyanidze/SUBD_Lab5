package SUBD.service.implementation;

import SUBD.entity.Provider;
import SUBD.repository.ProviderRepository;
import SUBD.service.serviceInterfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImplementation implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provider addProvider(Provider provider) {
        Provider savedProvider = providerRepository.saveAndFlush(provider);
        return savedProvider;
    }

    @Override
    public void delete(int id) {
        providerRepository.deleteById(id);
    }

    @Override
    public Optional<Provider> getById(int id) {
        return providerRepository.findById(id);
    }

    @Override
    public Provider editProvider(Provider provider) {
        return providerRepository.saveAndFlush(provider);
    }

    @Override
    public List<Provider> getAll() {
        return providerRepository.findAll();
    }
}
