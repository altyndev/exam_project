package peaksoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import peaksoft.config.WebAppConfig;

import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(WebAppConfig.class);

        EntityManagerFactory managerFactory = applicationContext.getBean(
                "emf", EntityManagerFactory.class);



            managerFactory.close();




    }
}
