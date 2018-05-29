package decorator;

import interfaces.WeaponService;
import myType.ArmorSet;

public class WeaponDecorator implements WeaponService
{
    WeaponService delegate;

    public WeaponDecorator(WeaponService delegate)
    {
        this.delegate = delegate;
    }

    public WeaponService getDelegate()
    {
        return delegate;
    }

	@Override
	public void init(String name, ArmorSet set, int damage, int hp)
	{
		delegate.init(name, set, damage, hp);
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
	public int getDamage()
	{
		return delegate.getDamage();
	}

	@Override
	public int getHp()
	{
		return delegate.getHp();
	}
}
