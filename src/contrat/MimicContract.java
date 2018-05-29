package contrat;

import decorator.MimicDecorator;
import exception.Contractor;
import interfaces.EnvironmentService;
import interfaces.MimicService;
import myType.Dir;

public class MimicContract extends MimicDecorator implements MimicService
{
    public MimicContract(MimicService delegate)
    {
        super(delegate);
    }

    public void checkInvariant() {};
    
    public int getHP()
    {
    	return super.getHP();
    }
    
    public int getHeight()
    {
    	return super.getHeight();
    }
    
    public boolean isAwake()
    {
    	return super.isAwake();
    }
    
    public void getDamage(int nbDamage)
    {
    	if(super.getHP() <= 0)
    	{
    		Contractor.defaultContractor().preconditionError("Mimic", "getDamage", "Les hp sont déjà négatif ou nul.");
    	}
    	
    	checkInvariant();
    	super.getDamage(nbDamage);
    	checkInvariant();
    }

    @Override
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp)
    {
        if(hp != 10)
        {
            Contractor.defaultContractor().preconditionError("Mimic","init","Les hp ne sont pas égal a 10.");
        }

        checkInvariant();
        super.init(env,x,y,dir,hp);
        checkInvariant();
    }
}
