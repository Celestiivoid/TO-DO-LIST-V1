import java.util.Scanner;
import java.util.ArrayList;
public class TODOLIST {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> array = new ArrayList<>();
    public static void main(String[] args) {
        while(true) {
            System.out.println("=====T0-DO-LIST=====");
            System.out.println("[1] Add Task");
            System.out.println("[2] View Tasks");
            System.out.println("[3] Remove Task");
            System.out.println("[4] Exit");

            System.out.println("Enter an option: ");
            int option = -1;

            try {
                option = Integer.parseInt(scanner.nextLine());
                if(option < 1 || option >= 5) {
                    System.out.println("Out of range!");
                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            switch(option) {
                case 1 -> ADD();
                case 2 -> VIEW();
                case 3 -> REMOVE();
                case 4 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String action = scanner.nextLine();

                        if(action.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(action.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input! Try again!");
                            continue;
                        }
                    }
                }
            }
        }
    }
    static void ADD() {
        while(true) {
            System.out.println("=====ADD-MENU=====");
            System.out.println("Enter a task: ");
            String task = scanner.nextLine();

            if(task.isEmpty()) {
                System.out.println("Task field cannot be empty.");
                continue;
            }

            array.add(task);
            System.out.println("Successfully added: " + task);
            return;
        }

    }
    static void VIEW() {
        System.out.println("=====VIEW-MENU=====");
        
        if(array.isEmpty()) {
            System.out.println("Task is empty!");
            return;
        }
        for(int i = 0; i < array.size(); i++) {
            System.out.println((i + 1) + "." + array.get(i));
        }
    }
    static void REMOVE() {
        while(true) {
            System.out.println("===== REMOVE-MENU=====");

            if(array.isEmpty()) {
                System.out.println("Nothing to remove.");
                return;
            }

            for(int i = 0; i < array.size(); i++) {
                System.out.println((i + 1) + "." + array.get(i));
            }

            System.out.println("Pick a task to remove: ");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }
            if(option < 1 || option > array.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {
                String removed = array.remove(option - 1);
                System.out.println("Successfully removed: " + removed);
                return;
            }
        }
    }
}