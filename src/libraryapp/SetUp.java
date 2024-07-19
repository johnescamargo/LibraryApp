/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.util.Random;

/**
 * Set books randomly
 *
 */
public class SetUp {

    //Global variables
    Random ranGen = new Random();
    Book[] books = new Book[600];//Array of Class Book

    //Authors
    String[] author = {"Agatha Christie", "Dan Brown", "Danielle Steel",
        "Dean Koontz", "J. K. Rowling", "James Patterson",
        "John Grisham", "Lee Child", "Nora Robert", "Stephen King"};
    
    //Titles
    String[] title = {"Hate it ","Love it ","Fifty Shades of some ", "A day in a ", "Lady in a ", "Run away from the ",
        "Hate ","Love ","Fifty Shades of ", "A day in ", "Lady in ", "Run away from ",
        "Master of ", "Crazy stuff of ", "Shadow of your ", "Killing in the name of ",
        "Get out of ", "What we think of ", "Call it ", "Pick a fight ", "Alice in ",
        "Ten tents in ", "Diary of ", "Pluto in ", "Burn and wear "};
    
    // Titles to be concatenated to Titles above
    String[] title1 = {"brown", "grey", "paradise", "hell", "Puppet", "House",
        "Heaven", "Hill", "mountain", "valley", "shadow", "Kerry", "Dublin", "Cork",
        "Ireland", "France", "Mianos", "New York", "London", "Agatha Christie", "Dan Brown", "Danielle Steel",
        "Dean Koontz", "J. K. Rowling", "James Patterson",
        "John Grisham", "Lee Child", "Nora Robert", "Stephen King 2","brown 2", "grey 2", "paradise 2", "hell 2", "Puppet 2", "House 2",
        "Heaven 2", "Hill 2", "mountain 2", "valley 2" , "shadow 2", "Kerry 2", "Dublin 2", "Cork 2",
        "Ireland 2", "France 2", "Mianos 2", "New York 2", "London 2", "Agatha Christie 2", "Dan Brown 2", "Danielle Steel 2",
        "Dean Koontz 2", "J. K. Rowling 2", "James Patterson 2",
        "John Grisham 2", "Lee Child 2", "Nora Robert 2", "Stephen King 2"};
    
    // Genre
    String[] genre = {"Romance", "Drama", "Adventure", "Romance Hot", "Serial Killer",
        "Thriller", "Sci-fi", "Action", "Crime", "Suspense", "Fairytale", "Fantasy",
        "Horror", "Art", "Alternate History", "Historical Fiction"};
    
    // Year Published
    String[] yearPublished = {"2005", "2006", "2007", "2008", "2009", "2010", "2011",
        "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};

    /**
     * This method populates the array of books randomly
     */
    public void setBooks() {
        createInstances();// call method

        for (int i = 0; i < books.length; i++) {
            boolean a = false;
            String title2 = title[ranGen.nextInt(title.length)];
            title2 = title2.concat(title1[ranGen.nextInt(title.length)]);

            if (i < 3) {
            } else {
                a = verifyBookSameTitle(title2, i);// call method
            }

            if (a != true) {

                books[i].setTitle(title2);
                books[i].setAuthor(author[ranGen.nextInt(author.length)]);
                books[i].setGenre(genre[ranGen.nextInt(genre.length)]);
                books[i].setYearPublished(yearPublished[ranGen.nextInt(yearPublished.length)]);
            } else {
                i--;
            }
        }
    }

    /**
     * Method that returns a boolean to inform if there is a book with the same
     * name (Title)
     *
     * @param title
     * @param i
     * @return
     */
    public boolean verifyBookSameTitle(String title, int i) {

        for (int j = 0; j < i ; j++) {
            if (books[j].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method insert instances of the object Book into array of books
     */
    public void createInstances() {
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();

        }

    }

}
