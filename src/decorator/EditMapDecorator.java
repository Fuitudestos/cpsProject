package decorator;

import interfaces.EditMapService;
import myType.Cell;

public class EditMapDecorator extends MapDecorator implements EditMapService
{
    public EditMapDecorator(EditMapService delegate)
    {
        super(delegate);
    }
    
    protected EditMapService getDelegate()
    {
    	return (EditMapService) super.getDelegate();
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
    public void setNature(int x, int y, Cell cell)
    {
        getDelegate().setNature(x,y,cell);
    }
}
