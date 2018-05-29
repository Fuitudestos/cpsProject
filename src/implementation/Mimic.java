package implementation;

import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import interfaces.MimicService;
import interfaces.PlayerService;
import myType.ArmorSet;
import myType.Dir;

public class Mimic implements MimicService
{
    protected EnvironmentService env;
    protected Dir dir;
    protected int col;
    protected int row;
    protected int hp;
    protected int height;
    protected boolean isAwake;

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
    public int getHP()
    {
        return hp;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public boolean isAwake()
    {
        return isAwake;
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp)
    {
        this.env = env;
        col = x;
        row = y;
        this.dir = dir;
        this.hp = hp;
        height = 250;
        isAwake = false;

    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
        //Ne sera normalement jamais appeler
    }

    @Override
    public LootObjectService loot()
    {
    	System.out.println("Coucou !");
    	
        if(!isAwake)
        {
            PlayerService player = null;

            if(getDir() == Dir.N)
            {
                player = (PlayerService) env.getCellContent(getCol(), getRow() + 1);
            }
            if(getDir() == Dir.S)
            {
                player = (PlayerService) env.getCellContent(getCol(), getRow() - 1);
            }
            if(getDir() == Dir.E)
            {
                player = (PlayerService) env.getCellContent(getCol() + 1, getRow());
            }
            if(getDir() == Dir.W)
            {
                player = (PlayerService) env.getCellContent(getCol() - 1, getRow());
            }

            player.getDamage(30);

            isAwake = true;
        }

        return null;
    }

    @Override
    public void getDamage(int nbDamage)
    {
        hp = hp - nbDamage;

        if(!isAwake) isAwake = true;
        if(hp <= 0) destroy();
    }

    @Override
    public void attack()
    {
        PlayerService player = null;

        if(getDir() == Dir.N)
        {
            player = (PlayerService) env.getCellContent(getCol(), getRow() + 1);
        }
        if(getDir() == Dir.S)
        {
            player = (PlayerService) env.getCellContent(getCol(), getRow() - 1);
        }
        if(getDir() == Dir.E)
        {
            player = (PlayerService) env.getCellContent(getCol() + 1, getRow());
        }
        if(getDir() == Dir.W)
        {
            player = (PlayerService) env.getCellContent(getCol() - 1, getRow());
        }

        if(player != null)
        {
            player.getDamage(5);
        }
    }

    @Override
    public LootObjectService destroy()
    {
        Sword loot = new Sword();
        loot.init("Greatsword of Artorias", ArmorSet.MIMIC, 15, 10);

        switch(getDir())
        {
            case N:
                ((PlayerService) getEnvironment().getCellContent(getCol(), getRow() + 1)).addLoot(loot);
                break;

            case S:
                ((PlayerService) getEnvironment().getCellContent(getCol(), getRow() - 1)).addLoot(loot);
                break;

            case E:
                ((PlayerService) getEnvironment().getCellContent(getCol() + 1, getRow())).addLoot(loot);
                break;

            case W:
                ((PlayerService) getEnvironment().getCellContent(getCol() - 1, getRow())).addLoot(loot);
                break;
        }

        return loot;
    }
}
