import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task, Storage storage) {
        tasks.add(task);
        storage.saveTasks(tasks);
    }

    public void deleteTask(int index, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException(" Oops! Invalid task number. Please enter a valid task number.");
        }
        tasks.remove(index);
        storage.saveTasks(tasks);
    }

    public void markTask(int index, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException(" Oops! Invalid task number.");
        }
        tasks.get(index).markAsDone();
        storage.saveTasks(tasks);
    }

    public void unmarkTask(int index, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException(" Oops! Invalid task number.");
        }
        tasks.get(index).unmarkAsDone();
        storage.saveTasks(tasks);
    }

    public void printTasks() {
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

    public Task getTask(int index) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException(" Oops! Invalid task number.");
        }
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }
}
