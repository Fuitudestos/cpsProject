package decorator;

import interfaces.MapService;
import myType.Cell;

public class MapDecorator implements MapService
{
    private MapService delegate;

    public MapDecorator(MapService delegate)
    {
        this.delegate = delegate;
    }

    protected MapService getDelegate()
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
    public void init(int w, int h)
    {
        delegate.init(w,h);
    }

    //Operateurs
    @Override
    public void openDoor(int x, int y)
    {
        delegate.openDoor(x,y);
    }

    @Override
    public void closeDoor(int x, int y)
    {
        delegate.closeDoor(x,y);
    }
}
