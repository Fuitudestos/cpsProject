package implementation;

import java.util.ArrayList;

import interfaces.ArmorPieceService;
import interfaces.EntityService;
import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import interfaces.MimicService;
import interfaces.MotionlessObjectService;
import interfaces.PlayerService;
import interfaces.PotionService;
import interfaces.WeaponService;
import myType.Cell;
import myType.Command;
import myType.Dir;

public class Player implements PlayerService
{
    protected EnvironmentService env;
    protected int row;
    protected int col;
    protected int hp;
    protected int hpMax;
    protected int height;
    protected Dir dir;
    protected Command lastcommand;

    protected int nbPotion;
    protected ArrayList<LootObjectService> inventaire;
    protected ArrayList<PotionService> potions;

    protected ArmorPieceService helm;
    protected ArmorPieceService chest;
    protected ArmorPieceService leg;

    protected WeaponService rightHand;
    protected WeaponService leftHand;

    @Override
    public Command getLastCommand()
    {
        return lastcommand;
    }

    @Override
    public MotionlessObjectService getContent(int x, int y)
    {
        switch(getDir())
        {
            case N:
                return getEnvironment().getCellContent(getCol() + x, getRow() + y);
            case S:
                return getEnvironment().getCellContent(getCol() - x, getRow() - y);
            case E:
                return getEnvironment().getCellContent(getCol() + y, getRow() - x);
            case W:
                return getEnvironment().getCellContent(getCol() - y, getRow() + x);
        }
        return null;
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int height)
    {
        this.env = env;
        row = y;
        col = x;
        this.dir = dir;
        this.hp = hp;
        this.height = height;

        hpMax = hp;
        lastcommand = null;
        nbPotion = 0;
        helm = null;
        chest = null;
        leg = null;
        rightHand = null;
        leftHand = null;

        inventaire = new ArrayList<LootObjectService>();
        potions = new ArrayList<PotionService>();
    }

    @Override
    public Cell getNature(int x, int y)
    {
        switch(getDir())
        {
            case N:
                return getEnvironment().getCellNature(getCol() + x, getRow() + y);
            case S:
                return getEnvironment().getCellNature(getCol() + x, getRow() - y);
            case E:
                return getEnvironment().getCellNature(getCol() + y, getRow() + x);
            case W:
                return getEnvironment().getCellNature(getCol() - y, getRow() + x);
        }
        return null;
    }

    public Cell isViewable(int col, int row)
    {
        int x = col - this.getCol();
        int y = row -  this.getRow();
        // Move camera

        switch(getDir())
        {
            case W:
                x += 2;
                if (Math.abs(x) < 4 && Math.abs(y) < 3)
                    if(!viewBlocked(col, row))
                        return getEnvironment().getCellNature(col, row);
                return null;
            case E:
                x -= 2;
                if (Math.abs(x) < 4 && Math.abs(y) < 3)
                    if(!viewBlocked(col, row))
                        return getEnvironment().getCellNature(col, row);
                return null;
            case N:
                y -= 2;
                if (Math.abs(x) < 3 && Math.abs(y) < 4)
                    if(!viewBlocked(col, row))
                        return getEnvironment().getCellNature(col, row);
                return null;
            case S:
                y += 2;
                if (Math.abs(x) < 3 && Math.abs(y) < 4)
                    if(!viewBlocked(col, row))
                        return getEnvironment().getCellNature(col, row);
                return null;
            default:
                System.out.println(getDir());
        }
        return null;
    }

    public boolean isIn(ArrayList<Cell> cells, Cell c)
    {
        for(Cell c_tmp : cells)
        {
            if(c==c_tmp)
            {
                return true;
            }
        }
        return false;
    }

    public boolean viewBlocked(int col,int row)
    {
        int x = col - this.getCol();
        int y = row - this.getRow();
        ArrayList<Cell> cells_to_test = new ArrayList<>();
        cells_to_test.add(Cell.WLL);
        cells_to_test.add(Cell.DWC);
        cells_to_test.add(Cell.DNC);

        return false;
    }

