package interfaces;

import myType.ArmorSet;

public interface WeaponService extends /*include*/ LootObjectService
{
	public String getName();
	public ArmorSet getArmorSet();
	public int getDamage();
	public int getHp();
	
    public void init(String name, ArmorSet set, int damage, int hp);
    // Pre : damage >= 0 and hp >= 0
}
