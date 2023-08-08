package spring_intro;

//@Component("catBean")
public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat");
    }

    @Override
    public void voice() {
        System.out.println("- Meow!");
    }
}
