package rvt;
import java.util.Arrays;
import java.util.Scanner;

public class toDoList {
    static class TodoList {
        private String[] arr = {};

        public TodoList () {
            this.arr = arr;
        }
        
        public void add(String task) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = task;
        }

        public void print() {
            for (int i = 0; i < arr.length; i++) {
                System.out.println((i + 1) + " " + arr[i]);
            }
        }

        public void remove(int number) {
            if (number == arr.length){
                arr = Arrays.copyOf(arr, arr.length-1);
            }else{
                for (int i=number-1; i < arr.length-1; i++) {
                    arr[i] = arr[i+1];
                }
                arr = Arrays.copyOf(arr, arr.length-1);
            }
        }

        public static class userInterface extends toDoList {
            Scanner scan = new Scanner(System.in);
            private String[] arr = {};

            public userInterface(Scanner scan) {
                super();
                this.scan = scan;
            }

            public void start() {
                String inputCom = "";
                String input = "";
                while (inputCom != "stop") {
                    System.out.print("Command: ");
                    inputCom = scan.nextLine();

                    if (inputCom == "add") {
                        System.out.print("To add: ");
                        input = scan.nextLine();

                        arr = Arrays.copyOf(arr, arr.length + 1);
                        arr[arr.length - 1] = input;
                    }

                    // remove and list
                }
            }
        }
        public static void main(String[] args) {
            TodoList list = new TodoList();
            list.add("read the course material");
            list.add("watch the latest fool us");
            list.add("take it easy");
            list.print();
            list.remove(2);
            list.print();
            list.add("buy raisins");
            list.print();
            list.remove(1);
            list.remove(1);
            list.print();
        }
    }
}
