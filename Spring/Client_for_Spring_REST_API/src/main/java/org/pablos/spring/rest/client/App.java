package org.pablos.spring.rest.client;

import org.pablos.spring.rest.client.configuration.MyConfig;
import org.pablos.spring.rest.client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmps = communication.getAllEmps();

        System.out.println(allEmps);
        System.out.println(communication.getEmp(2));

        Employee emp = new Employee("Olga", "Guz", "HR", 320);

        communication.saveEmp(emp);

        communication.deleteEmp(13);
    }

}
