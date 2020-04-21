package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class UpdateKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName, tableName, key, value;

    public UpdateKey (ExecutionEnvironment exEnv, String dbName, String tName, String key, String value) {
        this.env = exEnv;
        this.databaseName = dbName;
        this.tableName = tName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            env.getDatabase(databaseName).get().write(tableName, key, value);
            return DatabaseCommandResult.success("Key update successfully");
        }
        return DatabaseCommandResult.error("Database doesn't exist");
    }
}
