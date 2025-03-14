import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new Ui instance.
     * Initializes the scanner to read user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message when starting the application.
     */
    public void showWelcome() {
        System.out.println("____________________________________________________________");
        System.out.println(" Happiness doesn't come from ratings, it comes from BOO SEOK SOON! I'm BSS!");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a goodbye message when exiting the application.
     */
    public void showGoodbye() {
        System.out.println("____________________________________________________________");
        System.out.println(" Bye! Fighting!");
        System.out.println("____________________________________________________________");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    /**
     * Reads the next command entered by the user.
     *
     * @return The user input command.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }
}
