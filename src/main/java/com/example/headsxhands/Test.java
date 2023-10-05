package com.example.headsxhands;

import com.example.headsxhands.core.Monster;
import com.example.headsxhands.core.Player;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Monster monster = new Monster(100,13,10,1,6);
        Player player = new Player(100,10,10,1,6);
        int c=0;

        do {
            c++;
            System.out.println("round number "+c);
            player.doHit(monster);
            System.out.println(monster);
            monster.doHit(player);
            System.out.println(player);
            player.selfHealing();
        }while (!player.isDead() && !monster.isDead());


        if(!player.isDead()) {
            System.out.println("Player has won");
        }
        if(!monster.isDead()) {
            System.out.println("Monster has won");
        }
    }
}
