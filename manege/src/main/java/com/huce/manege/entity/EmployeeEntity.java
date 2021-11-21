package com.huce.manege.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name="derpartment_id", nullable=false)
    private DepartmentEntity derpartment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentEntity getDerpartment() {
        return derpartment;
    }

    public void setDerpartment(DepartmentEntity derpartment) {
        this.derpartment = derpartment;
    }

}
