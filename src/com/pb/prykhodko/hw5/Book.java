package com.pb.prykhodko.hw5;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private int editionDate;

    public Book(String bookTitle, String bookAuthor, int editionDate) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.editionDate = editionDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(int editionDate) {
        this.editionDate = editionDate;
    }

    @Override
    public String toString() {
        return bookTitle + " (" + bookAuthor + ", " + editionDate + " год)";

    }
}


