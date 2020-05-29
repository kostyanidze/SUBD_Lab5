package SUBD.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String surname;
    private String name;
    private String middleName;
    private Timestamp birthdate;
    private Integer salary;
    private String position;
    private String address;
    private Integer phoneNumber;

    @OneToMany
    private List<Orders> ordersList;

    public String toString() {
        return "Employee {\n"+
                " id=" + id + ",\n" +
                " surname=" + surname + ",\n" +
                " name=" + name + ",\n" +
                " middle_name=" + middleName + ",\n" +
                " birthdate=" + birthdate + ",\n" +
                " salary=" + salary + ",\n" +
                " position=" + position + ",\n" +
                " address=" + address + ",\n" +
                " phone_number=" + phoneNumber + ",\n" +
                "}" + "\n";
    }
}
