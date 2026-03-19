package rvt.studenti;
import java.util.Arrays;
import java.util.Scanner;

public class stud {
    static class system {
        private String[] arr = {};
        private final String filePath = "data/Sdata.csv";

        public system() {
            this.arr = arr;
        }

        public void register(){

        }

        public void show(){

        }

        public void remove() {

        }

        public void edit(){

        }

        public boolean exit(){
            return false;
        }
    }

    public static void main(String[] args) {
        system sys = new system();
        Scanner scan = new Scanner(System.in);
        String input;
        boolean esc = true;

        while(esc == true){
            System.out.println("Our commands register, show, remove, edit, exit");
            System.out.print("Command: ");
            input = scan.nextLine();

            if (input.equals("exit")) {
                esc = sys.exit();
            }
        }
    }
}
