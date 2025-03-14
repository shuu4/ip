public class CommandDeleter extends Command {
    private final int index;

    public CommandDeleter(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Oops! Please enter a valid task number to delete.");
        }
    }

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
