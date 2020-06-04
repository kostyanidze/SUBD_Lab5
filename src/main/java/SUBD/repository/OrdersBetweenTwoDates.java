package SUBD.repository;

import java.util.Date;

public class OrdersBetweenTwoDates {
    private int id;
    private Date dateOfIssuance;
    private String Country;
    private int cost;

    public OrdersBetweenTwoDates(int id, Date dateOfIssuance, String country, int cost) {
        this.id = id;
        this.dateOfIssuance = dateOfIssuance;
        Country = country;
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfIssuance(Date dateOfIssuance) {
        this.dateOfIssuance = dateOfIssuance;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public Date getDateOfIssuance() {
        return dateOfIssuance;
    }

    public String getCountry() {
        return Country;
    }

    public int getCost() {
        return cost;
    }
}
