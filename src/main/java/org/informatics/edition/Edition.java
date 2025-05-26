package org.informatics.edition;
import java.math.BigDecimal;
import org.informatics.PaperSize;
import org.informatics.PaperType;
import org.informatics.PrintingHouseInstance;

public class Edition {
    private String title;
    private int copies;
    private PaperSize size;
    private PaperType type;
    private int numberOfPages;
    private boolean isColor;

    public Edition(String title, int numberOfPages, boolean isColor, PaperType type, PaperSize size) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.isColor = isColor;
        this.type = type;
        this.size = size;
        this.copies = 0;
    }

    public BigDecimal calculatePrice(PrintingHouseInstance house) {
        BigDecimal pricePerPage = house.getPaperPrice(type, size);
        BigDecimal basePrice = pricePerPage.multiply(BigDecimal.valueOf(numberOfPages));
        if (isColor) {
            basePrice = basePrice.multiply(BigDecimal.valueOf(1.5)); 
        }
        return basePrice.multiply(BigDecimal.valueOf(copies));
    }


    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public PaperSize getPaperSize() {
        return size;
    }

    public PaperType getPaperType() {
        return type;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public boolean isColor() {
        return isColor;
    }

    @Override
    public String toString() {
        return String.format("%s [title=%s, copies=%d, pages=%d, color=%b, paperType=%s, paperSize=%s]",
                getEditionType(), title, copies, numberOfPages, isColor, type, size);
    }

    public String getEditionType() {
        return "Edition";
    }
}
