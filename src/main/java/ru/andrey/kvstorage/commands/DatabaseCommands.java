package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Should be 1 argument");
            }
            return new CreateDatabase(env, args[1]);
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            if (args.length != 3) {
                throw new IllegalArgumentException("Should be 2 arguments");
            }
            return new CreateTable(env, args[1], args[2]);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            if (args.length != 5) {
                throw new IllegalArgumentException("Should be 4 arguments");
            }
            return new UpdateKey(env, args[1], args[2], args[3], args[4]);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            if (args.length != 4) {
                throw new IllegalArgumentException("Should be 3 arguments");
            }
            return new ReadKey(env, args[1], args[2], args[3]);
        }
    };
    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] args);
}


