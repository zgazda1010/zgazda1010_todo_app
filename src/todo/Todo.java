package todo;

public class Todo {

  private String taskName;

  private int taskNumber;

  private boolean checked;

  public Todo(String taskName, int taskNumber) {
    this.taskName = taskName;
    this.taskNumber = taskNumber;
  }

  public Todo(String taskName, int taskNumber, boolean checked) {
    this.taskName = taskName;
    this.taskNumber = taskNumber;
    this.checked = false;
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

  public boolean isChecked() {
    return checked;
  }

  public Todo readLineFromFile(String line) {
    String text = line.substring(4);
    boolean checked = text.startsWith("[x] ");
    return new Todo(text, taskNumber, checked);
  }

  public void setChecked() {
    this.checked = true;
  }

  @Override
  public String toString() {
    return (taskNumber + " - " + taskName);
  }

  public String toCheckedString() {
    return taskNumber + " - [" + (checked ? "x" : " ") + "] " + taskName;
  }

  public void printAllFields() {
    System.out.println(this);
  }
}
