package spring_intro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // так помечается класс с конфигами Спринга
@ComponentScan("spring_intro") // этот пакет сканировать на Бины и зависимости
@PropertySource("myApp.properties") // указать файл со значениями переменных
public class AppConfig {
}
