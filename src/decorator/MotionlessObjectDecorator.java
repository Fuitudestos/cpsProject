package decorator;

import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import interfaces.MotionlessObjectService;
import myType.Dir;

public class MotionlessObjectDecorator implements MotionlessObjectService
{
    private MotionlessObjectService delegate;

    public MotionlessObjectDecorator(MotionlessObjectService delegate)
    {
        this.delegate = delegate;
    }

    protected MotionlessObjectService getDelegate()
    {
    	return delegate;
    }

    //Observateurs
    public EnvironmentService getEnvironment()
    {
        return delegate.getEnvironment();
    }

    public int getCol()
    {
        return delegate.getCol();
    }

    public int getRow()
    {
        return delegate.getRow();
    }

    public Dir getDir()
    {
        return delegate.getDir();
    }

    //Constructeur
    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
        delegate.init(env,x,y,dir);
    }

    //Operateurs
    public LootObjectService loot()
    {
        return delegate.loot();
    }

    public LootObjectService destroy()
    {
        return delegate.destroy();
    }
}
