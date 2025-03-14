public class CommandDeleter extends Command {
    private final int index;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param args The index of the task to delete.
     * @throws DukeException If the task index is invalid.
     */
    public CommandDeleter(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Oops! Please enter a valid task number to delete.");
        }
    }

    /**
     * Executes the "delete" command.
     * Removes the specified task from the task list and updates storage.
     *
     * @param tasks   The task list to modify.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     * @throws DukeException If the task index is out of bounds.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.getSize()) {
            throw new DukeException("Oops! Invalid task number.");
        }

        Task removedTask = tasks.getTask(index);
        tasks.deleteTask(index, storage);

        ui.showLine();
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + removedTask);
        System.out.println(" Now you have " + tasks.getSize() + " tasks in the list.");
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
