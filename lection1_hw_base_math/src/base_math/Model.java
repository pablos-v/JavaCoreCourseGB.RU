package base_math;

public class Model {

    private double a, b;

    public Model(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    /**
     * Сложение
     * @return возвр сумму
     */
    public double add() {
        return a + b;
    }


    public double sub() {
        return a - b;
    }

    public double mult() {
        return a * b;
    }

    /**
     * метод деления, если делитель это 0, то вернёт бесконечность
     * @return a/b or Infnity
     */
    public double div() {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return a * Double.POSITIVE_INFINITY;
        }
    }

}
