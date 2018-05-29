package implementation;

import interfaces.ArmorPieceService;
import myType.ArmorSet;

public class Helms implements ArmorPieceService
{
    protected String name;
    protected ArmorSet set;
    protected int armor;
    protected int hp;

    public void init(String name, ArmorSet set, int armor, int hp)
    {
        this.name = name;
        this.set = set;
        this.armor = armor;
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
	public int getArmor()
	{
		return armor;
	}

	@Override
	public int getHP()
	{
		return hp;
	}
}
