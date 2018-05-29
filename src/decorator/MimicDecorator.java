package decorator;

import interfaces.EnvironmentService;
import interfaces.MimicService;
import myType.Dir;

public class MimicDecorator extends MotionlessObjectDecorator implements MimicService
{
    public MimicDecorator(MimicService delegate)
    {
        super(delegate);
    }

    protected MimicService getDelegate()
    {
        return (MimicService) super.getDelegate();
    }
    
    public int getHP()
    {
    	return getDelegate().getHP();
    }
    
    public int getHeight()
    {
    	return getDelegate().getHeight();
    }
    
    public boolean isAwake()
    {
    	return getDelegate().isAwake();
    }
    
    public void getDamage(int nbDamage)
    {
    	getDelegate().getDamage(nbDamage);
    }

    public void init(EnvironmentService env, int x, int y, Dir dir, int hp)
    {
    	getDelegate().init(env, x, y, dir, hp);
    }

    public void attack()
    {
    	getDelegate().attack();
    }
}
