public class EventCommandAdder extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructs an EventCommandAdder with the specified task description, start time, and end time.
     *
     * @param args The full command input by the user, expected in the format: "task description /from start /to end".
     * @throws DukeException If the input format is incorrect.
     */
    public EventCommandAdder(String args) throws DukeException {
        String[] parts = args.split(" /from | /to ", 3);
        if (parts.length < 3) {
            throw new DukeException("Oops! An event must have a description, a start time, and an end time: event <task> /from <start> /to <end>.");
        }
        this.description = parts[0].trim();
        this.from = parts[1].trim();
        this.to = parts[2].trim();
    }

    /**
     * Executes the "event" command.
     * Adds a new event task to the task list and updates storage.
     *
     * @param tasks   The task list where the new event task will be added.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = new Event(description, from, to);
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
