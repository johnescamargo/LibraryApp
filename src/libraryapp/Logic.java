/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

/**
 *
 * @author Johnes
 */
public class Logic {

    /**
     * Method Bubble Sort that organizes array by Year (Year Published)
     *
     * @param books
     * @param author
     */
    public void bubbleSort(Book books[], String author) {
        int n = books.length;
        Book temp = new Book();
        System.out.println("Bubble Sort Year Published" + "\n");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int a = Integer.parseInt(books[j].getYearPublished());
                int b = Integer.parseInt(books[j + 1].getYearPublished());
                if (a > b) {
                    // swap temp and books[i]
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        // Display all books by One author only
        if (author != null) {
            System.out.println("Books by Author:");
            for (int i = 0; i < books.length; i++) {
                if (books[i].getAuthor().equals(author)) {
                    System.out.println(books[i].toStringYearPubli());
                }
            }

        } else {
            // Display all books by author 
            for (Book book : books) {
                System.out.println(book.toStringYearPubli());
            }
        }
    }

    /**
     * This method calls the Quick Sort method
     *
     * @param books - receives an array of books
     * @param author - receives a string author
     */
    public void sort(Book[] books, String author) {
        int len = books.length;
        quickSort(0, len - 1, books);//call method and send params 

        // Display all books by genre and from One author only
        if (author != null) {
            System.out.println("Books by Author:");
            for (int i = 0; i < books.length; i++) {
                if (books[i].getAuthor().equals(author)) {
                    System.out.println(books[i].toStringGenre());
                }
            }

        } else {
            // Display all books by genre
            for (Book book : books) {
                System.out.println(book.toStringGenre());
            }
        }

    }

    /**
     * This method sorts array of book by Genre
     *
     * @param low_index
     * @param high_index
     * @param books
     */
    public void quickSort(int low_index, int high_index, Book[] books) {

        int i = low_index;
        int j = high_index;
        // calculate pivot number 
        Book pivot = books[low_index + (high_index - low_index) / 2];
        // Divide into two arrays
        while (i <= j) {
            // while (temp_array[i].getIsbn() < pivot.getIsbn()) {
            while (books[i].getGenre().compareTo(pivot.getGenre()) < 0) {
                i++;
            }
            while (books[j].getGenre().compareTo(pivot.getGenre()) > 0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, books);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (low_index < j) {
            quickSort(low_index, j, books);
        }
        if (i < high_index) {
            quickSort(i, high_index, books);
        }
    }

    public void exchangeNumbers(int i, int j, Book[] books) {
        Book temp = books[i];
        books[i] = books[j];
        books[j] = temp;
    }

    /**
     * This method sorts array of books by ID (ISBN)
     *
     * @param books - receives array of books
     * @param author - receives String author
     */
    public void insertionSort(Book[] books, String author) {
        Book key = new Book();
        int n = books.length;
        for (int j = 1; j < n; j++) {
            key = books[j];
            int i = j - 1;
            while ((i > -1) && (books[i].getIsbn()) > key.getIsbn()) {
                books[i + 1] = books[i];
                i--;
            }
            books[i + 1] = key;
        }

        // Display all books by ID and from One author only
        if (author != null) {
            System.out.println("Books by Author:");
            for (int i = 0; i < books.length; i++) {
                if (books[i].getAuthor().equals(author)) {
                    System.out.println(books[i].toStringIsbn());
                }
            }

        } else {
            // Display all books by ID 
            for (Book book : books) {
                System.out.println(book.toStringIsbn());
            }
        }
    }

    /**
     * This method sorts array of books by Title Selection Sort
     *
     * @param books - receives array of books
     * @param author - receives a string
     */
    public void selectionSort(Book[] books, String author) {
        Book temp = new Book();
        for (int i = 0; i < books.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].getTitle().compareTo(books[index].getTitle()) < 0) {
                    index = j;//searching for lowest index  
                }
            }
            temp = books[index];
            books[index] = books[i];
            books[i] = temp;
        }

        // Display all books by Title and from One author only
        if (author != null) {
            System.out.println("Books by Author:");
            for (int i = 0; i < books.length; i++) {
                if (books[i].getAuthor().equals(author)) {
                    System.out.println(books[i].toStringTitle());
                }
            }

        } else {
            // Display all books by Title
            for (Book book : books) {
                System.out.println(book.toStringTitle());
            }
        }
    }

    /**
     * This method search for author from array of author The array of authors
     * is already sorted
     *
     * @param authors - receives array of authors
     * @param target - receives name of author
     * @return a String - author's name
     */
    public String binarySearch(String[] authors, String target) {
        int first = 0;
        int last = authors.length - 1;
        int mid = (first + last) / 2;
        int count = 0;
        while (first <= last) {

            count++;    // allows us to count cycles
            if (authors[mid].compareTo(target) < 0) {
                first = mid + 1;
            } else if (authors[mid].compareTo(target) == 0) {
                System.out.println(target + " - Search " + target + " found at index: " + mid);
                System.out.println("search cycle count = " + count + "\n");
                return authors[mid];  // will break out of while loop
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;

        }
        if (first > last) {
            System.out.println("Search " + target + " not found!");
        }
        System.out.println("search cycle count = " + count + "\n");
        return null;

    } // end binarySearch

    /**
     * This method searches for a String in the array of books Big O notation
     *
     * @param books - receives an array of objects Book
     * @param target - receives an a string to be found in the array
     * @param author - receives an string (author) to check if the book title
     * belongs to the author
     * @return return a String
     */
    public String binarySearchTitle(Book[] books, String target, String author) {

        selectionSortTitle(books, null);// sort array before searches for target

        Book a = new Book();
        int first = 0;
        int last = books.length - 1;
        int mid = (first + last) / 2;
        int count = 0;
        while (first <= last) {

            count++;    // allows us to count cycles
            if (books[mid].getTitle().compareToIgnoreCase(target) < 0) {
                first = mid + 1;
            } else if (books[mid].getTitle().compareToIgnoreCase(target) == 0) {
                System.out.println(target + " - Search " + target + " found at index: " + mid);
                System.out.println("search cycle count = " + count + "\n");

                if (books[mid].getAuthor().equals(author)) {
                    System.out.println(books[mid].toStringTitle() + "\n");
                    return books[mid].toStringTitle();
                } else if (!books[mid].getAuthor().equals(author)) {
                    System.out.println("This book is from another author" + "\n");
                    return "";
                }

                // will break out of while loop
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Search " + target + " not found!");
        }
        System.out.println("search cycle count = " + count + "\n");
        return null;

    } // end binarySearch

    /**
     * This method sorts array of books by title
     *
     * @param books - receives an array of objects Book
     * @param author - receives an string (author) to check if the book title
     * belongs to the author
     */
    public void selectionSortTitle(Book[] books, String author) {
        Book temp = new Book();
        for (int i = 0; i < books.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].getTitle().compareTo(books[index].getTitle()) < 0) {
                    index = j;//searching for lowest index  
                }
            }
            temp = books[index];
            books[index] = books[i];
            books[i] = temp;
        }

    }

}
