package interfaces;

public interface Entity extends /*include*/ Mob
{
    //Observateurs
    public int getHP();

    //Constructeur
    public Entity init(Environment env, int x, int y, Dir dir, int hp)
    // Pre :  0 <= x < env.getWidth() and 0 <= y < env.getHeight() and hp > 0

    //Operateurs
    public Entity step()

    //Observations

    //Init
    //init(env,x,y,dir,hp).getHP() = hp

}
