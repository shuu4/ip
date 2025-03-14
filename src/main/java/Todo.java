public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the todo task into a formatted string for file storage.
     * The format follows "T | <status> | <description>".
     *
     * @return a string representation of the todo task suitable for file storage.
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a string representation of the todo task, including its type and status.
     *
     * @return a formatted string representing the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
