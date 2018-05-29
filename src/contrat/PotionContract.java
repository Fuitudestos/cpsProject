package contrat;

import decorator.PotionDecorator;
import exception.Contractor;
import interfaces.PotionService;

public class PotionContract extends PotionDecorator implements PotionService
{

    public PotionContract(PotionService delegate)
    {
        super(delegate);
    }

    public void checkInvariant()
    {}

    @Override
    public boolean isFull()
    {
        return super.isFull();
    }

    @Override
    public void getDrinked()
    {
        if(!isFull())
        {
            Contractor.defaultContractor().preconditionError("Potion", "getDrinked", "La potion est vide.");
        }

        checkInvariant();
        super.getDrinked();
        checkInvariant();

        if(isFull())
        {
            Contractor.defaultContractor().postconditionError("Potion", "getDrinked", "La potion ne c'est pas vider");
        }
    }

    @Override
    public void getFilled()
    {
        checkInvariant();
        super.getFilled();
        checkInvariant();

        if(!isFull())
        {
            Contractor.defaultContractor().postconditionError("Potion", "getFilled", "La potion ne c'est pas remplie");
        }
    }
}
