package seminar3;

public class FixPayEmployee extends Person {

    public FixPayEmployee(int rate, String name, int ID) {
        super(rate, name, ID);
    }

    @Override
    public double salaryCounter() {
        return rate;
    }

}
