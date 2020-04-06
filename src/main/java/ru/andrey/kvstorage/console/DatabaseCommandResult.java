package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new CommandResult(result, true);
    }

    static DatabaseCommandResult error(String message) {
        return new CommandResult(message, false);
    }

    class CommandResult implements DatabaseCommandResult{
        private boolean success;
        private String executionResult;

        private CommandResult(String message, boolean success) {
            this.success = success;
            this.executionResult = message;
        }

        @Override
        public Optional<String> getResult() {
            return Optional.of(executionResult);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            if (isSuccess()) {
                return DatabaseCommandStatus.SUCCESS;
            }
            return DatabaseCommandStatus.FAILED;
        }

        @Override
        public boolean isSuccess() {
            return success;
        }

        @Override
        public String getErrorMessage() {
            return executionResult;
        }
    }
}