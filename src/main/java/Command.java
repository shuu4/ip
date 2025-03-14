/**
 * Represents an executable user command.
 * All specific commands should extend this class and implement its methods.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks   The task list to modify or retrieve data from.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to persist data.
     * @throws DukeException If the command execution encounters an error.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    /**
     * Determines whether the command is an exit command.
     *
     * @return {@code true} if the command exits the application, otherwise {@code false}.
     */
    public abstract boolean isExit();
}
