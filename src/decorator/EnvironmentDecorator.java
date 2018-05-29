package decorator;

import interfaces.EnvironmentService;
import interfaces.MotionlessObjectService;

public class EnvironmentDecorator extends MapDecorator implements EnvironmentService
{
    public EnvironmentDecorator(EnvironmentService delegate)
    {
        super(delegate);
    }

    public EnvironmentService getDelegate()
    {
        return (EnvironmentService) super.getDelegate();
    }

    @Override
    public void init(int width, int height)
    {
        getDelegate().init(width, height);
    }

    @Override
    public MotionlessObjectService getCellContent(int x, int y)
    {
        return getDelegate().getCellContent(x,y);
    }

    public void closeDoor(int x, int y)
    {
        getDelegate().closeDoor(x,y);
    }
}
