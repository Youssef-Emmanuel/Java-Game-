package game.gui;

import game.engine.titans.Titan;
import game.engine.weapons.*;

import java.util.PriorityQueue;

public class WeaponController {
    private Weapon weapon;

    public WeaponController(WeaponView weaponView) {
        this.weapon = weaponView.getWeapon();
    }

    public int performAttack(PriorityQueue<Titan> laneTitans) {
        return weapon.turnAttack(laneTitans);
    }
}
