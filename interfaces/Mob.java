package interfaces;

public interface Mob
{
    //Observateurs
    public Environment getEnvironment();
    public int getCol();
    public int getRow();
    public Dir getDir();

    //Constructeur
    public Mob init(Environment env, int x, int y, Dir dir);
    //Pre : 0 <= x < env.getWidth() and 0 <= y < env.getHeight()

    //Operateurs
    public Mob forward();
    public Mob backward();
    public Mob turnLeft();
    public Mob turnRight();
    public Mob strafeLeft();
    public Mob strafeRight();

    //Observations

    //Invariants

    //0 <= M.getCol() < M.getEnvironment().getWidth()
    //0 <= M.getRow() < M.getEnvironment().getHeight()
    //M.getEnvironment().getCellNature(M.getCol(), M.getRow()) != {WLL, DNC, DWC}

    //Init

    //init(env,x,y,dir).getCol() = x
    //init(env,x,y,dir).getRow() = y
    //init(env,x,y,dir).getDir() = dir
    //init(env,x,y,dir).getEnvironment() = env
}
