package com.BillingCenter.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "\"actions\"", schema = "public", catalog = "BillingCenter")
public class Action {
    private int rowid;
    private float action;
    private Timestamp date;
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
    @Column(name = "\"Action\"", nullable = false, precision = 0)
    public float getAction() {
        return action;
    }

    public void setAction(float action) {
        this.action = action;
    }

    @Basic
    @Column(name = "\"Date\"", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action that = (Action) o;

        if (rowid != that.rowid) return false;
        if (Float.compare(that.action, action) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowid;
        result = 31 * result + (action != +0.0f ? Float.floatToIntBits(action) : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "\"customerid\"", referencedColumnName = "id", nullable = false)
    public Customer getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customer customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }
}
