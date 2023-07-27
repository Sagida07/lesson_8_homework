package kg.geeks.game.players;

import kg.geeks.game.players.Boss;
import kg.geeks.game.players.Hero;

public class Magic extends Hero {
    private int increaseDamage;


    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.increaseDamage = increaseDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero: heroes) {
            if(hero.getAbility() != SuperAbility.REVIVE) {
                hero.setDamage(hero.getDamage() + this.increaseDamage);
            }
        }
    }
}
