package org.informatics.edition;

import org.informatics.PaperSize;
import org.informatics.PaperType;

public class Newspaper extends Edition {
    public Newspaper(String title, int numberOfPages, boolean isColor, PaperType paperType, PaperSize paperSize) {
        super(title, numberOfPages, isColor, paperType, paperSize);
    }

    public String getEditionType() {
        return "Newspaper";
    }
}