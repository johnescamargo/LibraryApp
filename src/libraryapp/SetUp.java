/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Set books randomly
 *
 */
public class SetUp {

    Random ranGen = new Random();
    ArrayList<Book> books = new ArrayList<>();
    String[] author = {"Stephen King", "J. K. Rowling", "James Patterson",
        "John Grisham", "Danielle Steel", "Dean Koontz", "Agatha Christie",
        "Lee Child", "Nora Roberts", "Dan Brown"};
    String[] title = {"Fifty Shades of ", "A day in ", "Lady in ", "Run away from ",
        "Master of ", "Crazy stuff of", "Shadow of your ", "Killing in the name of ",
        "Get out of ", "What we think of ", "Call it ", "Pick a fight ", "Alice in ",
        "Ten tents in ", "Diary of a ", "Pluto in ", "Burn and wear a "};
    String[] title1 = {"brown", "grey", "paradise", "hell", "Puppet", "House",
        "Heaven", "Hill", "mountains", "malleys", "shadow", "Kerry", "Dublin", "Cork",
        "Ireland", "France", "Mianos", "New York", "London"};
    String[] genre = {"Romance", "Drama", "Adventure", "Romance Hot", "Serial Killer",
        "Thriller", "Sci-fi", "Action", "Crime", "Suspense", "Fairytale", "Fantasy",
        "Horror", "Art", "Alternate History", "Historical Fiction"};
    String[] yearPublished = {"2005", "2006", "2007", "2008", "2009", "2010", "2011",
        "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};

    /**
     */
    public void setBooks() {

        for (int i = 0; i < 600; i++) {

            String title2 = title[ranGen.nextInt(title.length)];
            title2 = title2.concat(title1[ranGen.nextInt(title.length)]);
            String author2 = author[ranGen.nextInt(author.length)];
            String genre2 = genre[ranGen.nextInt(genre.length)];
            String yearPublished2 = yearPublished[ranGen.nextInt(yearPublished.length)];

            books.add(new Book(title2, author2, genre2, yearPublished2));
        }
    }

    /**
     */
    public void printBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }

    }

}
