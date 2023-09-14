package com.in28minutes.leranspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.leranspringframework.game")
public class GamingAppLauncherApplication {
//    @Bean
//    public GamingConsole game() {
//        var game = new PackManGame();
//        return game;
//    }
//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        System.out.println("파라미터 : " + game);
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (GamingAppLauncherApplication.class)) {

              context.getBean(GamingConsole.class).up();
              context.getBean(GameRunner.class).run();

        }
    }
}
