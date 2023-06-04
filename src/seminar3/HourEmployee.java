package seminar3;

public class HourEmployee extends Person {

    public HourEmployee(int rate, String name, int ID) {
        super(rate, name, ID);
    }

    @Override
    public double salaryCounter() {
// среднемесячная заработная плата = 20.8 * 8 * почасовая ставка
        return 20.8 * 8 * this.rate;
    }

}
