package contrat;

import decorator.ArmorPieceDecorator;
import exception.Contractor;
import interfaces.ArmorPieceService;
import myType.ArmorSet;

public class ArmorPieceContract extends ArmorPieceDecorator implements ArmorPieceService
{

    public ArmorPieceContract(ArmorPieceService delegate)
    {
        super(delegate);
    }

    public void checkInvariant()
    {}

    public void init(String name, ArmorSet set, int armor, int hp)
    {
        if(armor < 0)
        {
            Contractor.defaultContractor().preconditionError("ArmorPieceService", "init", "L'armure bonus ne peut pas être négative.");
        }
        if(hp < 0)
        {
            Contractor.defaultContractor().preconditionError("ArmorPieceService", "init", "Les HP bonus ne peut pas être négatif.");
        }

        checkInvariant();
        super.init(name, set, armor, hp);
        checkInvariant();
    }
}
