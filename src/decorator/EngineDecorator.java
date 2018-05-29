package decorator;

import java.util.ArrayList;

import interfaces.EngineService;
import interfaces.EnvironmentService;
import interfaces.EntityService;

public class EngineDecorator implements EngineService
{
    private EngineService delegate;

    public EngineDecorator(EngineService delegate)
    {
        this.delegate = delegate;
    }

    //Observateurs
    public EnvironmentService getEnvironment()
    {
        return delegate.getEnvironment();
    }

    public ArrayList<EntityService> getEntities()
    {
        return delegate.getEntities();
    }

    public EntityService getEntity(int i)
    {
        return delegate.getEntity(i);
    }

    //Constructeur
    public void init(EnvironmentService env)
    {
        delegate.init(env);
    }

    //Operateurs
    public void removeEntity(int i)
    {
        delegate.removeEntity(i);
    }

    public void addEntity(EntityService ent)
    {
        delegate.addEntity(ent);
    }

    public void step()
    {
        delegate.step();
    }
}
