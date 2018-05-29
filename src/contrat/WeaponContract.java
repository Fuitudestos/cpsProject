package contrat;

import decorator.WeaponDecorator;
import exception.Contractor;
import interfaces.WeaponService;
import myType.ArmorSet;

public class WeaponContract extends WeaponDecorator implements WeaponService
{

    public WeaponContract(WeaponService delegate)
    {
        super(delegate);
    }

    public void checkInvariant() {}

    public void init(String name, ArmorSet set, int damage, int hp)
    {
        if(damage < 0)
        {
            Contractor.defaultContractor().preconditionError("WeaponService", "init", "Les dégats ne peuvent pas être négatif");
        }
        if(hp < 0)
        {
            Contractor.defaultContractor().preconditionError("WeaponService", "init", "Les HP ne peuvent pas être négatif");
        }

        checkInvariant();
        super.init(name, set, damage, hp);
        checkInvariant();
    }

}
