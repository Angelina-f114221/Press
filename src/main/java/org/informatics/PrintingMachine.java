package org.informatics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PrintingMachine {
    private int maxPaperCapacity;
    private boolean supportsColor;
    private int pagesPerMinute;
    private int currentPaper;

    private Map<Edition, Integer> printedEditions = new HashMap<>();

    public PrintingMachine(int maxPaperCapacity, boolean supportsColor, int pagesPerMinute) {
        if (maxPaperCapacity <= 0) {
            throw new IllegalArgumentException("Paper capacity must be greater than zero.");
        }
        if (pagesPerMinute <= 0) {
            throw new IllegalArgumentException("Pages per minute must be greater than zero.");
        }

        this.maxPaperCapacity = maxPaperCapacity;
        this.supportsColor = supportsColor;
        this.pagesPerMinute = pagesPerMinute;
        this.currentPaper = 0;
    }

    public void loadPaper(int sheets) {
        if (sheets <= 0) {
            throw new IllegalArgumentException("Number of sheets must be greater than zero.");
        }

        currentPaper = Math.min(currentPaper + sheets, maxPaperCapacity);
    }

    public void printEdition(Edition edition, int copies) throws Exception {
        if (edition == null) {
            throw new IllegalArgumentException("Edition cannot be null.");
        }
        if (copies <= 0) {
            throw new IllegalArgumentException("Number of copies must be greater than zero.");
        }

        if (edition.isColor() && !supportsColor) {
            throw new Exception("This machine does not support color printing.");
        }

        BigDecimal pagesPerCopy = BigDecimal.valueOf(edition.getNumberOfPages());
        BigDecimal totalPages = pagesPerCopy.multiply(BigDecimal.valueOf(copies));

        if (totalPages.intValue() > currentPaper) {
            throw new Exception("Not enough paper for printing.");
        }

        currentPaper -= totalPages.intValue();

        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);
    }

    public int getTotalPrintedPages() {
        int total = 0;
        for (Map.Entry<Edition, Integer> entry : printedEditions.entrySet()) {
            Edition edition = entry.getKey();
            if (edition != null) {
                int pages = edition.getNumberOfPages();
                total += pages * entry.getValue();
            }
        }
        return total;
    }

    public int getCurrentPaper() {
        return currentPaper;
    }
}
