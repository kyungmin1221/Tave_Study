package com.in28minutes.leranspringframework;

import com.in28minutes.leranspringframework.game.GameRunner;
import com.in28minutes.leranspringframework.game.PackManGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        // var game = new MarioGame();
       // var game = new SuperContraGame();
        var game = new PackManGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
