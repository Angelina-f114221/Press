package org.informatics.employee;

import java.math.BigDecimal;

public class Manager extends Employee {
    private BigDecimal bonusPercent;
    private BigDecimal revenueThreshold;

    public Manager(String name, BigDecimal baseSalary, BigDecimal bonusPercent, BigDecimal revenueThreshold) {
        super(name, baseSalary);
        this.bonusPercent = bonusPercent;
        this.revenueThreshold = revenueThreshold;
    }

    @Override
    public BigDecimal getSalary(BigDecimal totalRevenue) {
        if (totalRevenue.compareTo(revenueThreshold) > 0) {
            return getBaseSalary().add(getBaseSalary().multiply(bonusPercent).divide(BigDecimal.valueOf(100)));
        }
        return getBaseSalary();
    }
}
