package com.in28minutes.leranspringframework.game;


import org.springframework.stereotype.Component;

@Component
public class PackManGame implements GamingConsole{
    public void up() {
        System.out.println("go");
    }
    public void down() {
        System.out.println("down");
    }
    public void left() {
        System.out.println("left");
    }
    public void right() {
        System.out.println("right");
    }
}
