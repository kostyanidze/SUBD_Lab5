package SUBD.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class TypeOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Timestamp dateOfExecution;
    private String nameOfService;
    private Integer cost;

    @OneToMany
    private List<Tour> tourList;

    @ManyToOne
    private Provider provider;

    public String toString() {
        return "TypeOfService {\n"+
                " id=" + id + ",\n" +
                " date_of_execution=" + dateOfExecution + ",\n" +
                " name_of_service=" + nameOfService + ",\n" +
                " cost=" + cost + ",\n" +
                "}" + "\n";
    }
}
