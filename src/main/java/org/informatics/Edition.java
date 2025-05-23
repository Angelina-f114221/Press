package org.informatics;

public class Edition {
    private String name;
    private int numberOfPages;
    private boolean isColor;
    private PaperType paperType;
    private PaperSize paperSize;

    public Edition(String name, int numberOfPages, boolean isColor, PaperType paperType, PaperSize paperSize) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.isColor = isColor;
        this.paperType = paperType;
        this.paperSize = paperSize;
    }

    public String getName() { return name; }
    public int getNumberOfPages() { return numberOfPages; }
    public boolean isColor() { return isColor; }
    public PaperType getPaperType() { return paperType; }
    public PaperSize getPaperSize() { return paperSize; }
}
