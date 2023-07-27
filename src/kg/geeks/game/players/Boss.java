package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;
import kg.geeks.game.players.Berserk;

public class Boss extends GameEntity {
    private SuperAbility defence = SuperAbility.NONE;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    /*public void chooseDefence(kg.geeks.game.players.Hero[] heroes) {
        int randomIndex = kg.geeks.game.logic.RPG_Game.random.nextInt(heroes.length);
        kg.geeks.game.players.Hero hero = heroes[randomIndex];
        this.defence = hero.getAbility();
    }*/
    public void chooseDefence() {
        SuperAbility[] abilities = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(abilities.length - 1) + 1;
        this.defence = abilities[randomIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void attack(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                if (hero instanceof Berserk &&
                        this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    int blocked = this.getDamage() / 5;
                    ((Berserk) hero).setBlockedDamage(blocked);
                    hero.setHealth(hero.getHealth() - (this.getDamage() - blocked));
                } else {
                    hero.setHealth(hero.getHealth() - this.getDamage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " defence: " + this.defence;
    }
}
