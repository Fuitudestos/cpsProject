package interfaces;

import myType.Dir;

public interface MotionlessObjectService
{
    //Observateurs
    public EnvironmentService getEnvironment();
    public int getCol();
    public int getRow();
    public Dir getDir();

    //Constructeur
    public void init(EnvironmentService env, int x, int y, Dir dir);
    //Pre : 0 <= x < env.getWidth() and 0 <= y < env.getHeight()

    //Operateurs
    public LootObjectService loot();
    //Pre : M.getDir() = N => M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Player and P.getDir() = S
    //      M.getDir() = S => M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Player and P.getDir() = N
    //      M.getDir() = E => M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) = Player and P.getDir() = W
    //      M.getDir() = W => M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Player and P.getDir() = E

    public LootObjectService destroy();
    //Pre : M.getDir() = N => M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Player and P.getDir() = S
    //      M.getDir() = S => M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Player and P.getDir() = N
    //      M.getDir() = E => M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) = Player and P.getDir() = W
    //      M.getDir() = W => M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Player and P.getDir() = E

    //Observations

    //Invariants

    //M.getCol() = x
    //M.getRow() = y
    //M.getDir() = dir
}
