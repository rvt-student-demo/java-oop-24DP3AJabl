package rvt;
import java.util.Arrays;
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.lang.Integer;

public class toDoList {
    static class TodoList {
        private String[] arr = {};
        private final String filePath = "data/todo.csv";

        public TodoList () {
            this.arr = arr;
        }
        
        public void loadFiles() {
            try (Scanner Reader = new Scanner(filePath)) {
                while (Reader.hasNextLine()) {
                    String data = Reader.nextLine();
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = data;
                }   
            }
        }  

        public int getLastId(){
            if (arr.length == 0) {
                return 0;
            }
            String str = arr[arr.length - 1];
            String[] tokens = str.split(",");
            return Integer.parseInt(tokens[0]);
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
        private String[] arr = {};

        public userInterface() {
            super();
        }

        public void start() {
            Scanner scan = new Scanner(System.in);
            String inputCom = "";
            String input = "";

            while (inputCom != "stop") {    //                                 NESTRADA
                System.out.print("Command: ");
                inputCom = scan.nextLine();

                if (inputCom == "add") {
                    System.out.print("To add: ");
                    input = scan.nextLine();

                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = input;
                }

                if (inputCom == "list") {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println((i + 1) + " " + arr[i]);
                    }
                }
                    
                if (inputCom == "remove") {
                    System.out.print("Which one is removed?: ");
                    int number = scan.nextInt();

                    if (number == arr.length){
                        arr = Arrays.copyOf(arr, arr.length-1);
                    }else{
                        for (int i=number-1; i < arr.length-1; i++) {
                        arr[i] = arr[i+1];
                    }
                    arr = Arrays.copyOf(arr, arr.length-1);
                    }
                }
            }
        }
    }
        public static void main(String[] args) {
            userInterface list = new userInterface();

            list.start();
        }
    }
}
