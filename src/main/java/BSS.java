/**
 * The main class that runs the task management application.
 * It initialises storage, task list, and the user interface.
 */
public class BSS {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a new BSS instance, loading stored tasks if available.
     *
     * @param filePath The file path to store task data.
     */
    public BSS(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadTasks());
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * The main entry point of the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new BSS("data/duke.txt").run();
    }
}
