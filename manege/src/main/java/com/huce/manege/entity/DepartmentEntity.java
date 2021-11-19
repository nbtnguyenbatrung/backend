package com.huce.manege.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DERPARTMENT")
public class DepartmentEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private String id;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany (mappedBy="derpartment")
    private Set<EmployeeEntity> employee;

    public Set<EmployeeEntity> getEmployee() {
        return employee ;
    }
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
