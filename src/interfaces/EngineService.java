package interfaces;

import java.util.ArrayList;

public interface EngineService
{
    //Observateurs
    public EnvironmentService getEnvironment();
    public ArrayList<EntityService> getEntities();
    public EntityService getEntity(int i);

    //Constructeur
    public void init(EnvironmentService env);

    //Operateurs
    public void removeEntity(int i);
    // Pre : E.removeEntity(i) require 0 <= i <= E.getEntities().size()
    public void addEntity(EntityService ent);
    public void step();
    // Pre : for(i = 0; i < E.getEntities().size()) => E.getEntity(i).getHP() > 0

    //Observations

    //Invariants :

    //for(i = 0; i < E.getEntities().size()) E.getEntity(i).getEnvironment() = E.getEnvironment()
    /*for(i = 0; i < E.getEntities().size()) E.getEntity(i).getCol() = x.
    and E.getEntity(i).getRow() = y.
    => E.getEnvironment().getCellContent(x,y) = E.getEntity(i)
    */

    //Post

    /* removeEntity : E.removeEntity(i).getEntities().size() = E.getEntities().size() - 1
                    for(k = 0; k < i; k++) E.removeEntity(i).getEntity(k) = E.getEntity(k)
                    for(k = i; k < E.getEntities().size() - 2) E.removeEntity(i).getEntity(k) = E.getEntity(k+1)
    */

    /* addEntity : E.addEntity(i).getEntities().size() = E.getEntities().size() + 1
                for(k = 0; k < E.getEntities().size()) E.addEntity(e).getEntity(k) = E.getEntity(k)
                E.addEntity(e).getEntity(E.getEntities().size() - 1) = e*/
}
