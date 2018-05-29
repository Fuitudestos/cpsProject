package implementation;

import interfaces.MapService;
import myType.Cell;

public class Map implements MapService
{
    protected Cell map[][];
    protected int height;
    protected int width;

    public Map()
    {}

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public Cell getCellNature(int x, int y)
    {
        return map[x][y];
    }

    @Override
    public void init(int w, int h)
    {
        int i;
        int j;

        width = w;
        height = h;
        map = new Cell[w][h];

        for(i = 0; i < w; i++)
        {
            for(j = 0; j < h; j++)
            {
                map[i][j] = Cell.EMP;
            }
        }
    }

    @Override
    public void openDoor(int x, int y)
    {
        if(map[x][y] == Cell.DWC) map[x][y] = Cell.DWO;
        if(map[x][y] == Cell.DNC) map[x][y] = Cell.DNO;
    }

    @Override
    public void closeDoor(int x, int y)
    {
        if(map[x][y] == Cell.DWO) map[x][y] = Cell.DWC;
        if(map[x][y] == Cell.DNO) map[x][y] = Cell.DNC;
    }
}
