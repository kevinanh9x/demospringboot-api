package com.theanh.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_department")
public class DepartmentEntity implements Serializable {
    @Id
    @Column(name = "departmentId", nullable = false)
    private int id;

    @Column(name = "nameDepartments", nullable = false)
    private String nameDepartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
}
