package org.trahim.data.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "bank", schema = "fin")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    private Long bankId;

    @Column(name = "NAME")
    private String name;




    @Column(name = "LAST_UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "IS_INTERNATIONAL")
    private boolean international;

    @Embedded
    private Address address;
//
//    @ElementCollection
//    @CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name = "BANK_ID"))
//    //вставляем в таблицу BANK_CONTACT, причем BANK_ID берем для вставки из таблицы BANK;
//    @Column(name = "NAME")
//    private Collection<String> contacts = new ArrayList<>();



//    public Collection<String> getContacts() {
//        return contacts;
//    }
//
//    public void setContacts(Collection<String> contact) {
//        this.contacts = contact;
//    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ElementCollection
    @CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name = "BANK_ID"))
    @MapKeyColumn(name = "POSITION_TYPE")// в это поле ключ
    @Column(name = "NAME")//в это поле значение
    private Map<String, String> mapContacts = new HashMap<>();

    public Map<String, String> getMapContacts() {
        return mapContacts;
    }

    public void setMapContacts(Map<String, String> mapContacts) {
        this.mapContacts = mapContacts;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }
}
