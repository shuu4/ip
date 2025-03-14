public class Deadline extends Task {
    protected String by;

    /**
     * Constructs a Deadline task with a description and a due date.
     *
     * @param description The description of the task.
     * @param by The due date/time by which the task should be completed.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Converts the deadline task into a formatted string for file storage.
     * The format follows D | <status> | <description> | <due date>.
     *
     * @return a string representation of the deadline task suitable for file storage.
     */
    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    /**
     * Returns a string representation of the deadline task, including its type, status, and due date.
     *
     * @return a formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
