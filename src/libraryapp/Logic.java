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

//    Book[] temp_array = new Book[600];
    /**
     *
     * Method Bubble Sort. To organize the numbers in an array Bubble Sort Year
     * Published
     *
     * @param books
     */
    public void bubbleSort(Book books[]) {
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
        for (int j = 0; j < books.length; j++) {
            System.out.println(books[j].toStringYearPubli());
        }
    }

    /**
     * Genre
     *
     * @param books
     */
    public void sort(Book[] books) {
        int len = books.length;
        quickSort(0, len - 1, books);
    }

    /**
     * Genre
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
     * It works
     *
     * @param books
     */
    public void insertionSort(Book[] books) {
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
    }

    /**
     * Title ------------------- ????????????
     *
     * @param books
     */
    public void selectionSort(Book[] books) {
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
