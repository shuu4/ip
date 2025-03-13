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
            } else if (command.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
                if (taskIndex >= 0 && taskIndex < taskCounter) {
                    tasks[taskIndex].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[taskIndex]);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number!");
                    System.out.println("____________________________________________________________");
                }
            } else if (command.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
                if (taskIndex >= 0 && taskIndex < taskCounter) {
                    tasks[taskIndex].unmarkAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[taskIndex]);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number!");
                    System.out.println("____________________________________________________________");
                }
            } else if (command.startsWith("todo ")) {
                if (taskCounter < 100) {
                    String description = command.substring(5).trim();
                    tasks[taskCounter] = new Todo(description);
                    taskCounter++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " + tasks[taskCounter - 1]);
                    System.out.println(" Now you have " + taskCounter + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }
            } else if (command.startsWith("deadline ")) {
                if (taskCounter < 100) {
                    String[] parts = command.substring(9).split(" /by ", 2);
                    if (parts.length == 2) {
                        tasks[taskCounter] = new Deadline(parts[0].trim(), parts[1].trim());
                        taskCounter++;
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've added this task:");
                        System.out.println("   " + tasks[taskCounter - 1]);
                        System.out.println(" Now you have " + taskCounter + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("____________________________________________________________");
                        System.out.println(" Oops! Please follow the format: deadline <task> /by <date>");
                        System.out.println("____________________________________________________________");
                    }
                }
            } else if (command.startsWith("event ")) {
                if (taskCounter < 100) {
                    String[] parts = command.substring(6).split(" /from | /to ", 3);
                    if (parts.length == 3) {
                        tasks[taskCounter] = new Event(parts[0].trim(), parts[1].trim(), parts[2].trim());
                        taskCounter++;
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've added this task:");
                        System.out.println("   " + tasks[taskCounter - 1]);
                        System.out.println(" Now you have " + taskCounter + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("____________________________________________________________");
                        System.out.println(" Oops! Please follow the format: event <task> /from <start> /to <end>");
                        System.out.println("____________________________________________________________");
                    }
                }
            } else {
                if (taskCounter < 100) {
                    tasks[taskCounter] = new Task(command);
                    taskCounter++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + command);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Task list is full!");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        scanner.close();
    }
}
