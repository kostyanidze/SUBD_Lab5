package SUBD.service.implementation;

import SUBD.entity.TypeOfService;
import SUBD.repository.TypeOfServiceRepository;
import SUBD.service.serviceInterfaces.TypeOfServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfServiceServiceImplementation implements TypeOfServiceService {
    @Autowired
    private TypeOfServiceRepository typeOfServiceRepository;
    @Override
    public TypeOfService addTypeOfService(TypeOfService typeOfService) {
        TypeOfService savedTypeOfService = typeOfServiceRepository.saveAndFlush(typeOfService);
        return savedTypeOfService;
    }

    @Override
    public void delete(int id) {
        typeOfServiceRepository.deleteById(id);
    }

    @Override
    public Optional<TypeOfService> getById(int id) {
        return typeOfServiceRepository.findById(id);
    }

    @Override
    public TypeOfService editTypeOfService(TypeOfService typeOfService) {
        return typeOfServiceRepository.saveAndFlush(typeOfService);
    }

    @Override
    public List<TypeOfService> getAll() {
        return typeOfServiceRepository.findAll();
    }
}
