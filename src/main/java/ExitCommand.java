public class ExitCommand extends Command {
    /**
     * Executes the "exit" command.
     * Displays a goodbye message and terminates the program.
     *
     * @param tasks   The task list (not used in this command).
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    /**
     * Indicates that this command is an exit command.
     *
     * @return {@code true}, since this command exits the application.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
