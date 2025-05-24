package org.informatics;
// NOT PUSHED
import org.informatics.employee.Employee;

import java.util.List;

public class PrintingHouse {

    public static double calculateSalaryExpenses(Employee[] employees, double totalRevenue) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary(totalRevenue);
        }
        return total;
    }

    public static double calculatePaperExpenses(List<Paper> papers, List<Integer> quantities) {
        double total = 0;
        for (int i = 0; i < papers.size(); i++) {
            total += papers.get(i).getActualPrice() * quantities.get(i);
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
