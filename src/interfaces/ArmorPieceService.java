package interfaces;

import myType.ArmorSet;

public interface ArmorPieceService extends /*include*/ LootObjectService
{
	public String getName();
	public ArmorSet getArmorSet();
	public int getArmor();
	public int getHP();
	
	public void init(String name, ArmorSet set, int armor, int hp);
    // Pre : armor >= 0 and hp >= 0
}
