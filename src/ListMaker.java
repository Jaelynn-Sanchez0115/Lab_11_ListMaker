import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    // Class-level ArrayList
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        boolean running = true;

        // PSEUDOCODE:
        // Create an ArrayList to store Strings
        // Create a Scanner
        // WHILE the user has not quit
        //     Display the current list
        //     Display the menu options
        //     Get the user's menu choice
        //     IF choice is A, add an item
        //     IF choice is D, delete an item
        //     IF choice is I, insert an item
        //     IF choice is P, print the list
        //     IF choice is Q, ask for confirmation
        //         If confirmed, quit the program

        System.out.println("Welcome to List Maker!");

        while (running)
        {
            displayMenu();

            String choice = SafeInput.getRegExString(
                    console,
                    "Enter your choice: ",
                    "[AaDdIiPpQq]"
            );

            choice = choice.toUpperCase();

            switch (choice)
            {
                case "A":
                    addItem(console);
                    break;

                case "D":
                    deleteItem(console);
                    break;

                case "I":
                    insertItem(console);
                    break;

                case "P":
                    printList();
                    break;

                case "Q":
                    if (SafeInput.getYNConfirm(
                            console,
                            "Are you sure you want to quit?"
                    ))
                    {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    break;
            }
        }

        console.close();
    }

    // Displays the list and menu options
    private static void displayMenu()
    {
        System.out.println("\n========== LIST MAKER ==========");

        displayNumberedList();

        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");

        System.out.println("================================");
    }

    // Displays the list with item numbers
    private static void displayNumberedList()
    {
        System.out.println("\nCurrent List:");

        if (list.isEmpty())
        {
            System.out.println("The list is currently empty.");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    // Adds an item to the end of the list
    private static void addItem(Scanner console)
    {
        System.out.print("Enter the item you want to add: ");

        String item = console.nextLine();

        list.add(item);

        System.out.println("'" + item + "' was added to the list.");
    }

    // Deletes an item from the list
    private static void deleteItem(Scanner console)
    {
        if (list.isEmpty())
        {
            System.out.println("There are no items to delete.");
            return;
        }

        displayNumberedList();

        int itemNumber = SafeInput.getRangedInt(
                console,
                "Enter the number of the item to delete",
                1,
                list.size()
        );

        String removedItem = list.remove(itemNumber - 1);

        System.out.println("'" + removedItem + "' was deleted.");
    }

    // Inserts an item at a chosen location
    private static void insertItem(Scanner console)
    {
        displayNumberedList();

        int location = SafeInput.getRangedInt(
                console,
                "Enter the location where you want to insert the item",
                1,
                list.size() + 1
        );

        System.out.print("Enter the item you want to insert: ");

        String item = console.nextLine();

        list.add(location - 1, item);

        System.out.println("'" + item + "' was inserted at position " + location + ".");
    }

    // Prints the current list
    private static void printList()
    {
        System.out.println("\n========== YOUR LIST ==========");

        displayNumberedList();

        System.out.println("================================");
    }
}
