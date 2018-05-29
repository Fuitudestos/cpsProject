package decorator;

import interfaces.EntityService;
import interfaces.EnvironmentService;
import myType.Dir;

public  class EntityDecorator extends MobDecorator implements EntityService
{
    public EntityDecorator(EntityService delegate)
    {
        super(delegate);
    }

    public EntityService getDelegate()
    {
        return (EntityService) super.getDelegate();
    }

    @Override
    public int getHP()
    {
        return getDelegate().getHP();
    }

    @Override
    public int getHeight()
    {
        return getDelegate().getHeight();
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int height)
    {
        getDelegate().init(env, x, y, dir, hp, height);
    }

    @Override
    public void step()
    {
        getDelegate().step();
    }

    @Override
    public void attack()
    {
        getDelegate().attack();
    }

    @Override
    public void getDamage(int nbDamage)
    {
        getDelegate().getDamage(nbDamage);
    }
}
