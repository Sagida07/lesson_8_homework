package kg.geeks.game.players;

import kg.geeks.game.players.Hero;

public class Spitfire extends Hero {

    private int aggressionPoints = 80;
    public Spitfire(int health, int damage, String name) {
        super(health, damage, SuperAbility.AGGRESSION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                boss.setHealth(boss.getHealth() - this.aggressionPoints);
                break;
            }
            System.out.println("Spitfire have just damaged BOSS");
            break;
        }
    }
}
