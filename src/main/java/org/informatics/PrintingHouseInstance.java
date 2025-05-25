package org.informatics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PrintingHouseInstance {
    private String name;
    private final Map<PaperType, Map<PaperSize, BigDecimal>> paperPrices = new HashMap<>();

    public PrintingHouseInstance(String name) {
        this.name = name;
    }

    public void setPaperPrice(PaperType type, PaperSize size, BigDecimal price) {
        paperPrices.putIfAbsent(type, new HashMap<>());
        paperPrices.get(type).put(size, price);
    }

    public BigDecimal getPaperPrice(PaperType type, PaperSize size) {
        Map<PaperSize, BigDecimal> sizeMap = paperPrices.get(type);
        if (sizeMap == null || !sizeMap.containsKey(size)) {
            throw new IllegalArgumentException("No price defined for " + type + " " + size);
        }
        return sizeMap.get(size);
    }

    public String getName() {
        return name;
    }
}
