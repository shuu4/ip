import java.util.ArrayList;
import java.util.Scanner;

public class BSS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("____________________________________________________________");
        System.out.println(" 행복은 성적순이 아니라 부석순! I'm BSS!");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String command = scanner.nextLine().trim();

            try {
                if (command.equals("byeMessage")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Bye! Fighting 해야지!");
                    System.out.println("____________________________________________________________");
                    break;
                } else if (command.equals("list")) {
                    printTaskList(tasks);
                } else if (command.startsWith("todo")) {
                    handleTodoCommand(command, tasks);
                } else if (command.startsWith("deadline")) {
                    handleDeadlineCommand(command, tasks);
                } else if (command.startsWith("event")) {
                    handleEventCommand(command, tasks);
                } else if (command.startsWith("mark")) {
                    handleMarkCommand(command, tasks);
                } else if (command.startsWith("unmark")) {
                    handleUnmarkCommand(command, tasks);
                } else if (command.startsWith("delete")) {
                    handleDeleteCommand(command, tasks);
                } else {
                    throw new DukeException(" Sorry that I don't get your command, any specific tasks I can do for you? ^^ ");
                }
            } catch (DukeException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            } catch (Exception e) {
                System.out.println("____________________________________________________________");
                System.out.println(" Unexpected error: " + e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }
        scanner.close();
    }

    private static void printTaskList(ArrayList<Task> tasks) {
        System.out.println("____________________________________________________________");
        if (tasks.isEmpty()) {
            System.out.println(" Gimme a task!");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(" " + (i + 1) + "." + tasks.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }

    private static void handleMarkCommand(String command, ArrayList<Task> tasks) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                throw new DukeException(" Oops! Invalid task number. Please enter a valid task number.");
            }

            tasks.get(taskIndex).markAsDone();
            System.out.println("____________________________________________________________");
            System.out.println(" Nice! I've marked this task as done:");
            System.out.println("   " + tasks.get(taskIndex));
            System.out.println("____________________________________________________________");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new DukeException(" Oops! Please enter a valid task number to mark.");
        }
    }


    private static void handleUnmarkCommand(String command, ArrayList<Task> tasks) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                throw new DukeException(" Oops! Invalid task number. Please enter a valid task number.");
            }

            tasks.get(taskIndex).unmarkAsDone();
            System.out.println("____________________________________________________________");
            System.out.println(" OK, I've marked this task as not done yet:");
            System.out.println("   " + tasks.get(taskIndex));
            System.out.println("____________________________________________________________");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new DukeException(" Oops! Please enter a valid task number to unmark.");
        }
    }


    private static void handleTodoCommand(String command, ArrayList<Task> tasks) throws DukeException {
        if (command.length() <= 5 || command.substring(5).trim().isEmpty()) {
            throw new DukeException(" Oops! You should give your todo a description.");
        }

        String description = command.substring(5).trim();
        tasks.add(new Todo(description));
        printTaskAdded(tasks);
    }


    private static void handleDeadlineCommand(String command, ArrayList<Task> tasks) throws DukeException {
        if (command.length() <= 9 || !command.contains(" /by ") || command.substring(9).split(" /by ", 2).length < 2 || command.substring(9).split(" /by ", 2)[0].trim().isEmpty() || command.substring(9).split(" /by ", 2)[1].trim().isEmpty()) {

            throw new DukeException(" Oops! A deadline must have a task description and a due date: deadline <task> /by <date>.");
        }

        String[] parts = command.substring(9).split(" /by ", 2);
        tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));
        printTaskAdded(tasks);
    }



    private static void handleEventCommand(String command, ArrayList<Task> tasks) throws DukeException {
        if (command.length() <= 6 || !command.contains(" /from ") || !command.contains(" /to ") || command.substring(6).split(" /from | /to ", 3).length < 3 ||
                command.substring(6).split(" /from | /to ", 3)[0].trim().isEmpty() || command.substring(6).split(" /from | /to ", 3)[1].trim().isEmpty() || command.substring(6).split(" /from | /to ", 3)[2].trim().isEmpty()) {

            throw new DukeException(" Oops! An event must have a description, a start time, and an end time: event <task> /from <start> /to <end>.");
        }

        String[] parts = command.substring(6).split(" /from | /to ", 3);
        tasks.add(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
        printTaskAdded(tasks);
    }


    private static void handleDeleteCommand(String command, ArrayList<Task> tasks) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                throw new DukeException(" Oops! Invalid task number. Please enter a valid task number.");
            }

            Task removedTask = tasks.remove(taskIndex);
            System.out.println("____________________________________________________________");
            System.out.println(" Noted. I've removed this task:");
            System.out.println("   " + removedTask);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("____________________________________________________________");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new DukeException(" Oops! Please enter a valid task number to delete.");
        }
    }


    private static void printTaskAdded(ArrayList<Task> tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it! I've added this task:");
        System.out.println("   " + tasks.get(tasks.size() - 1));
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
