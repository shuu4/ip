public class CommandUnmarker extends Command {
    private final int index;

    public CommandUnmarker(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Oops! Please enter a valid task number to unmark.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.unmarkTask(index, storage);
        ui.showLine();
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println("   " + tasks.getTask(index));
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
