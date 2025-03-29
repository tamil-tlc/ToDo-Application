package model;


public class Task {
    private String taskText;
    private boolean isChecked;

    public Task(String taskText) {
        this.taskText = taskText;
        this.isChecked = false;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
