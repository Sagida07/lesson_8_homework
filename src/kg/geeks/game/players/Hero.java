package kg.geeks.game.players;

import kg.geeks.game.players.Boss;
import kg.geeks.game.players.GameEntity;
import kg.geeks.game.players.HavingSuperAbility;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }
}
