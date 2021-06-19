package org.example.ishop.common;

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
}
