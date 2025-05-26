package org.informatics;

import java.math.BigDecimal;

public class Paper {
    private final PaperType type;
    private PaperSize size;
    private BigDecimal basePriceA5;
    private BigDecimal increasePercentPerStep;

    public Paper(PaperType type, PaperSize size, BigDecimal basePriceA5, BigDecimal increasePercentPerStep) {
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

    public BigDecimal getBasePriceA5() {
        return basePriceA5;
    }

    public BigDecimal getIncreasePercentPerStep() {
        return increasePercentPerStep;
    }

    public BigDecimal getActualPrice() {
        return basePriceA5.multiply(size.getSizeMultiplier(increasePercentPerStep));
    }
}
