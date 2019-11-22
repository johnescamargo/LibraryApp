/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Johnes
 */
public class Book implements Serializable {

    private static final AtomicInteger count = new AtomicInteger(10000);
    private final int isbn;
    private String title;
    private String author;
    private String genre;
    private String yearPublished;
    private final boolean isFilled;

    /**
     *
     * @param title
     * @param author
     * @param genre
     * @param yearPublished
     */
    public Book(String title, String author, String genre, String yearPublished) {
        isFilled = false;
        isbn = count.incrementAndGet();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", author=" + author + ", genre=" + genre + ", yearPublished=" + yearPublished + ", isFilled=" + isFilled + '}';
    }

}
