package org.informatics.edition;

import org.informatics.PaperSize;
import org.informatics.PaperType;

public class Edition {
    private String title;
    private int numberOfPages;
    private boolean isColor;
    private PaperType paperType;
    private PaperSize paperSize;

    public Edition(String title, int numberOfPages, boolean isColor, PaperType paperType, PaperSize paperSize) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.isColor = isColor;
        this.paperType = paperType;
        this.paperSize = paperSize;
    }

    public String getTitle() { return title; }
    public int getNumberOfPages() { return numberOfPages; }
    public boolean isColor() { return isColor; }
    public PaperType getPaperType() { return paperType; }
    public PaperSize getPaperSize() { return paperSize; }
}
