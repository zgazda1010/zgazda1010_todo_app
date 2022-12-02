package todo;

public class Todo {

  private String taskName;

  private int taskNumber;

  public Todo(String taskName, int taskNumber) {
    this.taskName = taskName;
    this.taskNumber = taskNumber;
  }

  public String getTaskName() {
    return this.taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public int getTaskNumber() {
    return this.taskNumber;
  }

  public void setTaskNumber(int taskNumber) {
    this.taskNumber = taskNumber;
  }

  @Override
  public String toString() {
    return (taskNumber + " - " + taskName);
  }

  public void printAllFields() {
    System.out.println(this);
  }
}
