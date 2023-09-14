package com.in28minutes.leranspringframework.game;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{
    public void up() {
        System.out.println("jump");
    }
    public void down() {
        System.out.println("go to a hole");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("Accelerate");
    }
}
