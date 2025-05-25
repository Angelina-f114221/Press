package org.informatics.employee;

import java.math.BigDecimal;

public class Operator extends Employee {
    public Operator(String name, BigDecimal baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public BigDecimal getSalary(BigDecimal totalRevenue) {
        return getBaseSalary();
    }
}

