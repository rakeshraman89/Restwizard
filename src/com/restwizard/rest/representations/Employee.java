package com.restwizard.rest.representations;

public class Employee {

    private Integer id;
    private String empName;

    public Employee (Integer id, String empName) {
        this.id = id;
        this.empName = empName;
    }

    public void setId (Integer id) {
        this.id = id;
    }
    public Integer getId () {
        return id;
    }

    public void setEmpName (String empName) {
        this.empName = empName;
    }
    public String getEmpName () {
        return empName;
    }
}
