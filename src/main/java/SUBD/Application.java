package SUBD;

import SUBD.entity.Customer;
import SUBD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Application {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private OrdersRepository ordersRepository;
    private ProviderRepository providerRepository;
    private TourRepository tourRepository;
    private TypeOfServiceRepository typeOfServiceRepository;

    @Autowired
    public Application(CustomerRepository customerRepository,
                       EmployeeRepository employeeRepository,
                       OrdersRepository ordersRepository,
                       ProviderRepository providerRepository,
                       TourRepository tourRepository,
                       TypeOfServiceRepository typeOfServiceRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.ordersRepository = ordersRepository;
        this.providerRepository = providerRepository;
        this.tourRepository = tourRepository;
        this.typeOfServiceRepository = typeOfServiceRepository;
    }

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        this.firstRequest();
        this.secondRequest();
        //this.createCustomer(null,"Pupkin","Vasya","Vasvas", "ul M", 880055);
        //this.deleteOrders();
        this.readCustomer();
        //this.updateCustomer();
        this.readEmployee();
        this.readOrders();
        this.readProvider();
        this.readTour();
        this.readTypeOfService();
    }

    public void firstRequest() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<ProviderNameWithCount> resultFirst = providerRepository.getNameProviderCount();
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");

        resultFirst.forEach(providerNameWithCount -> {
            System.out.print("Name of provider: " + providerNameWithCount.getName() + " ");
            System.out.println("Count: " + providerNameWithCount.getCount());
        });
    }

    public void secondRequest() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<TourCostSort> resultSecond = tourRepository.getAllToursCostAsc();
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");

        resultSecond.forEach(tourCostSort -> {
            System.out.print("Id: " + tourCostSort.getId() + " ");
            System.out.println("Country: " + tourCostSort.getCountry()+ " ");
            System.out.println("Cost: " + tourCostSort.getCost());
        });
    }

    private void createCustomer(Integer id, String surname, String name, String middleName, String address,int phoneNumber){
        Customer customer = new Customer();
        customer.Customers(null, surname,name,middleName,address,phoneNumber,null);
        customerRepository.save(customer);
    }

    private void deleteOrders() { ordersRepository.deleteById(1);}

    private void readCustomer(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        customerRepository.findAll(PageRequest.of(0,5, Sort.Direction.ASC,"id"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }

    private void updateCustomer(){
        Customer customer = new Customer();
        customer.Customers(2,"Petrov","Ivan","Petrovich", "Ulitsa Zelenaya",850321, null);
        customerRepository.save(customer);
    }

    private void readEmployee(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        employeeRepository.findAll(PageRequest.of(0,5, Sort.Direction.DESC,"salary"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }

    private void readOrders(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        ordersRepository.findAll(PageRequest.of(0,3, Sort.Direction.ASC,"dateOfIssuance"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }

    private void readProvider(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        providerRepository.findAll(PageRequest.of(0,3, Sort.Direction.ASC,"nameOfService"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }

    private void readTour(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        tourRepository.findAll(PageRequest.of(0,3, Sort.Direction.ASC,"cost"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }

    private void readTypeOfService(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        typeOfServiceRepository.findAll(PageRequest.of(0,3, Sort.Direction.ASC,"dateOfExecution"))
                .toList().forEach(System.out::println);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Request time: " + (end.getTime() - start.getTime()) + " ms");
    }
}
