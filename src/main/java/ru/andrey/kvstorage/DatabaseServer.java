package ru.andrey.kvstorage;

import ru.andrey.kvstorage.commands.DatabaseCommands;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    public DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            String[] command = commandText.split(" ");
            return DatabaseCommands.valueOf(command[0]).getCommand(this.env, command).execute();
        }
        catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
