package decorator;

import interfaces.Mob;
import interfaces.Environment;

public abstract class MobDecorator implements Mob
{
    private Mob delegate;

    public MobDecorator(Mob delegate)
    {
        this.delegate = delegate;
    }

    //Observateurs
    public Environment getEnvironment()
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
    public Mob init(Environment env, int x, int y, Dir dir)
    {
        return delegate.init(env,x,y,dir);
    }

    //Operateurs
    public Mob forward()
    {
        return delegate.forward();
    }

    public Mob backward()
    {
        return delegate.backward();
    }

    public Mob turnLeft()
    {
        return delegate.turnLeft();
    }

    public Mob turnRight()
    {
        return delegate.turnRight();
    }

    public Mob strafeRight()
    {
        return delegate.strafeRight();
    }

    public Mob strafeLeft()
    {
        return delegate.strafeLeft();
    }
}
