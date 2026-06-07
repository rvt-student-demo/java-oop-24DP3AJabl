package rvt;

import java.util.HashMap;
import java.util.Map;

public class IOweYou {
    private final Map<String, Double> debts;

    public IOweYou() {
        this.debts = new HashMap<>();
    }

    public IOweYou(String toWhom, double amount) {
        this();
        this.debts.put(toWhom, amount);
    }

    public void setSum(String toWhom, double amount) {
        this.debts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return this.debts.getOrDefault(toWhom, 0.0);
    }

    public static void main(String[] args) {
        IOweYou mattsIOU = new IOweYou();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));
    }
}
