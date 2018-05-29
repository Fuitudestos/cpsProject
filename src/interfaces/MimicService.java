package interfaces;

import myType.Dir;

public interface MimicService extends /*includes*/ ChestService
{
	public int getHP();
	public int getHeight();
	public boolean isAwake();
	
    //Constructeur
    public void init(EnvironmentService env, int x, int y, Dir dir, int hp);
    //Pre : hp = 10

    public void attack();
    public void getDamage(int nbDamage);
    //Pre : M.getHP() > 0
    //Observations

    //Invariants
    //env.getCol() = x and env.getCol = y
}
