package org.informatics;

import java.util.HashMap;
import java.util.Map;

public class PrintingMachine {
    private int maxPaperCapacity;
    private boolean supportsColor;
    private int pagesPerMinute;
    private int currentPaper;

    private Map<Edition, Integer> printedEditions = new HashMap<>();

    public PrintingMachine(int maxPaperCapacity, boolean supportsColor, int pagesPerMinute) {
        this.maxPaperCapacity = maxPaperCapacity;
        this.supportsColor = supportsColor;
        this.pagesPerMinute = pagesPerMinute;
        this.currentPaper = 0;
    }

    public void loadPaper(int sheets) {
        if (currentPaper + sheets > maxPaperCapacity) {
            currentPaper = maxPaperCapacity;
        } else {
            currentPaper += sheets;
        }
    }

    public void printEdition(Edition edition, int copies) throws Exception {
        if (edition.isColor() && !supportsColor) {
            throw new Exception("No colorful option.");
        }

        int totalPages = edition.getNumberOfPages() * copies;
        if (totalPages > currentPaper) {
            throw new Exception("Not enough paper for printing.");
        }

        currentPaper -= totalPages;

        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);
    }

    public int getTotalPrintedPages() {
        int total = 0;
        for (Map.Entry<Edition, Integer> entry : printedEditions.entrySet()) {
            Edition edition = entry.getKey();
            int copies = entry.getValue();
            total += edition.getNumberOfPages() * copies;
        }
        return total;
    }

    public int getCurrentPaper() {
        return currentPaper;
    }
}