package org.informatics;

import org.informatics.employee.Employee;

import java.math.BigDecimal;
import java.util.List;

public class PrintingHouse {

    public static BigDecimal calculateSalaryExpenses(List<Employee> employees, BigDecimal totalRevenue) {
        BigDecimal total = BigDecimal.ZERO;
        for (Employee employee : employees) {
            total = total.add(employee.getSalary(totalRevenue));
        }
        return total;
    }

    public static BigDecimal calculatePaperExpenses(List<Paper> papers, List<Integer> quantities) {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < papers.size(); i++) {
            BigDecimal cost = papers.get(i).getActualPrice().multiply(BigDecimal.valueOf(quantities.get(i)));
            total = total.add(cost);
        }
        return total;
    }

    public static BigDecimal calculatePrintingRevenue(int numberOfCopies, BigDecimal pricePerCopy,
                                                      int discountThreshold, BigDecimal discountPercent) {
        if (numberOfCopies <= discountThreshold) {
            return pricePerCopy.multiply(BigDecimal.valueOf(numberOfCopies));
        } else {
            BigDecimal discount = BigDecimal.ONE.subtract(discountPercent.divide(BigDecimal.valueOf(100)));
            BigDecimal discountedPrice = pricePerCopy.multiply(discount);
            return discountedPrice.multiply(BigDecimal.valueOf(numberOfCopies));
        }
    }
}
