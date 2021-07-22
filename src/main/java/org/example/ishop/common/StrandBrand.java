package org.example.ishop.common;

import java.util.ArrayList;
import java.util.List;

public enum StrandBrand {
    ALICE("Alice"),
    DR("DR"),
    DADDARIO("D'Addario");

    private String title;

    StrandBrand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static List<String> getAllBrands() {
        List<String> brands = new ArrayList<>();

        for (StrandBrand el : StrandBrand.values()) {
            brands.add(el.getTitle());
        }

        return brands;
    }

}
