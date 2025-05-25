package org.informatics;

import org.informatics.employee.Manager;
import org.informatics.employee.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintingHouseTest {

    @Nested
    @DisplayName("calculateSalaryExpenses")
    class CalculateSalaryExpenses {

        @Test
        void appliesManagerBonusWhenRevenueAboveThreshold() {
            Manager mgr = new Manager("Alice",
                    new BigDecimal("1000"),             // base salary
                    new BigDecimal("10"),               // bonus %
                    new BigDecimal("5000"));            // threshold
            Operator op = new Operator("Bob", new BigDecimal("800"));

            BigDecimal revenue = new BigDecimal("6000");

            BigDecimal expected = new BigDecimal("1900"); // 1000 + 10 % bonus + 800
            BigDecimal actual   = PrintingHouse.calculateSalaryExpenses(
                    List.of(mgr, op), revenue);

            assertEquals(0, expected.compareTo(actual),
                    "Total salary expenses should include the manager bonus");
        }

        @Test
        void noBonusWhenRevenueBelowThreshold() {
            Manager mgr = new Manager("Alice",
                    new BigDecimal("1000"),
                    new BigDecimal("10"),
                    new BigDecimal("5000"));
            BigDecimal actual = PrintingHouse.calculateSalaryExpenses(
                    List.of(mgr), new BigDecimal("3000"));

            assertEquals(0, new BigDecimal("1000").compareTo(actual));
        }
    }

    @Test
    @DisplayName("calculatePaperExpenses considers actual paper price and quantities")
    void calculatePaperExpenses() {
        // Paper 1: A3, price becomes 1 × (1 + 0.20)^1 = 1.20
        Paper p1 = new Paper(PaperType.REGULAR, PaperSize.A3,
                new BigDecimal("1.00"), new BigDecimal("20"));      // 20 % per step
        // Paper 2: A5 – multiplier step = 0 ⇒ price unchanged
        Paper p2 = new Paper(PaperType.GLOSSY, PaperSize.A5,
                new BigDecimal("2.00"), new BigDecimal("20"));

        BigDecimal expected = new BigDecimal("22.0"); // (1.20×10) + (2.00×5)

        BigDecimal actual = PrintingHouse.calculatePaperExpenses(
                List.of(p1, p2), List.of(10, 5));

        assertEquals(0, expected.compareTo(actual));
    }

    @Nested
    @DisplayName("calculatePrintingRevenue")
    class CalculatePrintingRevenue {

        @Test
        void noDiscountWhenBelowThreshold() {
            BigDecimal price = new BigDecimal("2.00");
            BigDecimal revenue = PrintingHouse.calculatePrintingRevenue(
                    100, price, 200, new BigDecimal("10"));

            assertEquals(0, new BigDecimal("200.00").compareTo(revenue));
        }

        @Test
        void appliesDiscountWhenAboveThreshold() {
            BigDecimal price = new BigDecimal("2.00");
            BigDecimal revenue = PrintingHouse.calculatePrintingRevenue(
                    300, price, 200, new BigDecimal("10")); // 10 % off

            assertEquals(0, new BigDecimal("540.00").compareTo(revenue));
        }
    }
}
