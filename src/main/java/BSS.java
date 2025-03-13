import java.util.Scanner;

public class BSS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCounter = 0;

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
                    System.out.println("____________________________________________________________");
                    if (taskCounter == 0) {
                        System.out.println(" Gimme a task!");
                    } else {
                        System.out.println(" Here are the tasks in your list:");
                        for (int i = 0; i < taskCounter; i++) {
                            System.out.println(" " + (i + 1) + "." + tasks[i]);
                        }
                    }
                    System.out.println("____________________________________________________________");
                } else if (command.equals("todo") || command.equals("todo ")) {
                    throw new DukeException(" Oops! You should give your todo a description.");
                } else if (command.startsWith("todo ")) {
                    handleTodoCommand(command, tasks, taskCounter);
                    taskCounter++;
                } else if (command.equals("deadline") || command.equals("deadline ")) {
                    throw new DukeException(" Oops! A deadline must have a task description and a due date: deadline <task> /by <date>.");
                } else if (command.startsWith("deadline ")) {
                    handleDeadlineCommand(command, tasks, taskCounter);
                    taskCounter++;
                } else if (command.equals("event") || command.equals("event ")) {
                    throw new DukeException(" Oops! An event must have a description, a start time, and an end time: event <task> /from <start> /to <end>.");
                } else if (command.startsWith("event ")) {
                    handleEventCommand(command, tasks, taskCounter);
                    taskCounter++;
                } else if (command.equals("mark") || command.equals("mark ")) {
                    throw new DukeException(" Oops! You should specify which task number to mark as done.");
                } else if (command.startsWith("mark ")) {
                    handleMarkCommand(command, tasks, taskCounter);
                } else if (command.equals("unmark") || command.equals("unmark ")) {
                    throw new DukeException(" Oops! You should specify which task number to unmark.");
                } else if (command.startsWith("unmark ")) {
                    handleUnmarkCommand(command, tasks, taskCounter);
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

    private static void handleMarkCommand(String command, Task[] tasks, int taskCounter) throws DukeException {
        int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
        if (taskIndex >= 0 && taskIndex < taskCounter) {
            tasks[taskIndex].markAsDone();
            System.out.println("____________________________________________________________");
            System.out.println(" Nice! I've marked this task as done:");
            System.out.println("   " + tasks[taskIndex]);
            System.out.println("____________________________________________________________");
        } else {
            throw new DukeException(" Invalid task number! Please enter a valid number.");
        }
    }

    private static void handleUnmarkCommand(String command, Task[] tasks, int taskCounter) throws DukeException {
        int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
        if (taskIndex >= 0 && taskIndex < taskCounter) {
            tasks[taskIndex].unmarkAsDone();
            System.out.println("____________________________________________________________");
            System.out.println(" OK, I've marked this task as not done yet:");
            System.out.println("   " + tasks[taskIndex]);
            System.out.println("____________________________________________________________");
        } else {
            throw new DukeException(" Invalid task number! Please enter a valid number.");
        }
    }

    private static void handleTodoCommand(String command, Task[] tasks, int taskCounter) throws DukeException {
        String description = command.substring(5).trim();
        if (description.isEmpty()) {
            throw new DukeException(" Oops! You should give your todo a description.");
        }
        tasks[taskCounter] = new Todo(description);
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks[taskCounter]);
        System.out.println(" Now you have " + (taskCounter + 1) + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void handleDeadlineCommand(String command, Task[] tasks, int taskCounter) throws DukeException {
        String[] parts = command.substring(9).split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new DukeException(" Oops! A deadline must have a task description and a due date: deadline <task> /by <date>.");
        }
        tasks[taskCounter] = new Deadline(parts[0].trim(), parts[1].trim());
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks[taskCounter]);
        System.out.println(" Now you have " + (taskCounter + 1) + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void handleEventCommand(String command, Task[] tasks, int taskCounter) throws DukeException {
        String[] parts = command.substring(6).split(" /from | /to ", 3);
        if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new DukeException(" Oops! An event must have a description, a start time, and an end time: event <task> /from <start> /to <end>.");
        }
        tasks[taskCounter] = new Event(parts[0].trim(), parts[1].trim(), parts[2].trim());
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks[taskCounter]);
        System.out.println(" Now you have " + (taskCounter + 1) + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
