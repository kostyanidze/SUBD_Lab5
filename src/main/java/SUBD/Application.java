package SUBD;

import SUBD.repository.*;
import SUBD.service.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

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
    private CustomerService customerService;
    private EmployeeService employeeService;
    private OrdersService ordersService;
    private ProviderService providerService;
    private TourService tourService;
    private TypeOfServiceService typeOfServiceService;

    @Autowired
    public Application(CustomerRepository customerRepository,
                       EmployeeRepository employeeRepository,
                       OrdersRepository ordersRepository,
                       ProviderRepository providerRepository,
                       TourRepository tourRepository,
                       TypeOfServiceRepository typeOfServiceRepository,
                       CustomerService customerService,
                       EmployeeService employeeService,
                       OrdersService ordersService,
                       ProviderService providerService,
                       TourService tourService,
                       TypeOfServiceService typeOfServiceService) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.ordersRepository = ordersRepository;
        this.providerRepository = providerRepository;
        this.tourRepository = tourRepository;
        this.typeOfServiceRepository = typeOfServiceRepository;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.ordersService = ordersService;
        this.providerService = providerService;
        this.tourService = tourService;
        this.typeOfServiceService = typeOfServiceService;
    }

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        System.out.println(customerService.getAll());
      /*  this.firstRequest();
        this.secondRequest();*/
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

}
