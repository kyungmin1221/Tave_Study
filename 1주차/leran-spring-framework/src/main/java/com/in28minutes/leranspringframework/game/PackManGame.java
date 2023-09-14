package com.in28minutes.leranspringframework.game;


import org.springframework.stereotype.Component;

// 스프링에게 객체 생성을 요청 - @Component
@Component
public class PackManGame implements GamingConsole{
    public void up() {
        System.out.println("팩맨 게임 실행 !! : go");
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
