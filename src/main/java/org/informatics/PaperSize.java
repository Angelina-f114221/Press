package org.informatics;

public enum PaperSize {
    A5(1.0),
    A4(1.5),
    A3(2.0),
    A2(3.0),
    A1(4.0);

    private final double multiplier;

    PaperSize(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
