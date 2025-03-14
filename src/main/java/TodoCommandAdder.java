public class TodoCommandAdder extends Command {
    private final String description;

    public TodoCommandAdder(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("Oops! You should give your todo a description.");
        }
        Task task = new Todo(description);
        tasks.addTask(task, storage);
        ui.showLine();
        System.out.println(" Got it! I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.getSize() + " tasks in the list.");
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
