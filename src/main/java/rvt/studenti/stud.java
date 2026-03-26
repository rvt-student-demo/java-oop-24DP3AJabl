package rvt.studenti;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class stud {
    static class system {
        private String[] arr = {};
        private final String filePath = "data/Sdata.csv";

        public system() {
            this.arr = arr;
        }

        public void register(String dat){
            try (FileWriter myWriter = new FileWriter(filePath, true)) {
                myWriter.write("\n" + dat);
                System.out.println("Successfully appended to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public void show(){

        }

        public void remove(int i) throws IOException {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            if (i > 0 && i < lines.size()) {
                lines.remove(i);
            }

            Files.write(Paths.get(filePath), lines);
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
        Scanner Lscan = new Scanner(System.in);
        String input;
        String localInput;
        boolean esc = true;

        while(esc == true){
            System.out.println("");
            System.out.println("Our commands register, show, remove, edit, exit");
            System.out.print("Command: ");
            input = scan.nextLine();
            System.out.println("");

            if (input.equals("exit")) {
                esc = sys.exit();
                System.out.println("BYE BYE HIHI HAHA :)");
            }

            if (input.equals("register")) {
                System.out.println("What you need to write in (Writing exp: Vards,Uzvards,E-pasts,Personal kods,Registracijas datums,laiks): ");
                localInput = Lscan.nextLine();
                if (localInput.length() < 130){
                    sys.register(localInput);
                }else{
                    System.out.println("tooo many symbols: ");
                }
            }

            if (input.equals("remove")) {
                System.out.println("What you need to delete (write index): ");
                localInput = Lscan.nextLine();
                try {
                    sys.remove(Integer.parseInt(localInput));         // pri udaleniji esli dobavi na tom meste ostajetsa probel
                } catch (IOException e) {
                    System.out.println("err: " + e);
                }
            }
        }
    }
}
