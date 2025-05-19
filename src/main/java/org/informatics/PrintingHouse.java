package org.informatics;

import org.informatics.employee.Employee;
import org.informatics.PaperSize;

public class PrintingHouse {

    public static double calculateSalaryExpenses(Employee[] employees, double totalRevenue) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary(totalRevenue);
        }
        return total;
    }

    public static double calculatePaperExpenses(PaperSize[] sizes, double[] basePricesA5, int[] quantities, double increasePercentPerStep) {
        double total = 0;
        for (int i = 0; i < sizes.length; i++) {
            double multiplier = sizes[i].getSizeMultiplier(increasePercentPerStep);
            total += basePricesA5[i] * multiplier * quantities[i];
        }
        return total;
    }

    public static double calculatePrintingRevenue(int numberOfCopies, double pricePerCopy,
                                                  int discountThreshold, double discountPercent) {
        if (numberOfCopies <= discountThreshold) {
            return numberOfCopies * pricePerCopy;
        } else {
            double discountedPrice = pricePerCopy * (1 - discountPercent / 100.0);
            return numberOfCopies * discountedPrice;
        }
    }

}
