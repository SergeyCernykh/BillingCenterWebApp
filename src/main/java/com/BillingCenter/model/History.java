package com.BillingCenter.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "\"HISTORY\"", schema = "public", catalog = "BillingCenter")
public class History {
    private int rowid;
    private Date from;
    private Date to;
    private int customerid;
    private Integer serviceid;
    private Customer customersByCustomerid;
    private PhoneService servicesByServiceid;

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
    @Column(name = "\"From\"", nullable = false)
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    @Basic
    @Column(name = "\"To\"", nullable = true)
    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History that = (History) o;

        if (rowid != that.rowid) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowid;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "\"customerid\"", nullable = false,insertable = false, updatable = false)
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "\"serviceid\"", nullable = true,insertable = false, updatable = false)
    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    @ManyToOne
    @JoinColumn(name = "\"customerid\"", referencedColumnName = "id", nullable = false)
    public Customer getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customer customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }

    @ManyToOne
    @JoinColumn(name = "\"serviceid\"", referencedColumnName = "id")
    public PhoneService getServicesByServiceid() {
        return servicesByServiceid;
    }

    public void setServicesByServiceid(PhoneService servicesByServiceid) {
        this.servicesByServiceid = servicesByServiceid;
    }
}
