package org.informatics.edition;

import org.informatics.PaperSize;
import org.informatics.PaperType;

public class Edition {
    private String title;
    private int copies;
    private PaperSize size;
    private PaperType type;

    public Edition(String title, int copies, PaperSize size, PaperType type) {
        this.title = title;
        this.copies = copies;
        this.size = size;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }

    public PaperSize getSize() {
        return size;
    }

    public PaperType getType() {
        return type;
    }
}
