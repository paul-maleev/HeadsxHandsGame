package com.example.headsxhands.core;

public class Player extends Creature {

    private int healingCounter=0;

    public Player(int maxHealth, int attack, int defence, int damageM, int damageN) {
        super(maxHealth, attack, defence, damageM, damageN);
    }

    public String selfHealing() {
        StringBuilder output = new StringBuilder();
        if(this.healingCounter<4 && this.getHealth()<(MAX_HEALTH-((int) Math.round(((double) MAX_HEALTH * 30) / 100))) && !this.isDead()) {
            output.append("Players health before the healing is "+this.getHealth()+"\n");
            int health = this.getHealth()+(int) Math.round(((double) MAX_HEALTH * 30) / 100);
            if(health>=MAX_HEALTH) {
                this.setHealth(MAX_HEALTH);
            } else {
                this.setHealth(health);
            }
            this.healingCounter++;
            output.append("Players health after the healing is "+this.getHealth()+"\n");
            output.append("The player healed himself for "+healingCounter+" time"+"\n");
        }
        return output.toString();
    }



}
