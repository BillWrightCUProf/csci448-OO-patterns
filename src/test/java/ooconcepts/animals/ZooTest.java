package ooconcepts.animals;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ZooTest {

    @Test
    void testZoo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Zoo zoo = (Zoo) context.getBean("zoo");
        zoo.makeAllNoises();
    }

    @Test
    void testSpringAnnotationConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ZooConfig.class);
        Zoo zoo = (Zoo) context.getBean("zoo");
        zoo.makeAllNoises();
    }
}