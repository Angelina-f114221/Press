package org.informatics;
import org.informatics.edition.Edition;
import org.informatics.employee.Employee;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class FileReport {

    public static void saveReport(List<Edition> editions, BigDecimal revenue, BigDecimal expenses, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Edition e : editions) {
                writer.write(String.format("Edition: %s, Pages: %d, Color: %b, Paper: %s %s",
                        e.getTitle(), e.getNumberOfPages(), e.isColor(), e.getPaperSize(), e.getPaperType()));
                writer.newLine();
            }
            writer.write("Revenue: " + revenue.toPlainString());
            writer.newLine();
            writer.write("Expenses: " + expenses.toPlainString());
        }
    }

}
