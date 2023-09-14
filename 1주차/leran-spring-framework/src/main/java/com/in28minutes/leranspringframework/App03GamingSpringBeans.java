package com.in28minutes.leranspringframework;

import com.in28minutes.leranspringframework.game.GameRunner;
import com.in28minutes.leranspringframework.game.GamingConsole;
import com.in28minutes.leranspringframework.game.PackManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.leranspringframework.game")
public class App03GamingSpringBeans {
    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (App03GamingSpringBeans.class)) {

              context.getBean(GamingConsole.class).up();
            //  context.getBean(GameRunner.class).run();


        }
    }
}
