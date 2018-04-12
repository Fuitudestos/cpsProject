package decorator;

import interfaces.Map;

public abstract class MapDecorator implements Map
{
    private Map delegate;

    public MapDecorator(Map delegate)
    {
        this.delegate = delegate;
    }

    protected Map getDelegate()
    {
        return delegate;
    }

    //Observateurs
    @Override
    public int getHeight()
    {
        return delegate.getHeight();
    }

    @Override
    public int getWidth()
    {
        return delegate.getWidth();
    }

    @Override
    public Cell getCellNature(int x, int y)
    {
        return delegate.getCellNature(x,y);
    }

    //Constructeur
    @Override
    public Map init(int w, int h)
    {
        return delegate.init(w,h);
    }

    //Operateurs
    @Override
    public Map openDoor(int x, int y)
    {
        return delegate.openDoor(x,y);
    }

    @Override
    public Map closeDoor(int x, int y)
    {
        return delegate.closeDoor(x,y);
    }
}
