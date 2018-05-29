package contrat;

import decorator.MotionlessObjectDecorator;
import exception.Contractor;
import interfaces.EnvironmentService;
import interfaces.LootObjectService;
import interfaces.MotionlessObjectService;
import interfaces.PlayerService;
import myType.Dir;

public class MotionlessObjectContract extends MotionlessObjectDecorator implements MotionlessObjectService
{
    int x;
    int y;
    Dir dir;

    public MotionlessObjectContract(MotionlessObjectService delegate)
    {
        super(delegate);
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
        //Pre
        if(x < 0 || x > env.getWidth())
        {
            Contractor.defaultContractor().preconditionError("MotionlessObject","init","La largeur entrée n'est pas dans la map");
        }
        if(y < 0 || y > env.getHeight())
        {
            Contractor.defaultContractor().preconditionError("MotionlessObject","init"," hauteur entrée n'est pas dans la map");
        }

        this.x = x;
        this.y = y;
        this.dir = dir;

        super.init(env,x,y,dir);
    }

    public void checkInvariant()
    {
        if(super.getCol() != x)
        {
            Contractor.defaultContractor().invariantError("MotionlessObject", "L'objet à bouger en largeur.");
        }
        if(super.getRow() != y)
        {
            Contractor.defaultContractor().invariantError("MotionlessObject", "L'objet à bouger en hauteur.");
        }
        if(super.getDir() != dir)
        {
            Contractor.defaultContractor().invariantError("MotionlessObject", "L'objet à bouger en direction.");
        }
    }

    public LootObjectService loot()
    {
    	LootObjectService res = null;
        PlayerService player;

        if(super.getDir() == Dir.N)
        {
            if(super.getEnvironment().getCellContent(super.getCol(), super.getRow() + 1) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol(), super.getRow() + 1);
                if(player.getDir() == Dir.S)
                {
                    checkInvariant();
                    res = super.loot();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.S)
        {
            if(super.getEnvironment().getCellContent(super.getCol(), super.getRow() - 1) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol(), super.getRow() - 1);
                if(player.getDir() == Dir.N)
                {
                    checkInvariant();
                    res = super.loot();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.E)
        {
            if(super.getEnvironment().getCellContent(super.getCol() + 1, super.getRow()) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol() + 1, super.getRow());
                if(player.getDir() == Dir.W)
                {
                    checkInvariant();
                    res = super.loot();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.W)
        {
            if(super.getEnvironment().getCellContent(super.getCol() - 1, super.getRow()) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol() - 1, super.getRow());
                if(player.getDir() == Dir.E)
                {
                    checkInvariant();
                    res = super.loot();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "loot", "Il n'y a rien en face de l'objet.");
            }
        }
        
		return res;
    }

    public LootObjectService destroy()
    {
    	LootObjectService res = null;
        PlayerService player;

        if(super.getDir() == Dir.N)
        {
            if(super.getEnvironment().getCellContent(super.getCol(), super.getRow() + 1) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol(), super.getRow() + 1);
                if(player.getDir() == Dir.S)
                {
                    checkInvariant();
                    res = super.destroy();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.S)
        {
            if(super.getEnvironment().getCellContent(super.getCol(), super.getRow() - 1) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol(), super.getRow() - 1);
                if(player.getDir() == Dir.N)
                {
                    checkInvariant();
                    res = super.destroy();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.E)
        {
            if(super.getEnvironment().getCellContent(super.getCol() + 1, super.getRow()) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol() + 1, super.getRow());
                if(player.getDir() == Dir.W)
                {
                    checkInvariant();
                    res = super.destroy();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Il n'y a rien en face de l'objet.");
            }
        }

        if(super.getDir() == Dir.W)
        {
            if(super.getEnvironment().getCellContent(super.getCol() - 1, super.getRow()) instanceof PlayerService)
            {
                player = (PlayerService) super.getEnvironment().getCellContent(super.getCol() - 1, super.getRow());
                if(player.getDir() == Dir.E)
                {
                    checkInvariant();
                    res = super.destroy();
                    checkInvariant();
                }
                else
                {
                    Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Le joueur ne fait pas face a l'objet.");
                }
            }
            else
            {
                Contractor.defaultContractor().preconditionError("MotionlessObject", "destroy", "Il n'y a rien en face de l'objet.");
            }
        }
		return res;
    }
}
