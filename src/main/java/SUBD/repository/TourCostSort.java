package SUBD.repository;

import java.util.Date;

public class TourCostSort {
    private Integer id;
    private Date dateOfIssuance;
    private String country;
    private Integer cost;

    public TourCostSort(Integer id, String country, Integer cost) {
        this.id = id;
        this.country = country;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
