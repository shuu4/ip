public class DeadlineCommandAdder extends Command {
    private final String description;
    private final String by;

    /**
     * Constructs a DeadlineCommandAdder with the specified task description and due date.
     *
     * @param args The full command input by the user, expected in the format: "task description /by due date".
     * @throws DukeException If the input format is incorrect.
     */
    public DeadlineCommandAdder(String args) throws DukeException {
        String[] parts = args.split(" /by ", 2);
        if (parts.length < 2) {
            throw new DukeException("Oops! A deadline must have a description and a due date: deadline <task> /by <date>.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    /**
     * Executes the "deadline" command.
     * Adds a new deadline task to the task list and updates storage.
     *
     * @param tasks   The task list where the new deadline task will be added.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = new Deadline(description, by);
        tasks.addTask(task, storage);
        ui.showLine();
        System.out.println(" Got it! I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.getSize() + " tasks in the list.");
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
