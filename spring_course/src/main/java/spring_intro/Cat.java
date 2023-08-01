package spring_intro;

public class Cat implements Pet{

    @Override
    public void voice() {
        System.out.println("Meow");
    }
}
