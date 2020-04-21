package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.logic.Database;

public class CreateDatabase implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;

    public CreateDatabase(ExecutionEnvironment exEnv, String databaseName) {
        this.env = exEnv;
        this.databaseName = databaseName;
    }

    @Override
    public DatabaseCommandResult execute() {
        if (env.getDatabase(databaseName).isPresent()) {
            return DatabaseCommandResult.error("Database already exist");
        }
        env.addDatabase(null);
        return DatabaseCommandResult.success("Database created successfully");
    }
}
