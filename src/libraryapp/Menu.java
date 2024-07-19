/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.util.Scanner;

/**
 *
 * @author Johnes
 */
public class Menu {

    //Global variable
    Scanner scan = new Scanner(System.in);

    /**
     * This Method works as Main menu to interact with the users
     *
     * @param books - receives an array of object Book
     * @param logic - receives an instance of Class Logic
     * @param setup - receives an instance of Class SetUp
     * @throws java.lang.Exception
     */
    public void mainMenu(Book[] books, Logic logic, SetUp setup) throws Exception {
        String choice = "w";

        do {
            System.out.println("________________________________________________");
            System.out.println("Welcome to the Book Shop" + "\n");
            System.out.println("Option 1: Organise and display books by Title");
            System.out.println("Option 2: Organise and display books by Genre");
            System.out.println("Option 3: Organise and display books by Year");
            System.out.println("Option 4: Organise and display books by ID (isbn)");
            System.out.println("Option 5: View all books by the same Author");
            System.out.println("Option 6: Quit Program");
            System.out.println("________________________________________________");
            choice = scan.next();

            switch (choice) {
                //-------------------------------------------------------------------                        
                case "1": //1: Organise and display books by Title
                    logic.selectionSort(books, null);//Call method
                    break;

                case "2": //2: Organise and display books by Genre
                    logic.sort(books, null);//Call method
                    break;

                case "3": //3: Organise and display books by Year
                    logic.bubbleSort(books, null);//Call method
                    break;

                case "4": //4: Organise and display books by ID (isbn)
                    logic.insertionSort(books, null);//Call method
                    break;

                case "5": //5: Organise and display books by Title and Author
                    viewBooksByAuthor(books, logic, setup);//Call method
                    break;

                case "6": //6: Quit Program
                    do {
                        //Little Menu that asks users if they want to exit
                        System.out.println("Are you sure you want to quit?");
                        System.out.println("Type ('y'/Yes or 'n'/No) ");
                        choice = scan.next();
                        if (choice.equals("y") || choice.equals("n")) {
                            if (choice.equals("n")) {
                                mainMenu(books, logic, setup);
                                break;
                            } else {
                                System.out.println("Exiting...");
                                System.exit(0);
                            }

                        } else {
                            System.out.println("You chose and invalid option. Please, "
                                    + "try again.\n");
                        }

                    } while (!choice.equals("y") || !choice.equals("n"));

                default:
                    System.out.println("You chose and invalid option. Please, "
                            + "try again.\n");
                    break;

            }

        } while (!choice.equals("i"));

    }

    /**
     * This method displays array of book sorted by author (alphabetic order)
     *
     * @param books - receives an array of object Book
     * @param logic - receives an instance of Class Logic
     * @param setup - receives an instance of Class SetUp
     * @throws java.lang.Exception
     */
    public void viewBooksByAuthor(Book[] books, Logic logic, SetUp setup) throws Exception {
        String a = "q";
        int len = setup.author.length;
        String author = "";
        do {

            for (int i = 0; i < len; i++) {
                System.out.println("Option " + (i + 1) + " for Author: " + setup.author[i]);
            }
            System.out.println("Select an Author, type a number");
            int var = tryCatchNumber();

            if (var > 0 && var <= len) {
                String author1 = setup.author[var - 1];
                author = logic.binarySearch(setup.author, author1);// call BioO method
                System.out.println(author);
                if (author == null) {
                    break;
                } else {
                    a = "w";
                }

            } else {
                System.out.println(var + " is not an a valid input. Try again " + "\n");

            }

        } while (!a.equals("w"));
        String choice = "0";

        do {

            System.out.println("Option 1: Type in one of the " + author + "'s books by Title");
            System.out.println("Option 2: Display " + author + "'s books by Genre");
            System.out.println("Option 3: Display " + author + "'s books by Year");
            System.out.println("Option 4: Display " + author + "'s books by ID (isbn)");
            System.out.println("Option 5: Exit");
            choice = catchString();

            switch (choice) {
                //-------------------------------------------------------------------                        
                case "1": //1: Display book by Title
                    System.out.println("Enter the book's name");
                    choice = catchString();
                    String response = "";
                    response = logic.binarySearchTitle(books, choice, author);//Call method
                    
                    a = "i";
                    break;

                case "2": //2: Display books by Genre
                    logic.sort(books, author);
                    break;

                case "3": //3: Display books by Year
                    logic.bubbleSort(books, author);
                    break;

                case "4": //4: Organise and display books by ID (isbn)
                    logic.insertionSort(books, author);
                    break;

                case "5": //5: Exit to Main Menu
                    a = "q";
                    break;

                default:
                    System.out.println("You chose and invalid option. Please, "
                            + "try again.\n");
                    break;

            }

        } while (!a.equals("q"));

    }

    /**
     * Method that verifies if input is an number
     *
     * @return @throws java.lang.Exception - return an Integer if it is true
     */
    public int tryCatchNumber() throws Exception {
        int var;
        Scanner scan1 = new Scanner(System.in);
        try {
            var = scan1.nextInt();
            return var;
        } catch (Exception a) {
            System.out.println(a);
        }
        return 0;

    }

    /**
     *
     * @return
     */
    public String catchString() {
        String var;
        Scanner scan1 = new Scanner(System.in);

        var = scan1.nextLine();

        return var;

    }

}
