package Commands;

import java.util.HashMap;

public class CommandList {
    HashMap<String, Command> commands;

    public CommandList() {
        commands = new HashMap<>();

        Command command = new MoveCommand();
        commands.put(command.getName(), command);

        command = new HelpCommand(this);
        commands.put(command.getName(), command);

        command = new SearchCommand();
        commands.put(command.getName(), command);

        command = new UseCommand();
        commands.put(command.getName(), command);

        command = new MapCommand();
        commands.put(command.getName(), command);

        command = new BagCommand();
        commands.put(command.getName(), command);

        command = new ExitCommand();
        commands.put(command.getName(), command);
    }

    public Command getKey(String key) {
        return commands.get(key);
    }

    public void printAll() {
        for (String command : commands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
