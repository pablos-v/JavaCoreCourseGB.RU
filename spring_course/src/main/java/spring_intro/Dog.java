package spring_intro;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet{
    public Dog(){
        System.out.println("Dog");
    }
    @Override
    public void voice(){
        System.out.println("- Bow-wow!");
    }
}
