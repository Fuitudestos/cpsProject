package contrat;

import decorator.PlayerDecorator;
import exception.Contractor;
import implementation.ChestArmor;
import implementation.Environment;
import implementation.Helms;
import implementation.LegArmor;
import implementation.Player;
import interfaces.ArmorPieceService;
import interfaces.EntityService;
import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import interfaces.MobService;
import interfaces.MotionlessObjectService;
import interfaces.PlayerService;
import interfaces.WeaponService;
import myType.Cell;
import myType.Command;

public class PlayerContract extends PlayerDecorator implements PlayerService
{
    public PlayerContract(PlayerService delegate)
    {
        super(delegate);
    }

    public void checkInvariants()
    {
        switch(getDir())
        {
            case N:
                for(int x = -1; x < 1; x++)
                {
                    for(int y = -1; y < 3; y++)
                    {
                        if(getContent(x, y) != getEnvironment().getCellContent(getCol() + x, getRow() + y))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal le contenu du Nord.");
                        }
                        if(getNature(x, y) != getEnvironment().getCellNature(getCol() + x, getRow() + y))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal la nature du Nord.");
                        }
                    }
                }
                break;

            case S:
                for(int x = -1; x < 1; x++)
                {
                    for(int y = -1; y < 3; y++)
                    {
                        if(getContent(x, y) != getEnvironment().getCellContent(getCol() - x, getRow() - y))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal le contenu du Sud.");
                        }
                        if(getNature(x, y) != getEnvironment().getCellNature(getCol() - x, getRow() - y))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal la nature du Sud.");
                        }
                    }
                }
                break;

            case E:
                for(int x = -1; x < 1; x++)
                {
                    for(int y = -1; y < 3; y++)
                    {
                        if(getContent(x, y) != getEnvironment().getCellContent(getCol() + y, getRow() - x))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal le contenu de l'Est.");
                        }
                        if(getNature(x, y) != getEnvironment().getCellNature(getCol() + y, getRow() - x))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal la nature de l'Est.");
                        }
                    }
                }
                break;

            case W:
                for(int x = -1; x < 1; x++)
                {
                    for(int y = -1; y < 3; y++)
                    {
                        if(getContent(x, y) != getEnvironment().getCellContent(getCol() - y, getRow() + x))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal le contenu de l'Ouest.");
                        }
                        if(getNature(x, y) != getEnvironment().getCellNature(getCol() - y, getRow() + x))
                        {
                            Contractor.defaultContractor().invariantError("PlayerService", "Je voit mal la nature de l'Ouest.");
                        }
                    }
                }
                break;
        }

        for(int u =- 1; u < 1; u++)
        {
            for(int v = -1; v < 1; v++)
            {
                if(getViewable(u, v) != null)
                {
                    Contractor.defaultContractor().invariantError("PlayerService", "Tu ne devrais pas voir ça.");
                }
            }
        }

        if(getViewable(-1, 2) != null)
        {
            if(getNature(-1, 1) == Cell.WLL || getNature(-1, 1) == Cell.DWC || getNature(-1, 1) == Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }

        if(getViewable(0, 2) != null)
        {
            if(getNature(0, 1) == Cell.WLL || getNature(0, 1) == Cell.DWC || getNature(0, 1) == Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }

        if(getViewable(1, 2) != null)
        {
            if(getNature(1, 1) == Cell.WLL || getNature(1, 1) == Cell.DWC || getNature(1, 1) == Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }

        if(getViewable(-1, 3) != null)
        {
            if(getNature(-1, 2) == null)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Ne crois pas tes yeux, le pont est bien la");
            }

            if(this.getNature(-1, 2)==Cell.WLL||this.getNature(-1, 2)==Cell.DWC||this.getNature(-1, 2)==Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }

        if(getViewable(0, 3) != null)
        {
            if(getNature(0, 2) == null)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Ne crois pas tes yeux, le pont est bien la");
            }

            if(getNature(0, 2)==Cell.WLL||this.getNature(0, 2)==Cell.DWC||this.getNature(0, 2)==Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }

        if(getViewable(-1, 3) != null)
        {
            if(getNature(1, 2) == null)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Ne crois pas tes yeux, le pont est bien la");
            }

            if(getNature(1, 2) == Cell.WLL || getNature(1, 2) == Cell.DWC || getNature(1, 2) == Cell.DNC)
            {
                Contractor.defaultContractor().invariantError("PlayerService", "Pas de vision a travers les murs !");
            }
        }
    }

    @Override
    public Command getLastCommand()
    {
        return super.getLastCommand();
    }

    @Override
    public MotionlessObjectService getContent(int x, int y)
    {
        if(x > 1 || x < -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "getContent", "J'ai pas les yeux deriere la tête en x.");
        }
        if(y > 3 || y < -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "getContent", "J'ai pas les yeux deriere la tête en y.");
        }

        MotionlessObjectService res = super.getContent(x, y);

        return res;
    }

    @Override
    public Cell getNature(int x, int y)
    {
        if(x > 1 || x < -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "getNature", "J'ai pas les yeux deriere la tête en x.");
        }
        if(y > 3 || y< -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "getNature", "J'ai pas les yeux deriere la tête en y.");
        }

        Cell res = super.getNature(x, y);

        return res;
    }

    @Override
    public Cell getViewable(int x, int y)
    {
        if(x > 1 || x < -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "viewable", "J'ai pas les yeux deriere la tête en x.");
        }
        if(y > 3 || y < -1)
        {
            Contractor.defaultContractor().preconditionError("PlayerService", "viewable", "J'ai pas les yeux deriere la tête en y.");
        }

        Cell res = super.getViewable(x, y);

        return res;
    }

    public Cell isViewable(int x, int y)
    {
        return super.isViewable(x,y);
    }

    @Override
    public void step()
    {

        PlayerService playerPre = new Player();
        EnvironmentService env = new Environment();
        env.init(getEnvironment().getWidth(), getEnvironment().getHeight());
        playerPre.init(env, getCol(), getRow(), getDir(),getHP(), getHeight());

        MotionlessObjectService mobPre = null;
        int hpPre = -1;

        switch(getDir())
        {
            case N:
                if(getEnvironment().getCellContent(getCol(), getRow() + 1) != null)
                {
                    mobPre = getEnvironment().getCellContent(getCol(), getRow() + 1);

                    if(mobPre instanceof EntityService)
                    {
                        hpPre = ((EntityService) mobPre).getHP();
                    }
                }
                break;

            case S:
                if(getEnvironment().getCellContent(getCol(), getRow() - 1) != null)
                {
                    mobPre = getEnvironment().getCellContent(getCol(), getRow() - 1);

                    if(mobPre instanceof EntityService)
                    {
                        hpPre = ((EntityService) mobPre).getHP();
                    }
                }
                break;

            case E:
                if(getEnvironment().getCellContent(getCol() + 1, getRow()) != null)
                {
                    mobPre = getEnvironment().getCellContent(getCol() + 1, getRow());

                    if(mobPre instanceof EntityService)
                    {
                        hpPre = ((EntityService) mobPre).getHP();
                    }
                }
                break;

            case W:
                if(getEnvironment().getCellContent(getCol() - 1, getRow()) != null)
                {
                    mobPre = getEnvironment().getCellContent(getCol() - 1, getRow());

                    if(mobPre instanceof EntityService)
                    {
                        hpPre = ((EntityService) mobPre).getHP();
                    }
                }
                break;
        }

        checkInvariants();
        super.step();
        checkInvariants();

        Command c = getLastCommand();

        switch(c)
        {
            case FF:
                playerPre.forward();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mal avancé");
                }
                break;

             case BB :
                playerPre.backward();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mal reculé");
                }
                break;

            case LL:
                playerPre.strafeLeft();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mauvais pas chassé a gauche");
                }
                break;

            case RR:
                playerPre.strafeRight();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mauvais pas chassé a droite");
                }
                break;

            case TL:
                playerPre.turnLeft();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mal tourné a gauche");
                }
                break;

            case TR:
                playerPre.turnRight();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Mal tourné a gauche");
                }
                break;

            case AA:
                playerPre.attack();
                if(playerPre.getCol() != getCol() || playerPre.getRow() != getRow() || playerPre.getDir() != getDir())
                {
                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "BOUGE PAS J'AI DIS !");
                }

                if(hpPre != -1)
                {
                    switch(getDir())
                    {
                        case N:
                            if(getEnvironment().getCellContent(getCol(), getRow() + 1) != mobPre)
                            {
                                Contractor.defaultContractor().postconditionError("PlayerService", "step", "Il a disparu !");
                            }
                            else
                            {
                                if(((EntityService) getEnvironment().getCellContent(getCol(), getRow() + 1)).getHP() == hpPre)
                                {
                                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Je suis sûr de l'avoir toucher !");
                                }
                            }
                            break;

                        case S:
                            if(getEnvironment().getCellContent(getCol(), getRow() - 1) != mobPre)
                            {
                                Contractor.defaultContractor().postconditionError("PlayerService", "step", "Il a disparu !");
                            }
                            else
                            {
                                if(((EntityService) getEnvironment().getCellContent(getCol(), getRow() - 1)).getHP() == hpPre)
                                {
                                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Je suis sûr de l'avoir toucher !");
                                }
                            }
                            break;

                        case E:
                            if(getEnvironment().getCellContent(getCol() + 1, getRow()) != mobPre)
                            {
                                Contractor.defaultContractor().postconditionError("PlayerService", "step", "Il a disparu !");
                            }
                            else
                            {
                                if(((EntityService) getEnvironment().getCellContent(getCol() + 1, getRow())).getHP() == hpPre)
                                {
                                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Je suis sûr de l'avoir toucher !");
                                }
                            }
                            break;

                        case W:
                            if(getEnvironment().getCellContent(getCol() - 1, getRow()) != mobPre)
                            {
                                Contractor.defaultContractor().postconditionError("PlayerService", "step", "Il a disparu !");
                            }
                            else
                            {
                                if(((EntityService) getEnvironment().getCellContent(getCol() - 1, getRow())).getHP() == hpPre)
                                {
                                    Contractor.defaultContractor().postconditionError("PlayerService", "step", "Je suis sûr de l'avoir toucher !");
                                }
                            }
                            break;
                    }
                }
                break;

            default:
                break;
        }
    }

    public void setLastCommand(Command command)
    {
        checkInvariants();
        super.setLastCommand(command);
        checkInvariants();
    }

    public void takeObject()
    {
        //checkInvariants();
        super.takeObject();
        //checkInvariants();
    }

    public void drinkPotion()
    {
        checkInvariants();
        super.drinkPotion();
        checkInvariants();
    }

    public int getNbPotion()
    {
        checkInvariants();
        int res = super.getNbPotion();
        checkInvariants();

        return res;
    }

    public void equipHelm(Helms h)
    {
        checkInvariants();
        super.equipHelm(h);
        checkInvariants();
    }

    public void equipChest(ChestArmor ca)
    {
        checkInvariants();
        super.equipChest(ca);
        checkInvariants();
    }

    public void equipLeg(LegArmor la)
    {
        checkInvariants();
        super.equipLeg(la);
        checkInvariants();
    }

    public void equipRightHand(WeaponService w)
    {
        checkInvariants();
        super.equipRightHand(w);
        checkInvariants();
    }

    public void equipLeftHand(WeaponService w)
    {
        checkInvariants();
        super.equipLeftHand(w);
        checkInvariants();
    }

    public void unequipHelm()
    {
        checkInvariants();
        super.unequipHelm();
        checkInvariants();
    }

    public void unequipChest()
    {
        checkInvariants();
        super.unequipChest();
        checkInvariants();
    }

    public void unequipLeg()
    {
        checkInvariants();
        super.unequipLeg();
        checkInvariants();
    }

    public void unequipRightHand()
    {
        checkInvariants();
        super.unequipRightHand();
        checkInvariants();
    }

    public void unequipLeftHand()
    {
        checkInvariants();
        super.unequipLeftHand();
        checkInvariants();
    }

    public ArmorPieceService getHelm()
    {
        return super.getHelm();
    }

    public ArmorPieceService getChest()
    {
        return super.getChest();
    }

    public ArmorPieceService getLeg()
    {
        return super.getLeg();
    }

    public WeaponService getRightHand()
    {
        return super.getRightHand();
    }

    public WeaponService getLeftHand()
    {
        return super.getLeftHand();
    }
    
    public void addLoot(LootObjectService loot)
    {
    	super.addLoot(loot);
    }
}
