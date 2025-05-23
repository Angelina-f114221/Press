package org.informatics;

public class Paper {
    private PaperType type;
    private PaperSize size;
    private double basePriceA5; // базова цена за A5
    private double increasePercentPerStep;

    public Paper(PaperType type, PaperSize size, double basePriceA5, double increasePercentPerStep) {
        this.type = type;
        this.size = size;
        this.basePriceA5 = basePriceA5;
        this.increasePercentPerStep = increasePercentPerStep;
    }

    public PaperType getType() {
        return type;
    }

    public PaperSize getSize() {
        return size;
    }

    public double getBasePriceA5() {
        return basePriceA5;
    }

    public double getIncreasePercentPerStep() {
        return increasePercentPerStep;
    }

    public double getActualPrice() {
        return basePriceA5 * size.getSizeMultiplier(increasePercentPerStep);
    }
}
