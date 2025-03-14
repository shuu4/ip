public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        tasks.printTasks();
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
