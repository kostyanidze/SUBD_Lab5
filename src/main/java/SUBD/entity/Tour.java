package SUBD.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String country;
    private Integer visaService;
    private Date dateOfDeparture;
    private Date dateOfArrival;
    private Integer cost;

    @OneToMany
    private List<Orders> ordersList;

    @OneToMany
    private List<TypeOfService> typeOfServiceList;


   public String toString() {
       return "Tour {\n"+
               " id=" + id + ",\n" +
               " country=" + country + ",\n" +
               " visa_service=" + visaService + ",\n" +
               " date_of_departure=" + dateOfArrival + ",\n" +
               " cost=" + cost + ",\n" +
               "}" + "\n";
   }

    public String getCountry() {
        return country;
    }

    public Integer getCost() {
        return cost;
    }
}
