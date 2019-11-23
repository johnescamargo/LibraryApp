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
     *
     * Method Bubble Sort. To organize the numbers in an array
     *
     * @param books
     */
    public void bubbleSort(Book books[]) {
        int n = books.length;
        Book temp = new Book();
        System.out.println("Bubble Sort Year Published");
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

}
