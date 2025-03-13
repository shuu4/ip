import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String DIRECTORY_PATH = "data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/duke.txt";

    private static void ensureFileExists() throws IOException {
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("Created directory: " + directory.getAbsolutePath());
        }

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created file: " + file.getAbsolutePath());
        }
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        try {
            ensureFileExists();
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            ensureFileExists();
            Scanner scanner = new Scanner(new File(FILE_PATH));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromFileString(line); // Convert file format back to Task
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }
}
