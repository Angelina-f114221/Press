package org.informatics.employee;

public class Operator extends Employee {
    public Operator(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getSalary(double totalRevenue) {
        return baseSalary;
    }
}

