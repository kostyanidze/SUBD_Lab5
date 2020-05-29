package SUBD.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date dateOfIssuance;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Tour tour;

    public String toString() {
        return "Orders {\n"+
                " id=" + id + ",\n" +
                " date_of_issuance=" + dateOfIssuance + ",\n" +
                "}" + "\n";
    }


}
