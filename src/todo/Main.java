package todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final String TODO = "todo";

  private static final String LIST = "-l";

  private static final String ADD = "-a";

  private static final String REMOVE = "-r";

  private static final String CHECK = "-c";

  public static void main(String[] args) throws FileNotFoundException {

    if (args.length == 0) {
      System.err.println("Command line argument is missing.");
      return;
    }

    if (args.length == 1 && args[0].equals(TODO)) {
      printUsageInformation();
    }

    if (args.length == 2 && args[0].equals(TODO) && args[1].equals(LIST)) {
      printTasksList();
    } else if (args.length == 2 && args[0].equals(TODO) && args[1].equals(ADD)) {
      System.out.println("Unable to add: no task provided");
    } else if (args.length == 2 && args[0].equals(TODO) && args[1].equals(REMOVE)) {
      System.out.println("Unable to remove: no index provided");
    }

    if (args.length == 3 && args[0].equals(TODO) && args[1].equals(ADD) && !args[2].isEmpty()
        && isString(args[2])) {
      StringBuilder newTask = new StringBuilder();
      newTask.append(args[2]);
      addNewTask(newTask.toString());
    }

    if (args.length == 3 && args[0].equals(TODO) && args[1].equals(REMOVE) && !args[2].isEmpty()
        && isIntegerNumber(args[2])) {
      int taskNumber = Integer.parseInt(args[2]);
      removeTask(taskNumber);
    }
  }

  public static List<String> readFile(String inputFileName) throws FileNotFoundException {
    Path filePath = Paths.get(inputFileName);
    try {
      //System.out.println(filePath.toAbsolutePath());
      return Files.readAllLines(filePath);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File does not exist!");
    } catch (IOException e) {
      throw new RuntimeException("File does not exist!");
    }
  }

  public static void writeFile(List<String> fileContent, String outputFileName)
      throws FileNotFoundException {
    try {
      Files.write(Paths.get(outputFileName), fileContent);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File does not exist!");
    } catch (IOException e) {
      throw new RuntimeException("File does not exist!");
    }
  }

  private static boolean isIntegerNumber(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isString(String inputText) {
    if (inputText instanceof String) {
      return true;
    }
    return false;
  }

  public static void printUsageInformation() {
    System.out.println("Command Line Todo application\n"
        + "=============================\n"
        + "Command line arguments:\n"
        + "\t-l   Lists all the tasks\n"
        + "\t-a   Adds a new task\n"
        + "\t-r   Removes an task\n"
        + "\t-c   Completes an task");
  }

  public static void printTasksList() throws FileNotFoundException {
    try {
      List<String> todoNames = new ArrayList<>(readFile("src/tasks.txt"));
      List<Todo> todos = new ArrayList<>();
      for (int i = 0; i < todoNames.size(); i++) {
        todos.add(new Todo(todoNames.get(i), i + 1));
      }
      if (todos.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (Todo todo : todos) {
          todo.printAllFields();
        }
      }
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File does not exist!");
    }
  }

  private static void addNewTask(String taskDescription) throws FileNotFoundException {
    List<String> taskList = new ArrayList<>();
    List<String> oldTaskList = new ArrayList<>(readFile("src/tasks.txt"));
    for (String task : oldTaskList) {
      taskList.add(task);
    }
    taskList.add(taskDescription);
    writeFile(taskList, "src/tasks.txt");
  }

  private static void removeTask(int taskNumber) throws FileNotFoundException {
    List<String> taskList = new ArrayList<>(readFile("src/tasks.txt"));
    if (taskList.size() >= 2 && taskList.size() >= taskNumber) {
      taskList.remove(taskNumber - 1);
    }
    writeFile(taskList, "src/tasks.txt");
  }
}