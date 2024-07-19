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
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // Instances of classes
        SetUp setup = new SetUp();
        Logic logic = new Logic();
        Menu menu = new Menu();

        setup.setBooks();// call method to create array of books
        menu.mainMenu(setup.books, logic, setup);// Main menu method

    }

}
