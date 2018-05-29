package interfaces;

import myType.Dir;

public interface EntityService extends /*include*/ MobService
{
    //Observateurs
    public int getHP();
    public int getHeight();

    //Constructeur
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int height);
    // Pre :  0 <= x < env.getWidth() and 0 <= y < env.getHeight() and hp > 0 and height > 0

    //Operateurs
    public void step();
    public void attack();
    public void getDamage(int nbDamage);
  //Pre : E.getHP() > 0

    //Observations

    //Init
    //init(env,x,y,dir,hp).getHP() = hp

}
