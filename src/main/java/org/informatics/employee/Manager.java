package org.informatics.employee;

public class Manager extends Employee {
    private double bonusPercent;
    private double revenueThreshold;

    public Manager(String name, double baseSalary, double bonusPercent, double revenueThreshold) {
        super(name, baseSalary);
        this.bonusPercent = bonusPercent;
        this.revenueThreshold = revenueThreshold;
    }

    @Override
    public double getSalary(double totalRevenue) {
        if (totalRevenue > revenueThreshold) {
            return baseSalary + (baseSalary * bonusPercent);
        }
        return baseSalary;
    }
}
