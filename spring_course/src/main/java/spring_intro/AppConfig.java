package spring_intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration // так помечается класс с конфигами Спринга
@PropertySource("myApp.properties") // указать файл со значениями переменных
public class AppConfig {
    @Bean // Аннотация @Bean перехватывает все обращения к бину и регулирует его создание
    public Pet catBean() { //Название метода – это bean id.
        return new Cat();
    }

    @Bean
    public Pet dogBean() {
        return new Dog();
    }

    @Bean
    @Scope("prototype")
    public Person personBean() {
        return new Person(dogBean());
    }


}
