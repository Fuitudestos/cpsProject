package implementation;

import interfaces.ChestService;
import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import myType.Dir;

public class Chest implements ChestService
{
    protected EnvironmentService env;
    protected Dir dir;
    protected int col;
    protected int row;

    @Override
    public EnvironmentService getEnvironment()
    {
        return env;
    }

    @Override
    public int getCol()
    {
        return col;
    }

    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public Dir getDir()
    {
        return dir;
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
        this.env = env;
        this.dir = dir;
        col = x;
        row = y;
    }

    @Override
    public LootObjectService loot()
    {
        return new Potion();
    }

    @Override
    public LootObjectService destroy()
    {
    	env = null;
    	dir = null;
    	col = 0;
    	row = 0;
    	
    	return null;
    }
}
