package com.BillingCenter.model;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers", schema = "public", catalog = "BillingCenter")
public class PhoneNumber {
    private int rowid;
    private int countrycode;
    private int regioncode;
    private int number;
    private String fullnumber;
    private Integer customerid;
    private Customer customersByCustomerid;

    @Id
    @Column(name = "\"rowid\"", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    @Basic
    @Column(name = "\"countrycode\"", nullable = false)
    public int getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(int countrycode) {
        this.countrycode = countrycode;
    }

    @Basic
    @Column(name = "\"regioncode\"", nullable = false)
    public int getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(int regioncode) {
        this.regioncode = regioncode;
    }

    @Basic
    @Column(name = "\"Number\"", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "\"fullnumber\"", nullable = true, length = 16)
    public String getFullnumber() {
        return fullnumber;
    }

    public void setFullnumber(String fullnumber) {
        this.fullnumber = fullnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (rowid != that.rowid) return false;
        if (countrycode != that.countrycode) return false;
        if (regioncode != that.regioncode) return false;
        if (number != that.number) return false;
        if (fullnumber != null ? !fullnumber.equals(that.fullnumber) : that.fullnumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowid;
        result = 31 * result + countrycode;
        result = 31 * result + regioncode;
        result = 31 * result + number;
        result = 31 * result + (fullnumber != null ? fullnumber.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "customerid", nullable = true,insertable = false, updatable = false)
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "id")
    public Customer getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customer customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }
}
