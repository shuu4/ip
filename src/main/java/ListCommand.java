public class ListCommand extends Command {
    /**
     * Executes the "list" command.
     * Displays all tasks currently stored.
     *
     * @param tasks   The task list to retrieve data from.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        tasks.printTasks();
        ui.showLine();
    }

    /**
     * Shows that this command does not exit the application.
     *
     * @return {@code false}, since the command continues execution.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
