package edu.uptap.pos.models;

public enum Status {
    IN_STOCK("IN STOCK"), OUT_OF_STOCK("OUT OF STOCK"), LOW_STOCK("LOW STOCK");

    private final String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
