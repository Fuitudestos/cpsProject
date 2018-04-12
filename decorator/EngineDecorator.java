package decorator;

import interfaces.Engine;

public abstract class EngineDecorator implements Engine
{
    private Engine delegate;

    public EngineDecorator(Engine delegate)
    {
        this.delegate = delegate;
    }

    //Observateurs
    public Environment getEnvironment()
    {
        return delegate.getEnvironment();
    }

    public ArrayList<Entity> getEntities()
    {
        return delegate.getEntities();
    }

    public Entity getEntity(int i)
    {
        return delegate.getEntity(i);
    }

    //Constructeur
    public Engine init(Environment env)
    {
        return delegate.init(env);
    }

    //Operateurs
    public Engine removeEntity(int i)
    {
        return delegate.removeEntity(i);
    }

    public Engine addEntity(Entity ent)
    {
        return delegate.addEntity(ent);
    }

    public Engine step()
    {
        return delegate.step();
    }
}
