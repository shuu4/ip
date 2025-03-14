public class Parser {
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
