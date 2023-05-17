package base_math;

public class Model {

    private double a, b;

    public Model(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Model() {
        this.a = 0;
        this.b = 0;
    }

    public double add() {
        return a + b;
    }

    public double sub() {
        return a - b;
    }

    public double mult() {
        return a * b;
    }

    public double div() {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("division by zero");
            return a * Double.POSITIVE_INFINITY;
        }
    }
}
