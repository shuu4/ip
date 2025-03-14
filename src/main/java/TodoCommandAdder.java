public class TodoCommandAdder extends Command {
    private final String description;

    /**
     * Constructs a TodoCommandAdder with the specified task description.
     *
     * @param description The description of the todo task.
     */
    public TodoCommandAdder(String description) {
        this.description = description;
    }

    /**
     * Executes the "todo" command.
     * Adds a new todo task to the task list and updates storage.
     *
     * @param tasks   The task list where the new todo task will be added.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     * @throws DukeException If the task description is empty.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("Oops! You should give your todo a description.");
        }
        Task task = new Todo(description);
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
