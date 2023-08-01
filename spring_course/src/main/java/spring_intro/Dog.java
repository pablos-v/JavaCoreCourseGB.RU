package spring_intro;

public class Dog implements Pet{
    @Override
    public void voice(){
        System.out.println("Bow-wow");
    }
}
