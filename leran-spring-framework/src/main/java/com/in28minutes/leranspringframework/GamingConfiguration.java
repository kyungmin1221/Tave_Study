package com.in28minutes.leranspringframework;

import com.in28minutes.leranspringframework.game.GameRunner;
import com.in28minutes.leranspringframework.game.GamingConsole;
import com.in28minutes.leranspringframework.game.PackManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        var game = new PackManGame();
        return game;
    }
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}
