package org.informatics;

public class Edition {
    private String name;
    private int numberOfPages;
    private boolean isColor;

    public Edition(String name, int numberOfPages, boolean isColor) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.isColor = isColor;
    }

    public String getName() { return name; }
    public int getNumberOfPages() { return numberOfPages; }
    public boolean isColor() { return isColor; }
}
