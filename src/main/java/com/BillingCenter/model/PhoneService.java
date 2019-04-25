package com.BillingCenter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services", schema = "public", catalog = "BillingCenter")
public class PhoneService {
    private int id;
    private String name;
    private Integer minutes;
    private Integer internet;
    private Integer sms;
    private Float cost;
    private Float specialoffer;
    private List<History> historiesById;
    private List<Customer> customersById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"Name\"", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "minutes", nullable = true)
    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "internet", nullable = true)
    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    @Basic
    @Column(name = "sms", nullable = true)
    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 0)
    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "specialoffer", nullable = true, precision = 0)
    public Float getSpecialoffer() {
        return specialoffer;
    }

    public void setSpecialoffer(Float specialoffer) {
        this.specialoffer = specialoffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneService that = (PhoneService) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (minutes != null ? !minutes.equals(that.minutes) : that.minutes != null) return false;
        if (internet != null ? !internet.equals(that.internet) : that.internet != null) return false;
        if (sms != null ? !sms.equals(that.sms) : that.sms != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (specialoffer != null ? !specialoffer.equals(that.specialoffer) : that.specialoffer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
        result = 31 * result + (internet != null ? internet.hashCode() : 0);
        result = 31 * result + (sms != null ? sms.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (specialoffer != null ? specialoffer.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "servicesByServiceid", fetch = FetchType.EAGER)
    public List<History> getHistoriesById() {
        return historiesById;
    }

    public void setHistoriesById(List<History> historiesById) {
        this.historiesById = historiesById;
    }

    @OneToMany(mappedBy = "servicesByServiceid")
    public List<Customer> getCustomersById() {
        return customersById;
    }

    public void setCustomersById(List<Customer> customersById) {
        this.customersById = customersById;
    }

    @Override
    public String toString() {
        return "PhoneService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minutes=" + minutes +
                ", internet=" + internet +
                ", sms=" + sms +
                ", cost=" + cost +
                ", specialoffer=" + specialoffer +
                '}';
    }
}
