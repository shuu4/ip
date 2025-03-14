public class Parser {
    /**
     * Parses a user command into a Command object.
     *
     * @param fullCommand The full command input by the user.
     * @return The corresponding Command object.
     * @throws DukeException If the command is invalid.
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];
        String commandArgs = parts.length > 1 ? parts[1] : "";

        return switch (commandWord) {
            case "byeMessage" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "todo" -> new TodoCommandAdder(commandArgs);
            case "deadline" -> new DeadlineCommandAdder(commandArgs);
            case "event" -> new EventCommandAdder(commandArgs);
            case "mark" -> new CommandMarker(commandArgs);
            case "unmark" -> new CommandUnmarker(commandArgs);
            case "delete" -> new CommandDeleter(commandArgs);
            case "find" -> new CommandFinder(commandArgs);
            default -> throw new DukeException(" Sorry that I don't get your command, any specific tasks I can do for you? ^^");
        };
    }
}
