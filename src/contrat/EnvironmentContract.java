package contrat;

import decorator.EnvironmentDecorator;
import exception.Contractor;
import interfaces.EnvironmentService;
import interfaces.MotionlessObjectService;

public class EnvironmentContract extends EnvironmentDecorator
{
    public EnvironmentContract(EnvironmentService delegate)
    {
        super(delegate);
    }

    public void checkInvariant(){}

    @Override
    public void init(int width, int height)
    {
        super.init(width, height);
    }

    @Override
    public MotionlessObjectService getCellContent(int x, int y)
    {
        if(x < 0 || x >= getWidth())
        {
        	Contractor.defaultContractor().preconditionError("EnvironmentService", "getCellContent", "Vise dans la cuvette mec");
        }
        if(y < 0 || y >= getHeight())
        {
        	Contractor.defaultContractor().preconditionError("EnvironmentService", "getCellContent", "Vise dans la cuvette mec");

        }

        checkInvariant();
        MotionlessObjectService res = super.getCellContent(x, y);
        checkInvariant();
        
        return res;
    }
}
