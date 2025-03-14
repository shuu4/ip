public class CommandMarker extends Command {
    private final int index;

    public CommandMarker(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Oops! Please enter a valid task number to mark.");
        }
    }

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
