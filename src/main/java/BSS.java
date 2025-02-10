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
            String command = scanner.nextLine();

            if (command.equals("bye")) {
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
                        System.out.println(" " + (i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (command.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
                if (taskIndex >= 0 && taskIndex < taskCounter) {
                    tasks[taskIndex].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   [" + tasks[taskIndex].getStatusIcon() + "] " + tasks[taskIndex].description);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number!");
                    System.out.println("____________________________________________________________");
                }
            } else if (command.startsWith("unmark ")) {
                int task_index = Integer.parseInt(command.split(" ")[1]) - 1;
                if (task_index >= 0 && task_index < taskCounter) {
                    tasks[task_index].unmarkAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   [" + tasks[task_index].getStatusIcon() + "] " + tasks[task_index].description);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number!");
                    System.out.println("____________________________________________________________");
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