package contrat;

import decorator.EntityDecorator;
import exception.Contractor;
import interfaces.EntityService;
import interfaces.EnvironmentService;
import myType.Dir;

public class EntityContract extends EntityDecorator
{

    public EntityContract(EntityService delegate)
    {
        super(delegate);
    }
    
    public void checkInvariant() {}

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int height)
    {
        if(hp <= 0)
        {
        	Contractor.defaultContractor().preconditionError("EntityService", "init", "Personne nait mort");
        }
        if(height <= 0)
        {
        	Contractor.defaultContractor().preconditionError("EntityService", "init", "La taille soit être positive");
        }

        checkInvariant();
        super.init(env, x, y, dir, hp, height);
        checkInvariant();
    }

    @Override
    public void step()
    {
        super.step();
    }
}
