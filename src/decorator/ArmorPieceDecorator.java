package decorator;

import interfaces.ArmorPieceService;
import myType.ArmorSet;

public class ArmorPieceDecorator implements ArmorPieceService
{
    ArmorPieceService delegate;

    public ArmorPieceDecorator(ArmorPieceService delegate)
    {
        this.delegate = delegate;
    }

    public ArmorPieceService getDelegate()
    {
        return delegate;
    }

    @Override
    public void init(String name, ArmorSet set, int armor, int hp)
    {
        delegate.init(name, set, armor, hp);
    }

	@Override
	public String getName()
	{
		return delegate.getName();
	}

	@Override
	public ArmorSet getArmorSet()
	{
		return delegate.getArmorSet();
	}

	@Override
	public int getArmor()
	{
		return delegate.getArmor();
	}

	@Override
	public int getHP()
	{
		return delegate.getHP();
	}
}
