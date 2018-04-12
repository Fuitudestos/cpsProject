package contrat;

import interfaces.Mob;
import decorator.MobDecorator;

public class MobContract extends MobDecorator
{
    Random rand;

    public MobContract(Mob delegate)
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

        if(current == WLL || current == DNC || current == DWC)
        {
            Contractor.defaultContractor().invariantError("MobContract","Le mob est dans une porte fermer ou dans un mur");
        }
    }

    public Mob forward()
    {
        checkInvariant();
        super.forward();
        checkInvariant();
    }

    public Mob backward()
    {
        checkInvariant();
        super.backward();
        checkInvariant();
    }

    public Mob turnLeft()
    {
        checkInvariant();
        super.turnLeft();
        checkInvariant();
    }

    public Mob turnRight()
    {
        checkInvariant();
        super.turnRight();
        checkInvariant();
    }

    public Mob strafeLeft()
    {
        checkInvariant();
        super.strafeLeft();
        checkInvariant();
    }

    public Mob strafeRight()
    {
        checkInvariant();
        super.strafeRight();
        checkInvariant();
    }
}
