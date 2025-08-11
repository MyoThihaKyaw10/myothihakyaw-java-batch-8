package Day9.Exercise_9_0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

enum Priority {
    HIGH, MEDIUM, LOW
}

enum Status {
    DONE, IN_PROGRESS, UNDONE
}

class Task {
    private String description;
    private LocalDate deadline;
    private Priority priority;
    private Status status;

    public Task(String description, LocalDate deadline, Priority priority, Status status) {
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Description: %s | Deadline: %s | Priority: %s | Status: %s",
                description, deadline.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                priority, status);
    }
}

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== To-Do List ===");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. View All Tasks");
            System.out.println("4. View Tasks Sorted by Deadline");
            System.out.println("5. View Tasks Sorted by Priority");
            System.out.println("6. Remove Task");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = readInt();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> markTaskAsDone();
                case 3 -> viewAllTasks();
                case 4 -> viewTasksSortedByDeadline();
                case 5 -> viewTasksSortedByPriority();
                case 6 -> removeTask();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);
    }

    private static void addTask() {
        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        System.out.print("Enter deadline (yyyy-MM-dd): ");
        LocalDate deadline;
        try {
            deadline = LocalDate.parse(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
        Priority priority;
        try {
            priority = Priority.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid priority.");
            return;
        }

        tasks.add(new Task(desc, deadline, priority, Status.UNDONE));
        System.out.println("Task added successfully.");
    }

    private static void markTaskAsDone() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark.");
            return;
        }
        viewAllTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = readInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setStatus(Status.DONE);
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i++ + ". " + task);
        }
    }

    private static void viewTasksSortedByDeadline() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        tasks.stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .forEach(System.out::println);
    }

    private static void viewTasksSortedByPriority() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        tasks.stream()
                .sorted(Comparator.comparing(Task::getPriority))
                .forEach(System.out::println);
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        viewAllTasks();
        System.out.print("Enter task number to remove: ");
        int index = readInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static int readInt() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
