import java.util.ArrayList;

/**
 * Handles the execution of the "find" command.
 * Searches for tasks in the list that match the given keyword.
 */
public class CommandFinder extends Command {
    private final String keyword;

    /**
     * Constructs a CommandFinder with the given search keyword.
     *
     * @param keyword The keyword to search for.
     * @throws DukeException If the keyword is empty.
     */
    public CommandFinder(String keyword) throws DukeException {
        if (keyword.trim().isEmpty()) {
            throw new DukeException(" Oops! What are you looking for?");
        }
        this.keyword = keyword.toLowerCase();
    }

    /**
     * Executes the "find" command and displays matching tasks.
     *
     * @param tasks   The task list to search in.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = tasks.findTasks(keyword);

        ui.showLine();
        if (matchingTasks.isEmpty()) {
            System.out.println(" Sorry, I can't find matching tasks :(");
        } else {
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println(" " + (i + 1) + "." + matchingTasks.get(i));
            }
        }
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
