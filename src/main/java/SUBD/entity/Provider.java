package SUBD.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String nameOfService;
    private Integer phoneNumber;
    private String address;

    @OneToMany
    private List<TypeOfService> typeOfServiceList;

    public String toString() {
        return "Provider {\n"+
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " name_of_service=" + nameOfService + ",\n" +
                " phone_number=" + phoneNumber + ",\n" +
                " address=" + address + ",\n" +
                "}" + "\n";
    }
}
