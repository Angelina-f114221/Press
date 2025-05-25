package org.informatics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrintingHouseInstanceTest {

    @Test
    @DisplayName("setPaperPrice → getPaperPrice round-trip")
    void storesAndReturnsPrice() {
        PrintingHouseInstance instance = new PrintingHouseInstance("Demo");
        instance.setPaperPrice(PaperType.REGULAR, PaperSize.A4, new BigDecimal("0.15"));

        BigDecimal price = instance.getPaperPrice(PaperType.REGULAR, PaperSize.A4);
        assertEquals(0, new BigDecimal("0.15").compareTo(price));
    }

    @Test
    @DisplayName("getPaperPrice throws when price not defined")
    void throwsWhenMissingPrice() {
        PrintingHouseInstance instance = new PrintingHouseInstance("Demo");

        assertThrows(IllegalArgumentException.class,
                () -> instance.getPaperPrice(PaperType.REGULAR, PaperSize.A3));
    }
}