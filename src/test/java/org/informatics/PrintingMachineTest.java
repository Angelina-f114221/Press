package org.informatics;

import org.informatics.edition.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMachineTest {

    private PrintingMachine colorCapable;
    private PrintingMachine monoOnly;

    @BeforeEach
    void setUp() {
        colorCapable = new PrintingMachine(100, true, 20);
        monoOnly     = new PrintingMachine(100, false, 20);
    }

    @Test
    void constructorRejectsNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class,
                () -> new PrintingMachine(0, true, 10));
    }

    @Test
    void constructorRejectsNonPositiveSpeed() {
        assertThrows(IllegalArgumentException.class,
                () -> new PrintingMachine(100, true, 0));
    }

    @Test
    void loadPaperRejectsOverflow() {
        monoOnly.loadPaper(90); 
        assertThrows(IllegalArgumentException.class,
                () -> monoOnly.loadPaper(20)); 
    }

    @Test
    @DisplayName("printing in colour not supported → InvalidPrintModeException")
    void rejectsColourJobWhenNotSupported() {
        monoOnly.loadPaper(50);

        Book colourBook = new Book("ColourBook", 5, true,
                PaperType.REGULAR, PaperSize.A5);

        assertThrows(InvalidPrintModeException.class,
                () -> monoOnly.printEdition(colourBook, 2));
    }

    @Test
    @DisplayName("not enough paper → generic Exception")
    void rejectsWhenOutOfPaper() {
        colorCapable.loadPaper(5); 

        Book book = new Book("BigBook", 10, false,
                PaperType.REGULAR, PaperSize.A5);

        assertThrows(Exception.class,
                () -> colorCapable.printEdition(book, 1));
    }

    @Test
    @DisplayName("successful mono print updates totals")
    void successfulPrintUpdatesTotals() throws Exception {
        int copies = 2;
        int pagesPerCopy = 10;                 
        int sheetsNeeded = copies * pagesPerCopy;  

        colorCapable.loadPaper(100);

        Book book = new Book("TestBook", pagesPerCopy, false,
                PaperType.REGULAR, PaperSize.A4);

        colorCapable.printEdition(book, copies);

        assertEquals(sheetsNeeded, colorCapable.getTotalPrintedPages(),
                "Printed pages should equal copies × pages per copy");
    }
}
