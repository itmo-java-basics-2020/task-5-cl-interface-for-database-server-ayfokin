package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class ReadKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;

    public ReadKey(ExecutionEnvironment exEnv, String dbName, String tName, String key) {
        this.env = exEnv;
        this.databaseName = dbName;
        this.tableName = tName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            return  DatabaseCommandResult.success(env.getDatabase(databaseName).get().read(tableName, key));
        }
        return DatabaseCommandResult.error("Database doesn't exist");
    }
}
