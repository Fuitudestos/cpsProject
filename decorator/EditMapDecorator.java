package decorator;

import interfaces.EditMap;

public class EditMapDecorator extends MapDecorator implements EditMap
{
    private EditMap delegate;

    public EditMapDecorator(EditMap delegate)
    {
        this.delegate = delegate;
    }

    @Override
    protected EditMap getDelegate()
    {
        return (EditMap) super.getDelegate();
    }

    //Observateurs
    @Override
    public boolean isReachable(int x1, int y1, int x2, int y2)
    {
        return getDelegate().isReachable(x1,y1,x2,y2);
    }

    @Override
    public boolean isReady()
    {
        return getDelegate().isReady();
    }

    //Operateurs
    @Override
    public EditMap setNature(int x, int y, Cell cell)
    {
        return getDelegate().setNature(x,y,cell);
    }
}
