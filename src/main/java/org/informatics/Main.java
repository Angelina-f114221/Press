package org.informatics;

import org.informatics.edition.Book;
import org.informatics.edition.Newspaper;
import org.informatics.edition.Poster;
import org.informatics.edition.Edition;
import org.informatics.employee.Employee;
import org.informatics.employee.Operator;
import org.informatics.employee.Manager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PrintingHouseInstance house = new PrintingHouseInstance("SuperPrint");
            house.setPaperPrice(PaperType.REGULAR,   PaperSize.A5, new BigDecimal("0.10"));
            house.setPaperPrice(PaperType.REGULAR,   PaperSize.A4, new BigDecimal("0.15"));
            house.setPaperPrice(PaperType.GLOSSY,    PaperSize.A3, new BigDecimal("0.30"));
            house.setPaperPrice(PaperType.NEWSPAPER, PaperSize.A4, new BigDecimal("0.08"));

            Employee operator = new Operator("Ivan",  new BigDecimal("1000"));
            Employee manager  = new Manager ("Maria", new BigDecimal("1500"), new BigDecimal("10"), new BigDecimal("3000"));
            List<Employee> employees = Arrays.asList(operator, manager);

            Edition book      = new Book     ("Java Basics",    200, false, PaperType.REGULAR,   PaperSize.A4);
            Edition newspaper = new Newspaper("Daily News",      32, false, PaperType.NEWSPAPER, PaperSize.A4);
            Edition poster    = new Poster   ("Concert Poster",   1, true,  PaperType.GLOSSY,    PaperSize.A3);

            PrintingMachine machine = new PrintingMachine(1000, true, 100);
            machine.loadPaper(1000);
            machine.printEdition(book,      2);
            machine.printEdition(newspaper, 10);
            machine.printEdition(poster,    20);




            BigDecimal rev1 = PrintingHouse.calculatePrintingRevenue(5,  new BigDecimal("15"),  10, new BigDecimal("10"));
            BigDecimal rev2 = PrintingHouse.calculatePrintingRevenue(10, new BigDecimal("1.2"), 10, new BigDecimal("10"));
            BigDecimal rev3 = PrintingHouse.calculatePrintingRevenue(20, new BigDecimal("3.5"), 10, new BigDecimal("10"));
            BigDecimal revenue = rev1.add(rev2).add(rev3);

            List<Paper> usedPapers = Arrays.asList(
                    new Paper(PaperType.REGULAR,   PaperSize.A4, new BigDecimal("0.10"), new BigDecimal("0.20")),
                    new Paper(PaperType.NEWSPAPER, PaperSize.A4, new BigDecimal("0.10"), new BigDecimal("0.20")),
                    new Paper(PaperType.GLOSSY,    PaperSize.A3, new BigDecimal("0.10"), new BigDecimal("0.20"))
            );
            List<Integer> quantities = Arrays.asList(5 * 200, 10 * 32, 20);

            BigDecimal paperExpenses  = PrintingHouse.calculatePaperExpenses(usedPapers, quantities);
            BigDecimal salaryExpenses = PrintingHouse.calculateSalaryExpenses(employees, revenue);
            BigDecimal totalExpenses  = paperExpenses.add(salaryExpenses);

            FileReport.saveReport(Arrays.asList(book, newspaper, poster),
                    revenue, totalExpenses, "report.txt");
            FileReport.serializeEmployee(manager, "manager.ser");
            Employee restored = FileReport.deserializeEmployee("manager.ser");

            System.out.println("Revenue:  " + revenue);
            System.out.println("Expenses: " + totalExpenses);
            System.out.println("Restored: " + restored.getName() + "  Salary: " + restored.getSalary(revenue));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
