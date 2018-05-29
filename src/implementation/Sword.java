package implementation;

import interfaces.WeaponService;
import myType.ArmorSet;

public class Sword implements WeaponService
{
    protected String name;
    protected ArmorSet set;
    protected int damage;
    protected int hp;

    public void init(String name, ArmorSet set, int damage, int hp)
    {
        this.name = name;
        this.set = set;
        this.damage = damage;
        this.hp = hp;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public ArmorSet getArmorSet()
    {
        return set;
    }

    @Override
    public int getDamage()
    {
        return damage;
    }

    @Override
    public int getHp()
    {
        return hp;
    }
}
