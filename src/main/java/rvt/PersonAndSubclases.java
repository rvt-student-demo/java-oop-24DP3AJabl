package rvt;

public class PersonAndSubclases {
    static class Person {
        private String name;
        private String adress;

        public Person(String name, String adress) {
            this.name = name;
            this.adress = adress;
        }

        public String getName() {
            return this.name;
        }

        public String getAdress() {
            return this.adress;
        }

        public void WriteAll() {
            System.out.println(this.name);
            System.out.println("  " + this.adress);
        }
    }

    public static class Student extends Person {
        private int credits;

        public Student(String name, String adress) {
            super(name, adress);
        }
    
        public int credits() {
            return credits;
        }

        public void study() {
            credits += 1;
        }

        public void WriteAll() {
            System.out.println(super.name);
            System.out.println("  " + super.adress);
            System.out.println("  Study credits " + credits);
        }
    }

    public static class Teacher extends Person {
        private int salary;

        public Teacher(String name, String adress, int salary) {
            super(name, adress);
            this.salary = salary;
        }

        public int salary() {
            return salary;
        }

        public void WriteAll() {
            System.out.println(super.name);
            System.out.println("  " + super.adress);
            System.out.println("  salary " + salary + " euro/month");
        }
    }
    public static void main(String[] args) {
        Teacher ada = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        ada.WriteAll();
        esko.WriteAll();

        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");

        int i = 0;
        while (i < 25) {
            ollie.study();
            i = i + 1;
        }

        ollie.WriteAll();
    }
}
