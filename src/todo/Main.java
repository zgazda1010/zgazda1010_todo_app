public class Main {

  public static void main(String[] args) {

    if (args[0].equals("todo")) {
      printUsageInformation();
      if (args[0].equals("todo") && args[1].equals("-l")){
        printTasksList();
      }
    }
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

  private static void printTasksList() {

  }
}
