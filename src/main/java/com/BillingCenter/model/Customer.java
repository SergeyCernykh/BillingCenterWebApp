package com.BillingCenter.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "customers", schema = "public", catalog = "BillingCenter")
public class Customer {
    private int id;
    private String name;
    private Float bill;
    private Float maxdebt;
    private Date maxdaytorepayment;
    private Boolean companyflag;
    private Boolean blockedflag;
    private Integer serviceid;
    private List<History> historiesById;
    private List<Action> actionsById;
    private PhoneService servicesByServiceid;
    private List<CustomerInfo> customersInfosById;
    private List<PhoneNumber> phoneNumbersById;

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
    @Column(name = "\"Name\"", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "\"bill\"", nullable = true, precision = 0)
    public Float getBill() {
        return bill;
    }

    public void setBill(Float bill) {
        this.bill = bill;
    }

    @Basic
    @Column(name = "\"maxdebt\"", nullable = true, precision = 0)
    public Float getMaxdebt() {
        return maxdebt;
    }

    public void setMaxdebt(Float maxdebt) {
        this.maxdebt = maxdebt;
    }

    @Basic
    @Column(name = "\"maxdaytorepayment\"", nullable = true)
    public Date getMaxdaytorepayment() {
        return maxdaytorepayment;
    }

    public void setMaxdaytorepayment(Date maxdaytorepayment) {
        this.maxdaytorepayment = maxdaytorepayment;
    }

    @Basic
    @Column(name = "\"companyflag\"", nullable = true)
    public Boolean getCompanyflag() {
        return companyflag;
    }

    public void setCompanyflag(Boolean companyflag) {
        this.companyflag = companyflag;
    }

    @Basic
    @Column(name = "\"blockedflag\"", nullable = true)
    public Boolean getBlockedflag() {
        return blockedflag;
    }

    public void setBlockedflag(Boolean blockedflag) {
        this.blockedflag = blockedflag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer that = (Customer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (bill != null ? !bill.equals(that.bill) : that.bill != null) return false;
        if (maxdebt != null ? !maxdebt.equals(that.maxdebt) : that.maxdebt != null) return false;
        if (maxdaytorepayment != null ? !maxdaytorepayment.equals(that.maxdaytorepayment) : that.maxdaytorepayment != null)
            return false;
        if (companyflag != null ? !companyflag.equals(that.companyflag) : that.companyflag != null) return false;
        if (blockedflag != null ? !blockedflag.equals(that.blockedflag) : that.blockedflag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bill != null ? bill.hashCode() : 0);
        result = 31 * result + (maxdebt != null ? maxdebt.hashCode() : 0);
        result = 31 * result + (maxdaytorepayment != null ? maxdaytorepayment.hashCode() : 0);
        result = 31 * result + (companyflag != null ? companyflag.hashCode() : 0);
        result = 31 * result + (blockedflag != null ? blockedflag.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "serviceid", nullable = true, insertable = false, updatable = false)
    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    @OneToMany(mappedBy = "customersByCustomerid")
    public List<History> getHistoriesById() {
        return historiesById;
    }

    public void setHistoriesById(List<History> historiesById) {
        this.historiesById = historiesById;
    }

    @OneToMany(mappedBy = "customersByCustomerid")
    public List<Action> getActionsById() {
        return actionsById;
    }

    public void setActionsById(List<Action> actionsById) {
        this.actionsById = actionsById;
    }

    @ManyToOne
    @JoinColumn(name = "serviceid", referencedColumnName = "id")
    public PhoneService getServicesByServiceid() {
        return servicesByServiceid;
    }

    public void setServicesByServiceid(PhoneService servicesByServiceid) {
        this.servicesByServiceid = servicesByServiceid;
    }

    @OneToMany(mappedBy = "customersByCustomerid")
    public List<CustomerInfo> getCustomersInfosById() {
        return customersInfosById;
    }

    public void setCustomersInfosById(List<CustomerInfo> customersInfosById) {
        this.customersInfosById = customersInfosById;
    }

    @OneToMany(mappedBy = "customersByCustomerid", fetch = FetchType.LAZY)
    public List<PhoneNumber> getPhoneNumbersById() {
        return phoneNumbersById;
    }

    public void setPhoneNumbersById(List<PhoneNumber> phoneNumbersById) {
        this.phoneNumbersById = phoneNumbersById;
    }


}
