package org.informatics;

import java.math.BigDecimal;

public enum PaperSize {
    A5(BigDecimal.valueOf(1.0)),
    A4(BigDecimal.valueOf(1.5)),
    A3(BigDecimal.valueOf(2.0)),
    A2(BigDecimal.valueOf(3.0)),
    A1(BigDecimal.valueOf(4.0));

    private final BigDecimal multiplier;

    PaperSize(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}
