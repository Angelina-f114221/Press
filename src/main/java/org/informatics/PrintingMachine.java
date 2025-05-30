package org.informatics;

import org.informatics.edition.Edition;

import java.util.HashMap;
import java.util.Map;

public class PrintingMachine {
    private final int maxPaperCapacity;
    private final boolean supportsColor;
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
        if (currentPaper + sheets > maxPaperCapacity) {
            throw new IllegalArgumentException("Too many sheets!");
        }
        currentPaper += sheets;
    }

    public void printEdition(Edition edition, boolean colorRequired) throws Exception {
        if (colorRequired && !supportsColor) {
            throw new InvalidPrintModeException("No color printing");
        }

        int totalPages = edition.getCopies() * edition.getNumberOfPages();

        if (totalPages > currentPaper) {
            throw new Exception("Not enough paper for printing.");
        }

        currentPaper -= totalPages;
        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + edition.getCopies());

    }

    public int getTotalPrintedPages() {
        return printedEditions.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getNumberOfPages() * entry.getValue())
                .sum();
    }



}
