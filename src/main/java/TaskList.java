import java.util.ArrayList;

/**
 * Manages a list of tasks.
 * Provides methods to add, delete, find, and modify tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with the given list of tasks.
     *
     * @param tasks The list of tasks to manage.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list and saves it in storage.
     *
     * @param task The task to be added.
     * @param storage The storage handler for saving the task.
     */
    public void addTask(Task task, Storage storage) {
        tasks.add(task);
        storage.saveTasks(tasks);
    }

    /**
     * Deletes a task from the list and updates storage.
     *
     * @param index The index of the task to be deleted.
     * @param storage The storage handler for saving the updated list.
     * @throws DukeException If the index is invalid.
     */
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

    /**
     * Finds and returns a list of tasks containing the specified keyword.
     *
     * @param keyword The search keyword.
     * @return A list of matching tasks.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        String lowerCaseKeyword = keyword.toLowerCase();

        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(lowerCaseKeyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