    @Override
    public Cell getViewable(int dx, int dy)
    {
        int x,y;

        ArrayList<Cell> cells_to_test = new ArrayList<>();
        cells_to_test.add(Cell.WLL);
        cells_to_test.add(Cell.DWC);
        cells_to_test.add(Cell.DNC);

        switch(getDir())
        {
            case N:
                x=dx;
                y=dy;
                break;
            case S:
                x=dx;
                y=-dy;
                break;
            case E:
                x=dy;
                y=dx;
                break;
            case W:
                x=dy;
                y=-dx;
                break;
            default:
                x=0;
                y=0;
                break;
        }

        if(x<=2 && x>=-2)
        {
            if(x==-2 || x == 2 )
            {
                if(y==0||y==1||y==-1)
                {
                    if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-1)))
                        return this.getNature(x, y);
                }

                if(y==2)
                {
                    if(!isIn(cells_to_test,this.getNature(0, y-1)))
                    {
                        if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-1)))
                            return this.getNature(x, y);
                    }
                }
                else
                if(y==4)
                {
                    if(x==0)
                    {
                        if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-1)))
                            if(!isIn(cells_to_test,this.getNature(x, y-1)))
                            {
                                if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-2)))
                                    if(!isIn(cells_to_test,this.getNature(x, y-2)))
                                    {
                                        if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-3)))
                                            if(!isIn(cells_to_test,this.getNature(x, y-3)))
                                            {
                                                return this.getNature(x, y);
                                            }
                                    }
                            }
                    }
                }
                else if(y==3)
                {
                    if(this.getViewable(x, y-1)!=null)
                    {
                        if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-1)))
                            if(!isIn(cells_to_test,this.getNature(x, y-1)))
                            {
                                if(!isIn(cells_to_test,this.getNature(x+(x==2?-1:1), y-2)))
                                    if(!isIn(cells_to_test,this.getNature(x, y-2)))
                                    {
                                        return this.getNature(x, y);
                                    }
                            }
                    }
                }
            }
            else
            {
                if(y==0||y==1||y==-1)
                {
                    return this.getNature(x, y);
                }
                if(y==2)
                {
                    if(!isIn(cells_to_test,this.getNature(0, y-1)))
                    {
                        return this.getNature(x, y);
                    }
                }
                else
                if(y==4)
                {
                    if(x==0)
                    {
                        if(!isIn(cells_to_test,this.getNature(x, y-1)))
                        {
                            if(!isIn(cells_to_test,this.getNature(x, y-2)))
                            {
                                if(!isIn(cells_to_test,this.getNature(x, y-3)))
                                {
                                    return this.getNature(x, y);
                                }
                            }
                        }
                    }
                }
                else if(y==3)
                {
                    if(!isIn(cells_to_test,this.getNature(x, y-1)))
                    {
                        if(!isIn(cells_to_test,this.getNature(x, y-2)))
                        {
                            return this.getNature(x, y);
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void step()
    {
        Command commands = getLastCommand();
        if(commands != null)
        {
            switch(commands)
            {
                case FF:
                    forward();
                    break;
                case BB :
                    backward();
                    break;
                case LL:
                    strafeLeft();
                    break;
                case RR:
                    strafeRight();
                    break;
                case TL:
                    turnLeft();
                    break;
                case TR:
                    turnRight();
                    break;
                case AA:
                    attack();
                    break;
                case TK:
                    takeObject();
                    break;
            }
        }
    }

    @Override
    public void setLastCommand(Command command)
    {
        lastcommand = command;
    }

    @Override
    public void takeObject()
    {
    	System.out.println("Pcpqds");
        MotionlessObjectService opt = null;
        int x = -1;
        int y = -1;

        switch(getDir())
        {
            case N:
                x = getCol();
                y = getRow()+1;
                break;

            case S:
                x = getCol();
                y = getRow()-1;
                break;

            case E:
                x = getCol()+1;
                y = getRow();
                break;

            case W:
                x = getCol()-1;
                y = getRow();
                break;
        }

        opt = getEnvironment().getCellContent(x, y);

        if(opt instanceof MotionlessObjectService)
        {
            LootObjectService loot = opt.loot();

            if(loot instanceof PotionService)
            {
                potions.add((PotionService) loot);
                nbPotion++;
            }
            else inventaire.add(loot);
        }

        setLastCommand(Command.TK);
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
    public void attack()
    {
        switch(getDir())
        {
            case N:
                if(getEnvironment().getCellContent(getCol(), getRow() + 1) instanceof EntityService)
                {
                    ((EntityService) getEnvironment().getCellContent(getCol(), getRow() + 1)).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol(), getRow() + 1) instanceof MimicService)
                {
                    ((MimicService) getEnvironment().getCellContent(getCol(), getRow() + 1)).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol(), getRow() + 1) instanceof MotionlessObjectService)
                {
                    getEnvironment().getCellContent(getCol(), getRow() + 1).destroy();
                }
                break;

            case S:
                if(getEnvironment().getCellContent(getCol(), getRow() - 1) instanceof EntityService)
                {
                    ((EntityService) getEnvironment().getCellContent(getCol(), getRow() - 1)).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol(), getRow() - 1) instanceof MimicService)
                {
                    ((MimicService) getEnvironment().getCellContent(getCol(), getRow() - 1)).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol(), getRow() - 1) instanceof MotionlessObjectService)
                {
                    getEnvironment().getCellContent(getCol(), getRow() - 1).destroy();
                }
                break;

            case E:
                if(getEnvironment().getCellContent(getCol() + 1, getRow()) instanceof EntityService)
                {
                    ((EntityService) getEnvironment().getCellContent(getCol() + 1, getRow())).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol() + 1, getRow()) instanceof MimicService)
                {
                    ((MimicService) getEnvironment().getCellContent(getCol() + 1, getRow())).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol() + 1, getRow()) instanceof MotionlessObjectService)
                {
                    getEnvironment().getCellContent(getCol() + 1, getRow()).destroy();
                }
                break;

            case W:
                if(getEnvironment().getCellContent(getCol() - 1, getRow()) instanceof EntityService)
                {
                    ((EntityService) getEnvironment().getCellContent(getCol() - 1, getRow())).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol() - 1, getRow()) instanceof MimicService)
                {
                    ((MimicService) getEnvironment().getCellContent(getCol() - 1, getRow())).getDamage(getRightHand().getDamage());
                }

                if(getEnvironment().getCellContent(getCol() - 1, getRow()) instanceof MotionlessObjectService)
                {
                    getEnvironment().getCellContent(getCol(), getRow() - 1).destroy();
                }
                break;
        }
    }

    @Override
    public void getDamage(int nbDamage)
    {
        int enemyHeight = 0;

        switch(getDir())
        {
            case N:
                enemyHeight =  ((EntityService) getEnvironment().getCellContent(getCol(), getRow() + 1)).getHeight();
                break;

            case S:
                enemyHeight =  ((EntityService) getEnvironment().getCellContent(getCol(), getRow() - 1)).getHeight();
                break;

            case E:
                enemyHeight =  ((EntityService) getEnvironment().getCellContent(getCol() + 1, getRow())).getHeight();
                break;

            case W:
                enemyHeight =  ((EntityService) getEnvironment().getCellContent(getCol() - 1, getRow())).getHeight();
                break;
        }

        if(enemyHeight - height > 10)
        {
            if(helm != null)
            {
                hp = hp - nbDamage * (100/(100 + helm.getArmor()));
            }
            else
            {
                hp = hp - nbDamage;
            }
        }
        else if(height - enemyHeight > 10)
        {
            if(leg != null)
            {
                hp = hp - nbDamage * (100/(100 + leg.getArmor()));
            }
            else
            {
                hp = hp - nbDamage;
            }
        }
        else
        {
            if(chest != null)
            {
                hp = hp - nbDamage * (100/(100 + chest.getArmor()));
            }
            else
            {
                hp = hp - nbDamage;
            }
        }

        if(hp <= 0) destroy();
    }

    @Override
    public void forward()
    {
        switch(getDir())
        {
            case N:
                row++;
                break;

            case S:
                row--;
                break;

            case E:
                col++;
                break;

            case W:
                col--;
                break;
        }
    }

    @Override
    public void backward()
    {
        switch(getDir())
        {
            case N:
                row--;
                break;

            case S:
                row++;
                break;

            case E:
                col--;
                break;

            case W:
                col++;
                break;
        }
    }

    @Override
    public void turnLeft()
    {
        switch(getDir())
        {
            case N:
                dir = Dir.W;
                break;

            case S:
                dir = Dir.E;
                break;

            case E:
                dir = Dir.N;
                break;

            case W:
                dir = Dir.S;
                break;
        }
    }

    @Override
    public void turnRight()
    {
        switch(getDir())
        {
            case N:
                dir = Dir.E;
                break;
            case S:
                dir = Dir.W;
                break;

            case E:
                dir = Dir.S;
                break;

            case W:
                dir = Dir.N;
                break;
        }
    }

    @Override
    public void strafeLeft()
    {
        switch(getDir())
        {
            case N:
                col--;
                break;

            case S:
                col++;
                break;

            case E:
                row--;
                break;

            case W:
                row++;
                break;
        }
    }

    @Override
    public void strafeRight()
    {
        switch(getDir())
        {
            case N:
                col++;
                break;

            case S:
                col--;
                break;

            case E:
                row++;
                break;

            case W:
                row--;
                break;
        }
    }

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
        //Ne seras jamais appeler
    }

    @Override
    public LootObjectService loot()
    {
        return null;
        //Ne seras jamais appeler
    }

    @Override
    public LootObjectService destroy()
    {
        return null;
    }

    @Override
    public void drinkPotion()
    {
        int i = 0;
        PotionService p = potions.get(0);

        while(!p.isFull())
        {
            i++;
            p = potions.get(i);
        }

        hp = hp + 20;

        if(hp > hpMax) hp = hpMax;

        p.getDrinked();
    }

    @Override
    public int getNbPotion()
    {
        return nbPotion;
    }

    @Override
    public void equipHelm(Helms h)
    {
        helm = h;
    }

    @Override
    public void equipChest(ChestArmor ca)
    {
        chest = ca;
    }

    @Override
    public void equipLeg(LegArmor la)
    {
        leg = la;
    }

    @Override
    public void equipRightHand(WeaponService w)
    {
        rightHand = w;
    }

    @Override
    public void equipLeftHand(WeaponService w)
    {
        leftHand = w;
    }

    @Override
    public void unequipHelm()
    {
        helm = null;
    }

    @Override
    public void unequipChest()
    {
        chest = null;
    }

    @Override
    public void unequipLeg()
    {
        leg = null;
    }

    @Override
    public void unequipRightHand()
    {
        rightHand = null;
    }

    @Override
    public void unequipLeftHand()
    {
        leftHand = null;
    }

    @Override
    public ArmorPieceService getHelm()
    {
        return helm;
    }

    @Override
    public ArmorPieceService getChest()
    {
        return chest;
    }

    @Override
    public ArmorPieceService getLeg()
    {
        return leg;
    }

    @Override
    public WeaponService getRightHand()
    {
        return rightHand;
    }

    @Override
    public WeaponService getLeftHand()
    {
        return leftHand;
    }

    public void addLoot(LootObjectService loot)
    {
        inventaire.add(loot);
    }
}
