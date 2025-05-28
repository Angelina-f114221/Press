public enum PaperSize {
    A5(0),
    A4(1),
    A3(2),
    A2(3),
    A1(4);

    private final int stepFromA5;

    PaperSize(int stepFromA5) {
        this.stepFromA5 = stepFromA5;
    }

    public int getStepFromA5() {
        return stepFromA5;
    }

    public BigDecimal getSizeMultiplier(BigDecimal increasePercentPerStep) {
        BigDecimal factor = BigDecimal.ONE.add(increasePercentPerStep.divide(BigDecimal.valueOf(100)));
        return factor.pow(stepFromA5);
    }
}
