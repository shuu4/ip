public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract String toFileString();

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

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
