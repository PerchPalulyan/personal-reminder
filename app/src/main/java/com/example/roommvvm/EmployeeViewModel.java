package com.example.personalreminder;

public class TaskModel {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskDate;
    private String taskTime;
    private boolean taskRepeat;
    private boolean taskStatus;

    public TaskModel(int taskId, String taskName, String taskDescription, String taskDate, String taskTime, boolean taskRepeat, boolean taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.taskRepeat = taskRepeat;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public boolean isTaskRepeat() {
        return taskRepeat;
    }

    public void setTaskRepeat(boolean taskRepeat) {
        this.taskRepeat = taskRepeat;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }
}
