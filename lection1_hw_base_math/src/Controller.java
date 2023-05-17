import base_math.Model;
import base_math.View;

import java.util.Scanner;

public class Controller {

    View view;
    Model model;

    public Controller() {
        this.view = new View();
        this.model = new Model();
        this.model.setA(Input("Enter a: "));
        this.model.setB(Input("Enter b: "));
    }

    public double Input(String s) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print(s);
            try {
                double num = in.nextDouble();
                in.close();
                return num;
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
    }

    public static void main(String[] args) {

        Controller program = new Controller();

    }
}