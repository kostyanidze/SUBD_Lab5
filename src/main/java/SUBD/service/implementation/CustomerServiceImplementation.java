package SUBD.service.implementation;

import SUBD.entity.Customer;
import SUBD.repository.CustomerRepository;
import SUBD.service.serviceInterfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
