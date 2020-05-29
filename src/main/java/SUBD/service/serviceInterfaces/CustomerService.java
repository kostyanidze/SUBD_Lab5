package SUBD.service.serviceInterfaces;

import SUBD.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Customer addCustomer(Customer customer);
    void delete(int id);
    Optional<Customer> getById(int id);
    Customer editCustomer(Customer customer);
    List<Customer> getAll();
}
