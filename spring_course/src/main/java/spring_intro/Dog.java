package spring_intro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("dogBean")
public class Dog implements Pet{
    public Dog(){
        System.out.println("Dog");
    }
    @PostConstruct
    public void iinnii(){
        System.out.println("init");
    }

    @PreDestroy
    public void eee(){
        System.out.println("predestroy");
    }
    @Override
    public void voice(){
        System.out.println("- Bow-wow!");
    }
}
