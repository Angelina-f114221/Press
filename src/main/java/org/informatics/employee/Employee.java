package org.informatics.employee;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Employee implements Serializable {
    private String name;
    private BigDecimal baseSalary;

    public Employee(String name, BigDecimal baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract BigDecimal getSalary(BigDecimal totalRevenue);

    public String getName() {
        return name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }
}
