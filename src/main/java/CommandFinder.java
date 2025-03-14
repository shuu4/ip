import java.util.ArrayList;

public class CommandFinder extends Command {
    private final String keyword;

    public CommandFinder(String keyword) throws DukeException {
        if (keyword.trim().isEmpty()) {
            throw new DukeException(" Oops! What are you looking for?");
        }
        this.keyword = keyword.toLowerCase();
    }

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
