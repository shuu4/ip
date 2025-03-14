import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading tasks from the file and saving tasks to the file.
 */
public class Storage {
    private final String directoryPath;
    private final String filePath;


    public Storage(String filePath) {
        this.filePath = filePath;
        this.directoryPath = new File(filePath).getParent();
        ensureFileExists();
    }
    /**
     * Ensures that the storage file and directory exist. If they do not exist, they are created.
     */
    private void ensureFileExists() {
        try {
            File directory = new File(directoryPath);
            if (!directory.exists() && directory.mkdirs()) {
                System.out.println("Created directory: " + directory.getAbsolutePath());
            }

            File file = new File(filePath);
            if (!file.exists() && file.createNewFile()) {
                System.out.println("Created file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error in file existence: " + e.getMessage());
        }
    }

    /**
     * Saves the current list of tasks to the file.
     *
     * @param tasks The list of tasks to save.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the storage file into an ArrayList.
     *
     * @return The list of tasks loaded from the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                Task task = Task.fromFileString(scanner.nextLine());
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing task file found. Start with an empty list.");
        }
        return tasks;
    }
}
