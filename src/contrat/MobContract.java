package contrat;

import interfaces.EnvironmentService;
import interfaces.MobService;
import myType.Cell;
import myType.Dir;

import java.util.Random;

import decorator.MobDecorator;
import exception.Contractor;

public class MobContract extends MobDecorator implements MobService
{
    Random rand;

    public MobContract(MobService delegate)
    {
        super(delegate);
        rand = new Random();
    }

    public void checkInvariant()
    {
        Cell current = getEnvironment().getCellNature(getCol(), getRow());

        if(getCol() < 0 || getCol() > getEnvironment().getHeight())
        {
            Contractor.defaultContractor().invariantError("MobContract","Le mob n'est pas dans la carte");
        }

        if(getRow() < 0 || getRow() > getEnvironment().getWidth())
        {
            Contractor.defaultContractor().invariantError("MobContract","Le mob n'est pas dans la carte");
        }

        if(current == Cell.WLL || current == Cell.DNC || current == Cell.DWC)
        {
            Contractor.defaultContractor().invariantError("MobContract","Le mob est dans une porte fermer ou dans un mur");
        }
    }

    public void init(EnvironmentService env, int x, int y, Dir dir)
    {
        checkInvariant();
        super.init(env, x, y, dir);
        checkInvariant();

        if(getEnvironment() != env)Contractor.defaultContractor().postconditionError("Mob", "init", "env");
        if(getCol() != x)Contractor.defaultContractor().postconditionError("Mob", "init", "x");
        if(getRow() != y)Contractor.defaultContractor().postconditionError("Mob", "init", "y");
        if(getDir() != dir)Contractor.defaultContractor().postconditionError("Mob", "init", "dir");
    }

