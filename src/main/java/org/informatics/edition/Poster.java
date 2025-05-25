package org.informatics.edition;

import org.informatics.PaperSize;
import org.informatics.PaperType;

public class Poster extends Edition {
    public Poster(String title, int numberOfPages, boolean isColor, PaperType paperType, PaperSize paperSize) {
        super(title, numberOfPages, isColor, paperType, paperSize);
    }

    @Override
    public String getEditionType() {
        return "Poster";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
