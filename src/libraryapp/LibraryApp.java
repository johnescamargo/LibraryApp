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
public class LibraryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SetUp setup = new SetUp();
        Logic logic = new Logic();
        setup.setBooks();

        //  logic.bubbleSort(setup.books);//Works Bubble sort Year Published 1
        //  logic.sort(setup.books);//QuickSort works  Genre  -----------    2
        // setup.printBooks();// QuickSort works --------------
        // logic.insertionSort(setup.books); // Works -------------          3
        // setup.printBooks();// Works -----------------
        logic.selectionSort(setup.books);// Selection ----------   title     4
        setup.printBooks();
    }

}
