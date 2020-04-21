package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateTable implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;

    public CreateTable(ExecutionEnvironment exEnv, String dbName, String tName) {
        this.env = exEnv;
        this.databaseName = dbName;
        this.tableName = tName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            env.getDatabase(databaseName).get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Table created successfully");
        }
        return DatabaseCommandResult.error("Database doesn't exist");
    }
}
