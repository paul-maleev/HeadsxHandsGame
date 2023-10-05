package com.example.headsxhands.core;

import java.util.Random;

public abstract class Creature {
    protected final int MAX_HEALTH;
    protected int attack=1;
    protected int defence=1;
    protected int health=1;
    protected int damageM;
    protected int damageN;
    private boolean isDead = false;
    Creature(int maxHealth, int attack, int defence, int damageM, int damageN) {
        if(maxHealth<1) {
            throw new IllegalArgumentException("Health value must be at least 1 or bigger");
        }
        this.MAX_HEALTH = maxHealth;
        this.setHealth(MAX_HEALTH);
        this.setAttack(attack);
        this.setDefence(defence);
        this.setDamageM(damageM);
        this.setDamageN(damageN);

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "attack=" + attack +
                ", defence=" + defence +
                ", health=" + health +
                ", MAX_HEALTH=" + MAX_HEALTH +
                ", damage=" + damageM +" - "+damageN+

                " , isDead=" + isDead +
                '}';
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;

    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack > 0 && attack < 31) {
            this.attack = attack;
        } else {
            throw new IllegalArgumentException("Attack value must between from 1 to 30!");
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence)  {
        if (defence > 0 && defence < 31) {
            this.defence = defence;
        } else {
            throw new IllegalArgumentException("Defence value must be from 1 to 30!");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0) {
            this.setDead(true);
            this.health = 0;
        }
    }

    public int getDamageM() {
        return damageM;
    }

    public void setDamageM(int damageM)  {
        if (damageM < 1) {
            throw new IllegalArgumentException("Damage lower bound value must be at least 1 or higher!");
        }
        this.damageM = damageM;
    }

    public int getDamageN() {
        return damageN;
    }

    public void setDamageN(int damageN)  {
        if (damageN < this.getDamageM()) {
            throw new IllegalArgumentException("Damage upper bound value must be bigger than lower bound!");
        }
        this.damageN = damageN;
    }

    public String doHit(Creature creature) {
        String result = this.getClass().getSimpleName() + " didn't deal any damage to the enemy";
        if(!creature.isDead()) {
            int attackModifier = this.getAttack() - (creature.getDefence() + 1);
            attackModifier = (attackModifier < 1) ? 1 : attackModifier;
            int[] dice = new int[attackModifier];
            boolean success = false;
            int damage = 0;
            Random throwDice = new Random();
            for (int i = 0; i < dice.length; i++) {
                dice[i] = throwDice.nextInt(1, 7);
                if (dice[i] >= 5) {
                    success = true;
                    break;
                }
            }

            if (success) {
                damage = throwDice.nextInt(this.getDamageM(), this.getDamageN() + 1);
                result = this.getClass().getSimpleName() + " deals " + damage + " damage to the enemy";
                creature.setHealth(creature.getHealth() - damage);
            } else {
                result = this.getClass().getSimpleName() + " didn't deal any damage to the enemy";
            }

        }
        return result;
    }


}