    public void forward()
    {
        int xPre = getCol();
        int yPre = getCol();
        Dir dirPre = getDir();

        boolean peutAvancer = false;

        switch(dirPre)
        {
            case N:
                if((getEnvironment().getCellNature(xPre, yPre + 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre + 1) == Cell.DWO)
                && yPre + 1 < getEnvironment().getHeight()
                && getEnvironment().getCellContent(xPre, yPre + 1) == null)
                {
                    peutAvancer = true;
                }
                break;

            case S:
                if((getEnvironment().getCellNature(xPre, yPre - 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre - 1) == Cell.DWO)
                && yPre - 1 > 0
                && getEnvironment().getCellContent(xPre, yPre - 1) == null)
                {
                    peutAvancer = true;
                }
                break;

            case E:
                if((getEnvironment().getCellNature(xPre + 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre + 1, yPre) == Cell.DNO)
                && xPre + 1 < getEnvironment().getWidth()
                && getEnvironment().getCellContent(xPre + 1, yPre) == null)
                {
                    peutAvancer = true;
                }
                break;

            case W:
                if((getEnvironment().getCellNature(xPre - 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre - 1, yPre) == Cell.DNO)
                && xPre - 1 > 0
                && getEnvironment().getCellContent(xPre - 1, yPre) == null)
                {
                    peutAvancer = true;
                }
                break;
        }



        checkInvariant();
        super.forward();
        checkInvariant();

        switch(dirPre)
        {
            case N:
                if(peutAvancer)
                {
                    if(yPre + 1 != getRow())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai pas bouger N");
                    }
                    if(xPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai mal bouger N");
                    }
                }
                else
                {
                    if(xPre != getCol() || yPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'aurais pas du bouger N");
                    }
                }
                break;

            case S:
                if(peutAvancer)
                {
                    if(yPre - 1 != getRow())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai pas bouger S");
                    }
                    if(xPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai mal bouger S");
                    }
                }
                else
                {
                    if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'aurais pas du bouger S");
                    }
                }
                break;

            case E:
                if(peutAvancer)
                {
                    if(xPre + 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai pas bouger E");
                    }
                    if(yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai mal bouger E");
                    }
                }
                else
                {
                    if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "forward", "J'aurais pas du bouger E");
                    }
                }
                break;

                case W:
                    if(peutAvancer)
                    {
                        if(xPre - 1 != getCol())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai pas bouger W");
                        }
                        if(yPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "forward", "J'ai mal bouger W");
                        }
                    }
                    else
                    {
                        if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "forward", "J'aurais pas du bouger W");
                        }
                    }
                    break;
        }
    }

    public void backward()
    {
    	int xPre = getCol();
        int yPre = getCol();
        Dir dirPre = getDir();

        boolean peutReculer = false;

        switch(dirPre)
        {
            case N:
                if((getEnvironment().getCellNature(xPre, yPre - 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre - 1) == Cell.DWO)
                && yPre - 1 > 0
                && getEnvironment().getCellContent(xPre, yPre - 1) == null)
                {
                    peutReculer = true;
                }
                break;

            case S:
                if((getEnvironment().getCellNature(xPre, yPre + 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre + 1) == Cell.DWO)
                && yPre + 1 < getEnvironment().getHeight()
                && getEnvironment().getCellContent(xPre, yPre + 1) == null)
                {
                    peutReculer = true;
                }
                break;

            case E:
                if((getEnvironment().getCellNature(xPre - 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre - 1, yPre) == Cell.DNO)
                && xPre - 1 > 0
                && getEnvironment().getCellContent(xPre - 1, yPre) == null)
                {
                    peutReculer = true;
                }
                break;

            case W:
                if((getEnvironment().getCellNature(xPre + 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre + 1, yPre) == Cell.DNO)
                && xPre + 1 < getEnvironment().getWidth()
                && getEnvironment().getCellContent(xPre + 1, yPre) == null)
                {
                    peutReculer = true;
                }
                break;
        }



        checkInvariant();
        super.backward();
        checkInvariant();

        switch(dirPre)
        {
            case N:
                if(peutReculer)
                {
                    if(yPre - 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai pas bouger N");
                    }
                    if(xPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai mal bouger N");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'aurais pas du bouger N");
                    }
                }
                break;

            case S:
                if(peutReculer)
                {
                    if(yPre + 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai pas bouger S");
                    }
                    if(xPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai mal bouger S");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'aurais pas du bouger S");
                    }
                }
                break;

            case E:
                if(peutReculer)
                {
                    if(xPre - 1 != getRow())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai pas bouger E");
                    }
                    if(yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai mal bouger E");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "backward", "J'aurais pas du bouger E");
                    }
                }
                break;

                case W:
                    if(peutReculer)
                    {
                        if(xPre + 1 != getRow())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai pas bouger W");
                        }
                        if(yPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "backward", "J'ai mal bouger W");
                        }
                    }
                    else
                    {
                        if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "backward", "J'aurais pas du bouger W");
                        }
                    }
                    break;
        }
    }

    public void turnLeft()
    {
        checkInvariant();
        super.turnLeft();
        checkInvariant();
    }

    public void turnRight()
    {
        checkInvariant();
        super.turnRight();
        checkInvariant();
    }

    public void strafeLeft()
    {
    	int xPre = getCol();
        int yPre = getCol();
        Dir dirPre = getDir();

        boolean peutBougerGauche = false;

        switch(dirPre)
        {
            case N:
                if((getEnvironment().getCellNature(xPre - 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre - 1, yPre) == Cell.DWO)
                && xPre - 1 > 0
                && getEnvironment().getCellContent(xPre - 1, yPre) == null)
                {
                    peutBougerGauche = true;
                }
                break;

            case S:
                if((getEnvironment().getCellNature(xPre + 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre + 1, yPre) == Cell.DWO)
                && xPre + 1 < getEnvironment().getWidth()
                && getEnvironment().getCellContent(xPre + 1, yPre) == null)
                {
                    peutBougerGauche = true;
                }
                break;

            case E:
                if((getEnvironment().getCellNature(xPre, yPre - 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre - 1) == Cell.DNO)
                && yPre - 1 > 0
                && getEnvironment().getCellContent(xPre, yPre - 1) == null)
                {
                    peutBougerGauche = true;
                }
                break;

            case W:
                if((getEnvironment().getCellNature(xPre, yPre + 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre + 1) == Cell.DNO)
                && xPre + 1 < getEnvironment().getHeight() 
                && getEnvironment().getCellContent(xPre, yPre + 1) == null)
                {
                    peutBougerGauche = true;
                }
                break;
        }



        checkInvariant();
        super.strafeLeft();
        checkInvariant();

        switch(dirPre)
        {
            case N:
                if(peutBougerGauche)
                {
                    if(xPre - 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai pas bouger N");
                    }
                    if(yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai mal bouger N");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'aurais pas du bouger N");
                    }
                }
                break;

            case S:
                if(peutBougerGauche)
                {
                    if(xPre + 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai pas bouger S");
                    }
                    if(xPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai mal bouger S");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'aurais pas du bouger S");
                    }
                }
                break;

            case E:
                if(peutBougerGauche)
                {
                    if(yPre + 1 != getRow())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai pas bouger E");
                    }
                    if(yPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai mal bouger E");
                    }
                }
                else
                {
                    if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'aurais pas du bouger E");
                    }
                }
                break;

                case W:
                    if(peutBougerGauche)
                    {
                        if(yPre - 1 != getRow())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai pas bouger W");
                        }
                        if(yPre != getRow() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'ai mal bouger W");
                        }
                    }
                    else
                    {
                        if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeLeft", "J'aurais pas du bouger W");
                        }
                    }
                    break;
        }
    }

    public void strafeRight()
    {
    	int xPre = getCol();
        int yPre = getCol();
        Dir dirPre = getDir();

        boolean peutBougerDroite = false;

        switch(dirPre)
        {
            case N:
                if((getEnvironment().getCellNature(xPre + 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre + 1, yPre) == Cell.DWO)
                && xPre + 1 > 0
                && getEnvironment().getCellContent(xPre + 1, yPre) == null)
                {
                    peutBougerDroite = true;
                }
                break;

            case S:
                if((getEnvironment().getCellNature(xPre - 1, yPre) == Cell.EMP || getEnvironment().getCellNature(xPre - 1, yPre) == Cell.DWO)
                && xPre - 1 < getEnvironment().getWidth()
                && getEnvironment().getCellContent(xPre - 1, yPre) == null)
                {
                    peutBougerDroite = true;
                }
                break;

            case E:
                if((getEnvironment().getCellNature(xPre, yPre + 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre + 1) == Cell.DNO)
                && yPre + 1 > 0
                && getEnvironment().getCellContent(xPre, yPre + 1) == null)
                {
                    peutBougerDroite = true;
                }
                break;

            case W:
                if((getEnvironment().getCellNature(xPre, yPre - 1) == Cell.EMP || getEnvironment().getCellNature(xPre, yPre - 1) == Cell.DNO)
                && xPre - 1 < getEnvironment().getHeight() 
                && getEnvironment().getCellContent(xPre, yPre - 1) == null)
                {
                    peutBougerDroite = true;
                }
                break;
        }



        checkInvariant();
        super.strafeRight();
        checkInvariant();

        switch(dirPre)
        {
            case N:
                if(peutBougerDroite)
                {
                    if(xPre + 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai pas bouger N");
                    }
                    if(yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai mal bouger N");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'aurais pas du bouger N");
                    }
                }
                break;

            case S:
                if(peutBougerDroite)
                {
                    if(xPre - 1 != getCol())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai pas bouger S");
                    }
                    if(xPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai mal bouger S");
                    }
                }
                else
                {
                    if(xPre != getRow() || yPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'aurais pas du bouger S");
                    }
                }
                break;

            case E:
                if(peutBougerDroite)
                {
                    if(yPre - 1 != getRow())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai pas bouger E");
                    }
                    if(yPre != getRow() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai mal bouger E");
                    }
                }
                else
                {
                    if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                    {
                        Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'aurais pas du bouger E");
                    }
                }
                break;

                case W:
                    if(peutBougerDroite)
                    {
                        if(yPre + 1 != getRow())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai pas bouger W");
                        }
                        if(yPre != getRow() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'ai mal bouger W");
                        }
                    }
                    else
                    {
                        if(yPre != getRow() || xPre != getCol() || dirPre != getDir())
                        {
                            Contractor.defaultContractor().postconditionError("Mob", "strafeRight", "J'aurais pas du bouger W");
                        }
                    }
                    break;
        }
    }
}
