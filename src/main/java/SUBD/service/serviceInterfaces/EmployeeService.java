package SUBD.service.serviceInterfaces;


import SUBD.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Employee addEmployee(Employee employee);
    void delete(int id);
    Optional<Employee> getById(int id);
    Employee editEmployee(Employee employee);
    List<Employee> getAll();
}
