import base_math.Model;
import base_math.View;

public class Controller {

    View view;
    Model model;

    public Controller(double a, double b) {
        this.view = new View();
        this.model = new Model(a, b);
    }

    public String result() {
        return String.format("Number a:%5.2f, number b:%5.2f\nsum = %5.2f\ndiff = %5.2f\ndiv = %5.2f\nmult = %5.2f",
                model.getA(), model.getB(), model.add(), model.sub(), model.div(), model.mult());
    }

    public static void main(String[] args) {
        Controller program = new Controller(-3, 0);
        program.view.output(program.result());
    }
}