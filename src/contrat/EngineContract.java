package contrat;

import java.util.ArrayList;

import decorator.EngineDecorator;
import exception.Contractor;
import interfaces.EngineService;
import interfaces.EntityService;
import interfaces.EnvironmentService;

public class EngineContract extends EngineDecorator
{

    public EngineContract(EngineService delegate)
    {
        super(delegate);
    }

    public void checkInvariants()
    {
        for(EntityService entity : this.getEntities())
        {
            if(entity.getEnvironment() != getEnvironment())
            {
                Contractor.defaultContractor().invariantError("EngineService", "Une entité n'est pas le bon environment");
            }

            int x = entity.getCol();
            int y = entity.getRow();

            if(getEnvironment().getCellContent(x, y) != entity)
            {
            	Contractor.defaultContractor().invariantError("EngineService", "Pas la même occurence d'entité trouver");
            }
        }
    }

    @Override
    public EnvironmentService getEnvironment()
    {
        return super.getEnvironment();
    }

    @Override
    public ArrayList<EntityService> getEntities()
    {
        return super.getEntities();
    }

    @Override
    public EntityService getEntity(int index)
    {
        return super.getEntity(index);
    }

    @Override
    public void init(EnvironmentService env)
    {
        checkInvariants();
        super.init(env);
        checkInvariants();

        if(this.getEnvironment() != env)
        {
           Contractor.defaultContractor().invariantError("EngineService", "L'initialisation a échoué");
        }
    }

    @Override
    public void removeEntity(int x)
    {
    	int sizeAtPre = this.getEntities().size();
    	
    	if(x < 0 || x > sizeAtPre)
    	{
    		Contractor.defaultContractor().preconditionError("EngineService", "removeEntity", "On ne peut pas supprimer ce qui n'existe pas");
    	}
        
        @SuppressWarnings("unchecked")
		ArrayList<EntityService> entitiesAtPre = (ArrayList<EntityService>) this.getEntities().clone();

        checkInvariants();
        super.removeEntity(x);
        checkInvariants();

        if(this.getEntities().size() != sizeAtPre - 1)
        {
        	Contractor.defaultContractor().postconditionError("EngineService", "removeEntity", "Mauvaise décrementation de la taille du tableau");
        }

        for(int k = 0; k < x ; k++)
        {
            if(this.getEntities().get(k) != entitiesAtPre.get(k))
            {
            	Contractor.defaultContractor().postconditionError("EngineService", "removeEntity", "Un élément qui aurait pas du a disparu");
            }
        }

        for(int k = x; k < this.getEntities().size() ; k++)
        {
            if(this.getEntities().get(k) != entitiesAtPre.get(k+1))
            {
            	Contractor.defaultContractor().postconditionError("EngineService", "removeEntity", "Un élément qui aurait pas du a disparu");
            }
        }
    }

    @Override
    public void addEntity(EntityService entity)
    {
        int sizeAtPre = this.getEntities().size();
        
        @SuppressWarnings("unchecked")
		ArrayList<EntityService> entitiesAtPre = (ArrayList<EntityService>) this.getEntities().clone();

        checkInvariants();
        super.addEntity(entity);
        checkInvariants();

        if(this.getEntities().size() != sizeAtPre+1)
        {
        	Contractor.defaultContractor().postconditionError("EngineService", "addEntity", "Mauvaise incrementation de la taille du tableau");
        }

        for(int k = 0; k <sizeAtPre;k++)
        {
            if(this.getEntities().get(k) != entitiesAtPre.get(k))
            {
            	Contractor.defaultContractor().postconditionError("EngineService", "addEntity", "Un élément qui aurait pas du a disparu");
            }
        }

        if(this.getEntities().get(sizeAtPre) != entity)
        {
        	Contractor.defaultContractor().postconditionError("EngineService", "addEntity", "Un élément qui aurait pas du a disparu");
        }
    }

    @Override
    public void step()
    {
        for(EntityService entity: this.getEntities())
        {
            if(entity.getHP() <= 0)
            {
            	Contractor.defaultContractor().preconditionError("Engine", "step", "Une vache morte ne peut pas marcher");
            }
        }
        
        checkInvariants();
        super.step();
        checkInvariants();
    }
}
