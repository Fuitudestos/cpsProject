package decorator;

import interfaces.MobService;
import myType.Dir;
import interfaces.EnvironmentService;

public class MobDecorator extends MotionlessObjectDecorator implements MobService
{
    public MobDecorator(MobService delegate)
    {
        super(delegate);
    }
    
    protected MobService getDelegate()
    {
    	return (MobService) super.getDelegate();
    }

    //Observateurs
    public EnvironmentService getEnvironment()
    {
        return getDelegate().getEnvironment();
    }

    public int getCol()
    {
        return getDelegate().getCol();
    }

    public int getRow()
    {
        return getDelegate().getRow();
    }

    public Dir getDir()
    {
        return getDelegate().getDir();
    }

    //Constructeur
    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
    	getDelegate().init(env,x,y,dir);
    }

    //Operateurs
    public void forward()
    {
    	getDelegate().forward();
    }

    public void backward()
    {
    	getDelegate().backward();
    }

    public void turnLeft()
    {
    	getDelegate().turnLeft();
    }

    public void turnRight()
    {
    	getDelegate().turnRight();
    }

    public void strafeRight()
    {
    	getDelegate().strafeRight();
    }

    public void strafeLeft()
    {
    	getDelegate().strafeLeft();
    }
}
