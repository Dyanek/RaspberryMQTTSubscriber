class User {
    private String userName;

    private int executedCommandsCount;
    private int executedWateringsCount;
    private int executedLightingsCount;

    String getUserName() {
        return userName;
    }

    int getExecutedCommandsCount() {
        return executedCommandsCount;
    }

    int getExecutedWateringsCount() {
        return executedWateringsCount;
    }

    int getExecutedLightingsCount() {
        return executedLightingsCount;
    }

    void increaseExecutedCommandsCount() {
        executedCommandsCount++;
    }

    void increaseExecutedWateringsCount() {
        increaseExecutedCommandsCount();
        executedWateringsCount++;
    }

    void increaseExecutedLightingsCount() {
        increaseExecutedCommandsCount();
        executedLightingsCount++;
    }

    User(String userName) {
        this.userName = userName;
        this.executedCommandsCount = 0;
        this.executedWateringsCount = 0;
        this.executedLightingsCount = 0;
    }
}
