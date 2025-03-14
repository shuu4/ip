public class CommandMarker extends Command {
    private final int index;

    /**
     * Constructs a CommandMarker with the specified task index.
     *
     * @param args The index of the task to mark as done.
     * @throws DukeException If the index is invalid.
     */
    public CommandMarker(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Oops! Please enter a valid task number to mark.");
        }
    }

    /**
     * Executes the "mark" command.
     * Marks the specified task as done and updates storage.
     *
     * @param tasks   The task list to modify.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     * @throws DukeException If the task index is out of bounds.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.markTask(index, storage);
        ui.showLine();
        System.out.println(" Nice! I've marked this task as done:");
        System.out.println("   " + tasks.getTask(index));
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
