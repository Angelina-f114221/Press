package org.informatics;

import java.math.BigDecimal;

public enum PaperSize {
    A5, A4, A3, A2, A1;

    public BigDecimal getSizeMultiplier(BigDecimal increasePercent) {
        int steps = getStepsFromA5();
        BigDecimal multiplier = BigDecimal.valueOf(1.0);
        for (int i = 0; i < steps; i++) {
            multiplier = multiplier.multiply(increasePercent.add(BigDecimal.valueOf(1)));
        }
        return multiplier;
    }


    private int getStepsFromA5() {
        switch (this) {
            case A5: return 0;
            case A4: return 1;
            case A3: return 2;
            case A2: return 3;
            case A1: return 4;
            default: return 0;
        }
    }
}
