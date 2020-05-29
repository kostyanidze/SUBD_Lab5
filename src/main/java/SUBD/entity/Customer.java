package SUBD.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private Integer phoneNumber;

    @OneToMany
    private List<Orders> orders;

    public String toString() {
        return "Customer {\n"+
                " id=" + id + ",\n" +
                " surname=" + surname + ",\n" +
                " name=" + name + ",\n" +
                " middle_name=" + middleName + ",\n" +
                " address=" + address + ",\n" +
                " phone_number=" + phoneNumber + ",\n" +
                "}" + "\n";
    }

    public void Customers(Integer id, String surname, String name, String middleName, String address, Integer phoneNumber, List<Orders> orders) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }
}
