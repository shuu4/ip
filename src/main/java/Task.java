/**
 * Represents a task in the task list.
 * This is an abstract class extended by Todo, Deadline, and Event.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with a description.
     * The task is initially marked as not done.
     *
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     * "X" means that the task is completed, while " " means the task is incomplete.
     *
     * @return "X" if the task is done, otherwise " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Converts the task into a string representation for file storage.
     * The format should be overridden by subclasses.
     *
     * @return A formatted string representing the task.
     */
    public String getDescription() {
        return this.description;
    }

    public abstract String toFileString();

    /**
     * Converts a formatted string into a {@link Task} object.
     * The string should be in the format: "Type | Status | Description | (Additional Fields)".
     *
     * @param line The formatted string representation of a task.
     * @return The corresponding Task object, or {@code null} if the format is incorrect.
     */
    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null; // Ensure at least 3 parts exist

        Task task;
        switch (parts[0]) {
        case "T":
            task = new Todo(parts[2]);
            break;
        case "D":
            if (parts.length < 4) return null; // Ensure deadline has date
            task = new Deadline(parts[2], parts[3]);
            break;
        case "E":
            if (parts.length < 5) return null; // Ensure event has start & end time
            task = new Event(parts[2], parts[3], parts[4]);
            break;
        default:
            return null;
        }

        if (parts[1].equals("1")) {
            task.markAsDone();
        }

        return task;
    }

    /**
     * Returns a formatted string representation of the task.
     *
     * @return A string containing the status and description of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
