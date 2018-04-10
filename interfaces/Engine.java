package interfaces;

public interface Engine
{
    //Observateurs
    public Environment getEnvironment();
    public ArrayList<Entity> getEntities();
    public Entity getEntity(int i);

    //Constructeur
    public Engine init(Environment env);

    //Operateurs
    public Engine removeEntity(int i);
    public Engine addEntity(Entity ent);
    public Engine step();
}
