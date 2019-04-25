package com.BillingCenter.model;

import javax.persistence.*;

@Entity
@Table(name = "customers_info", schema = "public", catalog = "BillingCenter")
public class CustomerInfo {
    private int rowid;
    private String fullname;
    private String phonenumber;
    private String adress;
    private String email;
    private int customerid;
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
    @Column(name = "\"fullname\"", nullable = true, length = 45)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "\"phonenumber\"", nullable = true, length = 16)
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "\"adress\"", nullable = true, length = 100)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "\"email\"", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerInfo that = (CustomerInfo) o;

        if (rowid != that.rowid) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (phonenumber != null ? !phonenumber.equals(that.phonenumber) : that.phonenumber != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowid;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "customerid", nullable = false,insertable = false, updatable = false)
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "id", nullable = false)
    public Customer getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customer customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }
}
